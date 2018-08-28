package io.github.oleksivio.telegram.bot.core.controller.annotations.composer;

import org.springframework.stereotype.Controller;
import io.github.oleksivio.telegram.bot.core.controller.handler.Handler;
import io.github.oleksivio.telegram.bot.core.controller.processor.StatelessProcessor;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Controller
public class StatelessComposer {
    private final HandlerComposer handlerComposer;

    public StatelessComposer(HandlerComposer handlerComposer) {
        this.handlerComposer = handlerComposer;
    }

    public Optional<StatelessProcessor> create(Class<?> objClz, Object obj) {
        Collection<Handler> simpleHandlerList = new ArrayList<>();

        for (Method method : objClz.getDeclaredMethods()) {
            Optional<Handler> optionalHandler = handlerComposer.create(obj, method);
            if (!optionalHandler.isPresent()) {
                continue;
            }
            simpleHandlerList.add(optionalHandler.get());
        }

        if (simpleHandlerList.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(new StatelessProcessor(simpleHandlerList));
    }
}