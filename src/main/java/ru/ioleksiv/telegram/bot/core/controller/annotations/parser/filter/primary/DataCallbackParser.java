package ru.ioleksiv.telegram.bot.core.controller.annotations.parser.filter.primary;

import org.springframework.stereotype.Component;
import ru.ioleksiv.telegram.bot.api.annotations.filter.primary.CallbackQueryFilter;
import ru.ioleksiv.telegram.bot.api.annotations.filter.primary.MessageFilter;
import ru.ioleksiv.telegram.bot.api.annotations.filter.secondary.StringFilter;
import ru.ioleksiv.telegram.bot.api.model.objects.std.CallbackQuery;
import ru.ioleksiv.telegram.bot.core.controller.annotations.parser.filter.FilterParser;
import ru.ioleksiv.telegram.bot.core.controller.annotations.parser.finder.Finder;
import ru.ioleksiv.telegram.bot.core.controller.handler.check.Checker;
import ru.ioleksiv.telegram.bot.core.controller.handler.check.UnionChecker;

import java.util.Optional;

@Component
public class DataCallbackParser extends FilterParser<CallbackQueryFilter, CallbackQuery> {

    @Override
    public Checker<CallbackQuery> createChecker(CallbackQueryFilter annotation,
                                                Finder finder) {

        UnionChecker<CallbackQuery> unionChecker = new UnionChecker<>();

        StringFilter data = annotation.data();
        if (data.value().isActive()) {
            unionChecker.add(in -> Optional.ofNullable(in.getData()), finder.find(data));
        }
        StringFilter chatInstance = annotation.chatInstance();
        if (chatInstance.value().isActive()) {
            unionChecker.add(in -> Optional.ofNullable(in.getChatInstance()), finder.find(chatInstance));
        }
        StringFilter gameShortName = annotation.gameShortName();
        if (gameShortName.value().isActive()) {
            unionChecker.add(in -> Optional.ofNullable(in.getGameShortName()), finder.find(gameShortName));
        }
        StringFilter inlineMessageId = annotation.inlineMessageId();
        if (inlineMessageId.value().isActive()) {
            unionChecker.add(in -> Optional.ofNullable(in.getInlineMessageId()), finder.find(inlineMessageId));
        }
        MessageFilter message = annotation.message();
        if (message.value().isActive()) {
            unionChecker.add(in -> Optional.ofNullable(in.getMessage()), finder.find(message));
        }
        return unionChecker;
    }

    @Override
    public Class<CallbackQueryFilter> getAnnotationClass() {
        return CallbackQueryFilter.class;
    }

}


