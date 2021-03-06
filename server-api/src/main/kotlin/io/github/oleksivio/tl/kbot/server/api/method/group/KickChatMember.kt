package io.github.oleksivio.tl.kbot.server.api.method.group

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import io.github.oleksivio.tl.kbot.server.api.model.ApiDict
import io.github.oleksivio.tl.kbot.server.api.model.BooleanResponse
import io.github.oleksivio.tl.kbot.server.api.model.method.common.ChatAction
import io.github.oleksivio.tl.kbot.server.api.objects.ChatId

/**
 * @see [kickChatMember](https://core.telegram.org/bots/api/#kickchatmember)
 */
data class KickChatMember(
    /**
     * chat_id Integer or String Yes Unique identifier for the target chat or username of the target channel
     */
    @JsonProperty(ApiDict.CHAT_ID_KEY)
    override val chatId: ChatId,
    /**
     * user_id Integer Unique identifier of the target user
     */
    @JsonProperty(ApiDict.USER_ID_KEY)
    val userId: Long,
    /**
     * until_date [Integer] OptionalDate when the user will be unbanned, unix time. If user is
     * banned for more than 366 days or less than 30 seconds from the current time they are
     * considered to be banned forever
     */
    @JsonProperty(ApiDict.UNTIL_DATE_KEY)
    val untilDate: Long? = null
) : ChatAction<Boolean>() {

    @JsonIgnore
    override val resultWrapperClass = BooleanResponse::class

    @JsonProperty(ApiDict.METHOD_KEY)
    override val method = "kickChatMember"
}
