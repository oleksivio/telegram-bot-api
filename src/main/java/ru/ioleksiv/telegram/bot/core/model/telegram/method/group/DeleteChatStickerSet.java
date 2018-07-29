package ru.ioleksiv.telegram.bot.core.model.telegram.method.group;

import ru.ioleksiv.telegram.bot.core.controller.network.Networker;
import ru.ioleksiv.telegram.bot.core.model.telegram.method.interfaces.ChatAction;
import ru.ioleksiv.telegram.bot.core.model.telegram.responses.CommonResponse;
import ru.ioleksiv.telegram.bot.core.model.telegram.responses.ResponseCollection;

/**
 * @see <a href="https://core.telegram.org/bots/api#deletechatstickerset">deleteChatStickerSet</a>
 */
public class DeleteChatStickerSet extends ChatAction<Boolean> {
    private static final String METHOD = "deleteChatStickerSet";

    protected DeleteChatStickerSet(Networker networker) {
        super(METHOD, networker);
    }

    @Override
    public Class<? extends CommonResponse<Boolean>> getResultWrapperClass() {
        return ResponseCollection.BooleanResponse.class;
    }

    @Override
    public DeleteChatStickerSet setChatId(Long chatId) {
        pSetChatId(chatId);
        return this;
    }
}
