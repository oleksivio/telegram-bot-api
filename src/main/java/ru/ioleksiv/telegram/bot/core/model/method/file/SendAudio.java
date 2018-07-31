package ru.ioleksiv.telegram.bot.core.model.method.file;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.ioleksiv.telegram.bot.core.controller.network.Networker;
import ru.ioleksiv.telegram.bot.core.model.objects.std.keyboard.IKeyboard;

/**
 * @see <a href="https://core.telegram.org/bots/api#sendaudio">sendAudio</a>
 */
public class SendAudio extends ThumbAction {
    static final String METHOD = "sendAudio";
    /**
     * audio	 String	 	Audio file to send. Pass a file_id as String to send an
     * audio file that exists on the Telegram servers (recommended), pass an HTTP URL as a String
     * for Telegram to get an audio file from the Internet, or upload a new
     * one using multipart/form-data.
     */
    @JsonProperty("audio")
    private String audio = null;

    /**
     * duration	Integer	Optional	Duration of the audio in seconds
     */
    @JsonProperty("duration")
    private Integer duration = null;
    /**
     * performer	String	Optional	Performer
     */
    @JsonProperty("performer")
    private String performer = null;
    /**
     * title	String	Optional	Track name
     */
    @JsonProperty("title")
    private String title = null;

    public SendAudio(Networker networker) {
        super(METHOD, networker);
    }

    public Integer getDuration() {
        return duration;
    }

    public SendAudio setDuration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public String getPerformer() {
        return performer;
    }

    public SendAudio setPerformer(String performer) {
        this.performer = performer;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public SendAudio setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getAudio() {
        return audio;
    }

    public SendAudio setAudio(String audio) {
        this.audio = audio;
        return this;
    }

    @Override
    public SendAudio setThumb(String thumb) {
        pSetThumb(thumb);
        return this;
    }

    @Override
    public SendAudio setReplyMarkup(IKeyboard replyMarkup) {
        pSetReplyMarkup(replyMarkup);
        return this;
    }

    @Override
    public SendAudio setDisableNotification(Boolean disableNotification) {
        pSetDisableNotification(disableNotification);
        return this;
    }

    @Override
    public SendAudio setReplyToMessageId(Long replyToMessageId) {
        pSetReplyToMessageId(replyToMessageId);
        return this;
    }

    @Override
    public SendAudio setChatId(Long chatId) {
        pSetChatId(chatId);
        return this;
    }

    @Override
    public SendAudio setParseMode(String parseMode) {
        pSetParseMode(parseMode);
        return this;
    }

    @Override
    public SendAudio setCaption(String caption) {

        pSetCaption(caption);
        return this;
    }
}
