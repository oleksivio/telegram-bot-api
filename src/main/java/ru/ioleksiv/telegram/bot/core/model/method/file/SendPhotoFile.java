package ru.ioleksiv.telegram.bot.core.model.method.file;

import org.springframework.core.io.FileSystemResource;
import ru.ioleksiv.telegram.bot.core.controller.network.Networker;
import ru.ioleksiv.telegram.bot.core.model.objects.std.keyboard.IKeyboard;

/**
 * @see <a href="https://core.telegram.org/bots/api#sendphoto">sendPhoto</a>
 */
public class SendPhotoFile extends UploadMediaFile {
    private static final String METHOD = "sendPhoto";
    /**
     * photo	InputFile or String Photo to send. Pass a file_id as String to send a photo that
     * exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to
     * get a photo from the Internet, or upload a new photo using multipart/form-data.
     */
    private static final String PHOTO_KEY = "photo";

    public SendPhotoFile(Networker networker) {
        super(METHOD, networker);
    }

    public SendPhotoFile setPhoto(FileSystemResource photo) {
        putFile(PHOTO_KEY, photo);
        return this;
    }

    public SendPhotoFile setReplyMarkup(IKeyboard replyMarkup) {
        putReplyMarkup(replyMarkup);
        return this;
    }

    public SendPhotoFile setDisableNotification(Boolean disableNotification) {
        putBool(DISABLE_NOTIFICATION_KEY, disableNotification);
        return this;
    }

    public SendPhotoFile setReplyToMessageId(Long replyToMessageId) {
        putLong(REPLY_TO_MESSAGE_ID, replyToMessageId);
        return this;
    }

    public SendPhotoFile setChatId(Long chatId) {
        putLong(CHAT_ID_KEY, chatId);
        return this;
    }

    public SendPhotoFile setParseMode(String parseMode) {
        putString(PARSE_MODE_KEY, parseMode);
        return this;
    }

    public SendPhotoFile setCaption(String caption) {
        putString(CAPTION_KEY, caption);
        return this;
    }
}
