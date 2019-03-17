package io.github.oleksivio.telegram.bot.api.model.objects.std.sticker

import com.fasterxml.jackson.annotation.JsonProperty
import io.github.oleksivio.telegram.bot.api.annotations.filter.primitive.IntegerFilter
import io.github.oleksivio.telegram.bot.api.annotations.filter.primitive.StringFilter
import io.github.oleksivio.telegram.bot.api.annotations.filter.telegram.MaskPositionFilter
import io.github.oleksivio.telegram.bot.api.annotations.filter.telegram.PhotoFilter
import io.github.oleksivio.telegram.bot.api.model.objects.std.files.PhotoSize
import io.github.oleksivio.telegram.bot.core.model.ITelegram

/**
 * @see [Sticker](https://core.telegram.org/bots/api/#sticker)
 */
data class Sticker(
        /**
         * To setup filter:
         *
         * @see MaskPositionFilter maskPosition mask_position MaskPosition Optional. For mask stickers, the position where the
         * mask should be placed
         */
        @JsonProperty("mask_position")
        var maskPosition: MaskPosition? = null,
        /**
         * file_id String Unique identifier for this files
         */
        @JsonProperty("file_id")
        var fileId: String? = null,
        /**
         * To setup filter:
         *
         * @see IntegerFilter width width Integer Sticker width
         */
        @JsonProperty("width")
        var width: Int? = null,
        /**
         * To setup filter:
         *
         * @see IntegerFilter height height Integer Sticker height
         */
        @JsonProperty("height")
        var height: Int? = null,
        /**
         * To setup filter:
         *
         * @see PhotoFilter thumb thumb PhotoSize Optional. Sticker thumbnail in the .webp or .jpg format
         */
        @JsonProperty("thumb")
        var thumb: PhotoSize? = null,
        /**
         * To setup filter:
         *
         * @see StringFilter emoji emoji String Optional. Emoji associated with the sticker
         */
        @JsonProperty("emoji")
        var emoji: String? = null,
        /**
         * To setup filter:
         *
         * @see StringFilter setName set_name String Optional. Name of the sticker set to which the sticker belongs
         */
        @JsonProperty("set_name")
        var setName: String? = null,
        /**
         * To setup filter:
         *
         * @see IntegerFilter fileSize file_size Integer Optional. File size
         */
        @JsonProperty("file_size")
        var fileSize: Int? = null
) : ITelegram
