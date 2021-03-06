package io.github.oleksivio.tl.kbot.core.controller.annotations.parser.producer

import io.github.oleksivio.tl.kbot.core.controller.handler.invoke.Invoker
import io.github.oleksivio.tl.kbot.core.controller.handler.invoke.ResultInvoker
import io.github.oleksivio.tl.kbot.core.controller.handler.invoke.VoidInvoker
import io.github.oleksivio.tl.kbot.core.model.result.HandlerResult
import io.github.oleksivio.tl.kbot.server.api.model.ITelegram
import org.slf4j.LoggerFactory
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.jvm.javaMethod

class InvokerProducer {

    fun <ARG : ITelegram> create(
        func: KFunction<*>,
        classInstance: Any,
        argClass: KClass<ARG>
    ): Invoker<ARG>? {

        val funcArgsTypes = func.javaMethod?.parameterTypes ?: return null



        if (funcArgsTypes.size != 1) {
            LOG.error(" Invalid parameter count for method $func")
            return null
        }

        if (funcArgsTypes[0].kotlin != argClass) {
            LOG.error(" Invalid parameter type for method $func")
            return null
        }

        return if (func.returnType == HandlerResult::class)
            ResultInvoker(classInstance, func)
        else
            VoidInvoker(classInstance, func)
    }

    companion object {
        private val LOG = LoggerFactory.getLogger(InvokerProducer::class.java)
    }
}
