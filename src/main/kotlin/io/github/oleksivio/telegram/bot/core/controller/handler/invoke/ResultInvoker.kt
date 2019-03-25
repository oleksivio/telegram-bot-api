package io.github.oleksivio.telegram.bot.core.controller.handler.invoke

import io.github.oleksivio.telegram.bot.api.model.result.HandlerResult
import io.github.oleksivio.telegram.bot.core.model.ITelegram

import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method
import kotlin.reflect.KFunction

class ResultInvoker<ARG : ITelegram>(classInstance: Any,
                                     func: KFunction<*>) : Invoker<ARG>(classInstance, func) {

    @Throws(InvocationTargetException::class, IllegalAccessException::class)
    override fun invokeFunction(classInstance: Any,
                                method: Method,
                                argument: ARG): HandlerResult {
        return method.invoke(classInstance, argument) as HandlerResult
    }
}