package ru.ioleksiv.telegram.bot.core.model.method.sticker;

import org.springframework.core.io.FileSystemResource;
import ru.ioleksiv.telegram.bot.core.controller.network.Networker;
import ru.ioleksiv.telegram.bot.core.model.method.interfaces.UploadMessageFile;
import ru.ioleksiv.telegram.bot.core.model.objects.std.keyboard.IKeyboard;

/**
 * @see <a href="https://core.telegram.org/bots/api#sendsticker>sendSticker</a>
 */
public class SendStickerFile extends UploadMessageFile {
    private static final String METHOD = "sendSticker";
    /**
     * sticker	InputFile	Yes	Sticker to send. Upload a new one using multipart/form-data.
     */
    private static final String STIKER_KEY = "sticker";

    public SendStickerFile(Networker networker) {
        super(METHOD, networker);
    }

    public SendStickerFile setSticker(FileSystemResource sticker) {
        putFile(STIKER_KEY, sticker);
        return this;
    }

    public SendStickerFile setReplyMarkup(IKeyboard replyMarkup) {
        putReplyMarkup(replyMarkup);
        return this;
    }

    protected SendStickerFile setDisableNotification(Boolean disableNotification) {
        putBool(DISABLE_NOTIFICATION_KEY, disableNotification);
        return this;
    }

    protected SendStickerFile setReplyToMessageId(Long replyToMessageId) {
        putLong(REPLY_TO_MESSAGE_ID, replyToMessageId);
        return this;
    }

    public SendStickerFile setChatId(Long chatId) {
        putLong(CHAT_ID_KEY, chatId);
        return this;
    }
}
