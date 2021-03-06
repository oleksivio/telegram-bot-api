package io.github.oleksivio.tl.kbot.server.api.objects.std.sticker

import com.fasterxml.jackson.annotation.JsonProperty
import io.github.oleksivio.tl.kbot.server.api.model.ITelegram
import io.github.oleksivio.tl.kbot.server.api.objects.std.files.PhotoSize

/**
 *  [Sticker](https://core.telegram.org/bots/api/#sticker)
 */
data class Sticker(
    /**
     * To setup filter:
     *
     *  MaskPositionFilter maskPosition mask_position MaskPosition Optional. For mask stickers, the position where the
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
     *  IntegerFilter width width Integer Sticker width
     */
    @JsonProperty("width")
    var width: Int? = null,
    /**
     * To setup filter:
     *
     *  IntegerFilter height height Integer Sticker height
     */
    @JsonProperty("height")
    var height: Int? = null,
    /**
     * To setup filter:
     *
     *  PhotoFilter thumb thumb PhotoSize Optional. Sticker thumbnail in the .webp or .jpg format
     */
    @JsonProperty("thumb")
    var thumb: PhotoSize? = null,
    /**
     * To setup filter:
     *
     *  StringFilter emoji emoji [String] Optional. Emoji associated with the sticker
     */
    @JsonProperty("emoji")
    var emoji: String? = null,
    /**
     * To setup filter:
     *
     *  StringFilter setName set_name [String] Optional. Name of the sticker set to which the sticker belongs
     */
    @JsonProperty("set_name")
    var setName: String? = null,
    /**
     * To setup filter:
     *
     *  IntegerFilter fileSize file_size Integer Optional. File size
     */
    @JsonProperty("file_size")
    var fileSize: Int? = null
) : ITelegram
