package io.github.oleksivio.tl.kbot.server.api.method.message

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import io.github.oleksivio.tl.kbot.server.api.model.ApiDict
import io.github.oleksivio.tl.kbot.server.api.model.MessageResponse
import io.github.oleksivio.tl.kbot.server.api.model.method.common.EditAction
import io.github.oleksivio.tl.kbot.server.api.objects.ChatId
import io.github.oleksivio.tl.kbot.server.api.objects.std.Message
import io.github.oleksivio.tl.kbot.server.api.objects.std.keyboard.InlineKeyboardMarkup

/**
 * @see [editMessageReplyMarkup](https://core.telegram.org/bots/api/#editmessagereplymarkup)
 */
class EditMessageReplyMarkup(
    /**
     * chat_id Integer or [String] Optional Required if inline_message_id is not specified.
     * Unique identifier for the target chat
     */
    @JsonProperty(ApiDict.CHAT_ID_KEY)
    override val chatId: ChatId? = null,
    /**
     * message_id [Integer] OptionalRequired if inline_message_id is not specified. Identifier of the sent message
     */
    @JsonProperty(ApiDict.MESSAGE_ID_KEY)
    override val messageId: Long? = null,
    /**
     * inline_message_id [String] Optional Required if chat_id and message_id are not specified.
     * Identifier of the inline message
     */
    @JsonProperty(ApiDict.INLINE_MESSAGE_ID_KEY)
    override val inlineMessageId: String? = null,
    /**
     * reply_markup InlineKeyboardMarkup Optional A JSON-serialized object for an inline keyboard.
     */
    @JsonProperty(ApiDict.REPLY_MARKUP_KEY)
    override val inlineKeyboardMarkup: InlineKeyboardMarkup? = null
) : EditAction<Message>() {

    @JsonProperty(ApiDict.METHOD_KEY)
    override val method = "editMessageReplyMarkup"
    @JsonIgnore
    override val resultWrapperClass = MessageResponse::class
}


