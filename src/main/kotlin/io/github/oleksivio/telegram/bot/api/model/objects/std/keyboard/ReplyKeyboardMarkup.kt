package io.github.oleksivio.telegram.bot.api.model.objects.std.keyboard

import com.fasterxml.jackson.annotation.JsonProperty
import io.github.oleksivio.telegram.bot.api.model.objects.std.keyboard.row.ReplyButtonRow

/**
 * @see [ReplyKeyboardMarkup](https://core.telegram.org/bots/api/#replykeyboardmarkup)
 */
data class ReplyKeyboardMarkup(
        /**
         * keyboard Array of Array of KeyboardButton Array of button rows, each represented by an Array of KeyboardButton
         * objects
         */
        @JsonProperty("keyboard")
        var keyboard: MutableList<ReplyButtonRow> = mutableListOf(ReplyButtonRow()),
        /**
         * resize_keyboard Boolean Optional. Requests clients to resize the keyboard vertically for optimal fit (e.g., make
         * the keyboard smaller if there are just two rows of buttons). Defaults to false, in which case the custom keyboard
         * is always of the same height as the app's standard keyboard.
         */
        @JsonProperty("resize_keyboard")
        var resizeKeyboard: Boolean? = null,
        /**
         * one_time_keyboard Boolean Optional. Requests clients to hide the keyboard as soon as it's been used. The keyboard
         * will still be available, but clients will automatically display the usual letter-keyboard in the chat – the user
         * can press a special button in the input field to see the custom keyboard again. Defaults to false.
         */
        @JsonProperty("one_time_keyboard")
        var oneTimeKeyboard: Boolean? = null,
        /**
         * selective Boolean Optional. Use this parameter if you want to show the keyboard to specific users only. Targets: 1)
         * users that are @mentioned in the text of the Message object; 2) if the bot's message is a reply (has
         * reply_to_message_id), sender of the original message.
         */
        @JsonProperty("selective")
        var selective: Boolean? = null

) : IKeyboard {

    fun addRow(row: ReplyButtonRow) {
        keyboard.add(row)
    }

}
