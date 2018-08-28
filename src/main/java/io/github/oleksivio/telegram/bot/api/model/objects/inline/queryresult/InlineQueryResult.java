package io.github.oleksivio.telegram.bot.api.model.objects.inline.queryresult;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.oleksivio.telegram.bot.api.model.objects.std.keyboard.InlineKeyboardMarkup;
import io.github.oleksivio.telegram.bot.core.model.ITelegram;

public abstract class InlineQueryResult implements ITelegram {
    /**
     * type String Type of the result, must be article
     */
    @JsonProperty("type")
    private final String type;
    /**
     * id String Unique identifier for this result, 1-64 bytes
     */
    @JsonProperty("id")
    private String id = null;
    /**
     * reply_markup InlineKeyboardMarkup Optional. Inline keyboard attached to the message
     */
    @JsonProperty("reply_markup")
    private InlineKeyboardMarkup replyMarkup = null;

    InlineQueryResult(String type) {
        this.type = type;
    }

    public final String getType() {
        return type;
    }

    public final String getId() {
        return id;
    }

    public final void setId(String id) {
        this.id = id;
    }

    public final InlineKeyboardMarkup getReplyMarkup() {
        return replyMarkup;
    }

    public final void setReplyMarkup(InlineKeyboardMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
    }

}