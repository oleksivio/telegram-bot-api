package io.github.oleksivio.tl.kbot.core.controller.handler.invoke

import io.github.oleksivio.tl.kbot.core.model.result.HandlerResult
import io.github.oleksivio.tl.kbot.server.api.model.ITelegram
import org.slf4j.LoggerFactory
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method
import kotlin.reflect.KFunction
import kotlin.reflect.jvm.javaMethod

abstract class Invoker<ARG : ITelegram> internal constructor(
    private val classInstance: Any,
    private val func: KFunction<*>
) {

    fun run(argument: ARG): HandlerResult {
        val method = func.javaMethod ?: throw IllegalStateException("Java method not found")
        try {
            return invokeFunction(classInstance, method, argument)
        } catch (e: IllegalAccessException) {
            val invalidBehaviorException = IllegalStateException("Can't run method $func")
            LOG.error("", e)
            throw invalidBehaviorException
        } catch (e: InvocationTargetException) {
            val invalidBehaviorException = IllegalStateException("Can't run method $func")
            LOG.error("", e)
            throw invalidBehaviorException
        } catch (ignored: ClassCastException) {
            val invalidBehaviorException = IllegalStateException(
                "Invalid result type of method. "
                        + "HandlerResult or void was expected "
                        + func
            )
            LOG.error("", invalidBehaviorException)
            throw invalidBehaviorException
        }
    }

    @Throws(InvocationTargetException::class, IllegalAccessException::class)
    protected abstract fun invokeFunction(
        classInstance: Any,
        method: Method,
        argument: ARG
    ): HandlerResult

    companion object {
        private val LOG = LoggerFactory.getLogger(Invoker::class.java)
    }
}
