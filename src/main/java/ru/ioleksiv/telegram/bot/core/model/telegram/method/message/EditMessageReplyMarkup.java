package ru.ioleksiv.telegram.bot.core.model.telegram.method.message;

import ru.ioleksiv.telegram.bot.core.controller.network.Networker;
import ru.ioleksiv.telegram.bot.core.model.telegram.method.interfaces.EditAction;
import ru.ioleksiv.telegram.bot.core.model.telegram.objects.type.keyboard.InlineKeyboardMarkup;

/**
 * @see <a href="https://core.telegram.org/bots/api#editmessagereplymarkup">editMessageReplyMarkup</a>
 */
abstract class EditMessageReplyMarkup<RES> extends EditAction<RES> {
    private static final String METHOD = "editMessageReplyMarkup";

    EditMessageReplyMarkup(Networker networker) {
        super(METHOD, networker);
    }

    @Override
    public EditMessageReplyMarkup<RES> setMessageId(Long messageId) {
        pSetMessageId(messageId);
        return this;
    }

    @Override
    public EditMessageReplyMarkup<RES> setInlineMessageId(Long inlineMessageId) {
        pSetInlineMessageId(inlineMessageId);
        return this;
    }

    @Override
    public EditMessageReplyMarkup<RES> setInlineKeyboardMarkup(InlineKeyboardMarkup inlineKeyboardMarkup) {
        pSetInlineKeyboardMarkup(inlineKeyboardMarkup);
        return this;
    }

    @Override
    public EditMessageReplyMarkup<RES> setChatId(Long chatId) {
        pSetChatId(chatId);
        return this;
    }
}
