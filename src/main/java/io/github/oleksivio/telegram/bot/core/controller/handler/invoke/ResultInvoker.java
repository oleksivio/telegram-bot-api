package io.github.oleksivio.telegram.bot.core.controller.handler.invoke;

import io.github.oleksivio.telegram.bot.api.model.result.HandlerResult;
import io.github.oleksivio.telegram.bot.core.model.ITelegram;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ResultInvoker<ARG extends ITelegram> extends Invoker<ARG> {

    public ResultInvoker(Object classInstance,
                         Method method) {
        super(classInstance, method);
    }

    @Override
    protected HandlerResult invoke(Object classInstance,
                                   Method method,
                                   ARG argument)
            throws InvocationTargetException, IllegalAccessException {
        return (HandlerResult) method.invoke(classInstance, argument);
    }
}