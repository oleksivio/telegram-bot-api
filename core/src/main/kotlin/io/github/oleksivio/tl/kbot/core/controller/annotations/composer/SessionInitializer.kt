package io.github.oleksivio.tl.kbot.core.controller.annotations.composer

import io.github.oleksivio.tl.kbot.core.annotations.behavior.Session
import io.github.oleksivio.tl.kbot.core.controller.handler.Handler
import io.github.oleksivio.tl.kbot.core.controller.processor.session.ChatSession
import io.github.oleksivio.tl.kbot.core.controller.processor.session.OrderManager
import io.github.oleksivio.tl.kbot.core.controller.processor.session.SessionManager
import io.github.oleksivio.tl.kbot.core.controller.processor.session.SessionProcessor
import io.github.oleksivio.tl.kbot.core.controller.processor.session.UserSession
import io.github.oleksivio.tl.kbot.core.model.annotation.SessionType
import io.github.oleksivio.tl.kbot.server.api.model.ITelegram
import java.util.HashMap
import kotlin.reflect.KClass
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.functions

class SessionInitializer(
    private val handlerCreator: HandlerCreator,
    private val sessionProcessor: SessionProcessor
) {

    fun init(objClz: KClass<*>, obj: Any) {
        var initialHandler: Handler<*>? = null
        var cancelHandler: Handler<*>? = null

        val handlerMap = HashMap<Int, MutableList<Handler<*>>>()
        val errorMap = HashMap<Int, Handler<*>>()

        val sessionType = objClz.findAnnotation<Session>()?.value ?: return


        for (func in objClz.functions) {

            val handler = handlerCreator.create<ITelegram>(obj, func) ?: continue


            when {
                func.findAnnotation<Session.Initial>() != null -> initialHandler = handler
                func.findAnnotation<Session.Cancel>() != null -> cancelHandler = handler
                func.findAnnotation<Session.Order>() != null -> {
                    //todo fixme two findAnnotation call

                    val order = func.findAnnotation<Session.Order>()?.value
                    order?.let {
                        val handlers = handlerMap.computeIfAbsent(it) { mutableListOf() }
                        handlers.add(handler)
                    }
                }
                func.findAnnotation<Session.Error>() != null -> {
                    val errorOrder = func.findAnnotation<Session.Error>()?.value

                    check(
                        errorMap,
                        errorOrder!!
                    )

                    errorMap[errorOrder] = handler
                }
            }
        }

        check(
            objClz,
            initialHandler,
            cancelHandler,
            handlerMap,
            errorMap
        )

        val orderManager = OrderManager(handlerMap, errorMap)

        val sessionManager =
            createSession(
                sessionType,
                orderManager,
                initialHandler!!,
                cancelHandler!!
            )
        sessionProcessor.add(sessionManager)
    }

    companion object {

        private fun check(errorMap: Map<Int, Handler<*>>, errorOrder: Int) {
            if (errorMap.containsKey(errorOrder)) {
                throw IllegalArgumentException("Can't be more than one error receivers")
            }
        }

        private fun createSession(
            type: SessionType,
            orderManager: OrderManager,
            initialHandler: Handler<*>,
            cancelHandler: Handler<*>
        ): SessionManager {
            return when (type) {
                SessionType.USER -> {
                    UserSession(orderManager, initialHandler, cancelHandler)
                }
                SessionType.CHAT -> {
                    ChatSession(orderManager, initialHandler, cancelHandler)
                }
            }
        }

        @Throws(IllegalArgumentException::class)
        private fun check(
            objClz: KClass<*>,
            initialHandler: Handler<*>?,
            cancelHandler: Handler<*>?,
            orderMap: Map<Int, List<Handler<*>>>?,
            errorMap: Map<Int, Handler<*>>
        ) {
            if (orderMap == null || orderMap.isEmpty()) {
                throw IllegalArgumentException(
                    "Invalid session state in ${objClz.simpleName}. " +
                            "Can't be less than one  Session Order method's"
                )
            }

            for (index in errorMap.keys) {
                if (!orderMap.keys.contains(index)) {
                    throw IllegalArgumentException(
                        "Invalid session error state in ${objClz.simpleName}. " +
                                "Can't be Session Error and Session Order" +
                                " must have same index"
                    )
                }
            }

            if (initialHandler == null) {
                throw IllegalArgumentException(
                    "Invalid session state in ${objClz.simpleName}. " +
                            "Can't be less than one" +
                            " Session Initial method's"
                )
            }

            if (cancelHandler == null) {
                throw IllegalArgumentException(
                    "Invalid session state in ${objClz.simpleName}. " +
                            "Can't be less than one" +
                            " Session Cancel method's"
                )
            }
        }
    }
}
