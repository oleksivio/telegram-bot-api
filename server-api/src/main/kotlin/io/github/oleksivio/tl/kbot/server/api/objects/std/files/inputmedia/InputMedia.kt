package io.github.oleksivio.tl.kbot.server.api.objects.std.files.inputmedia

import com.fasterxml.jackson.annotation.JsonProperty
import io.github.oleksivio.tl.kbot.server.api.model.ITelegram
import io.github.oleksivio.tl.kbot.server.api.objects.InputFile

sealed class InputMedia : ITelegram {

    abstract var type: String?

    abstract var media: InputFile?

    abstract var caption: String?

    abstract var parseMode: String?
}

/**
 *  [InputMediaAudio](https://core.telegram.org/bots/api/#inputmediaaudio)
 */
data class InputMediaAudio(
    /**
     * type String Type of the result, must be audio
     */
    @JsonProperty("type")
    override var type: String? = null,
    /**
     * media String File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an
     * HTTP URL for Telegram to get a file from the Internet, or pass "attach://<file_attach_name>" to upload a new one
     * using multipart/form-data under <file_attach_name> name.
    </file_attach_name></file_attach_name> */
    @JsonProperty("media")
    override var media: InputFile? = null,
    /**
     * thumb InputFile or [String] Optional. Thumbnail of the file sent. The thumbnail should be in JPEG format and less
     * than 200 kB in size. A thumbnail‘s width and height should not exceed 90. Ignored if the file is not uploaded using
     * multipart/form-data. Thumbnails can’t be reused and can be only uploaded as a new file, so you can pass
     * “attach://<file_attach_name>” if the thumbnail was uploaded using multipart/form-data under <file_attach_name>.
    </file_attach_name></file_attach_name> */
    @JsonProperty("thumb")
    var thumb: InputMedia? = null,
    /**
     * caption [String] Optional. Caption of the video to be sent, 0-200 characters
     */
    @JsonProperty("caption")
    override var caption: String? = null,
    /**
     * parse_mode [String] Optional. Send Markdown or HTML, if you want Telegram apps to show bold, italic, fixed-width text
     * or inline URLs in the media caption.
     */
    @JsonProperty("parse_mode")
    override var parseMode: String? = null,
    /**
     * duration Integer Optional. Audio duration
     */
    @JsonProperty("duration")
    var duration: Int? = null,
    /**
     * performer [String] Optional. Performer of the audio
     */
    @JsonProperty("performer")
    var performer: String? = null,
    /**
     * title [String] Optional. Title of the audio
     */
    @JsonProperty("title")
    var title: String? = null
) : InputMedia()

/**
 *  [InputMediaPhoto](https://core.telegram.org/bots/api/#inputmediaphoto)
 */
data class InputMediaPhoto(
    /**
     * type String Type of the result, must be photo
     */
    @JsonProperty("type")
    override var type: String? = null,
    /**
     * media String File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an
     * HTTP URL for Telegram to get a file from the Internet, or pass "attach://<file_attach_name>" to upload a new one
     * using multipart/form-data under <file_attach_name> name.
    </file_attach_name></file_attach_name> */
    @JsonProperty("media")
    override var media: InputFile? = null,
    /**
     * caption [String] Optional. Caption of the photo to be sent, 0-200 characters
     */
    @JsonProperty("caption")
    override var caption: String? = null,
    /**
     * parse_mode [String] Optional. Send Markdown or HTML, if you want Telegram apps to show bold, italic, fixed-width text
     * or inline URLs in the media caption.
     */
    @JsonProperty("parse_mode")
    override var parseMode: String? = null

) : InputMedia()

/**
 *  [InputMediaDocument](https://core.telegram.org/bots/api/#inputmediadocument)
 */
data class InputMediaDocument(
    /**
     * type String Type of the result, must be document
     */
    @JsonProperty("type")
    override var type: String? = null,
    /**
     * media String File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an
     * HTTP URL for Telegram to get a file from the Internet, or pass "attach://<file_attach_name>" to upload a new one
     * using multipart/form-data under <file_attach_name> name.
    </file_attach_name></file_attach_name> */
    @JsonProperty("media")
    override var media: InputFile? = null,
    /**
     * thumb InputFile or [String] Optional. Thumbnail of the file sent. The thumbnail should be in JPEG format and less
     * than 200 kB in size. A thumbnail‘s width and height should not exceed 90. Ignored if the file is not uploaded using
     * multipart/form-data. Thumbnails can’t be reused and can be only uploaded as a new file, so you can pass
     * “attach://<file_attach_name>” if the thumbnail was uploaded using multipart/form-data under <file_attach_name>.
    </file_attach_name></file_attach_name> */
    @JsonProperty("thumb")
    var thumb: InputFile? = null,
    /**
     * caption [String] Optional. Caption of the video to be sent, 0-200 characters
     */
    @JsonProperty("caption")
    override var caption: String? = null,
    /**
     * parse_mode [String] Optional. Send Markdown or HTML, if you want Telegram apps to show bold, italic, fixed-width text
     * or inline URLs in the media caption.
     */
    @JsonProperty("parse_mode")
    override var parseMode: String? = null

) : InputMedia()

/**
 *  [InputMediaAnimation](https://core.telegram.org/bots/api/#inputmediaanimation)
 */
data class InputMediaAnimation(
    /**
     * type String Type of the result, must be animation
     */
    @JsonProperty("type")
    override var type: String? = null,
    /**
     * media String File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an
     * HTTP URL for Telegram to get a file from the Internet, or pass "attach://<file_attach_name>" to upload a new one
     * using multipart/form-data under <file_attach_name> name.
    </file_attach_name></file_attach_name> */
    @JsonProperty("media")
    override var media: InputFile? = null,
    /**
     * thumb InputFile or [String] Optional. Thumbnail of the file sent. The thumbnail should be in JPEG format and less
     * than 200 kB in size. A thumbnail‘s width and height should not exceed 90. Ignored if the file is not uploaded using
     * multipart/form-data. Thumbnails can’t be reused and can be only uploaded as a new file, so you can pass
     * “attach://<file_attach_name>” if the thumbnail was uploaded using multipart/form-data under <file_attach_name>.
    </file_attach_name></file_attach_name> */
    @JsonProperty("thumb")
    var thumb: InputFile? = null,
    /**
     * caption [String] Optional. Caption of the animation to be sent, 0-200 characters
     */
    @JsonProperty("caption")
    override var caption: String? = null,
    /**
     * parse_mode [String] Optional. Send Markdown or HTML, if you want Telegram apps to show bold, italic, fixed-width text
     * or inline URLs in the media caption.
     */
    @JsonProperty("parse_mode")
    override var parseMode: String? = null,
    /**
     * width Integer Optional. Animation width
     */
    @JsonProperty("width")
    var width: Int? = null,
    /**
     * height Integer Optional. Animation height
     */
    @JsonProperty("height")
    var height: Int? = null,
    /**
     * duration Integer Optional. Animation duration
     */
    @JsonProperty("duration")
    var duration: Int? = null
) : InputMedia()

/**
 *  [InputMediaVideo](https://core.telegram.org/bots/api/#inputmediavideo)
 */
data class InputMediaVideo(
    /**
     * type String Type of the result, must be video
     */
    @JsonProperty("type")
    override var type: String? = null,
    /**
     * media String File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an
     * HTTP URL for Telegram to get a file from the Internet, or pass "attach://<file_attach_name>" to upload a new one
     * using multipart/form-data under <file_attach_name> name.
    </file_attach_name></file_attach_name> */
    @JsonProperty("media")
    override var media: InputFile? = null,
    /**
     * thumb InputFile or [String] Optional. Thumbnail of the file sent. The thumbnail should be in JPEG format and less
     * than 200 kB in size. A thumbnail‘s width and height should not exceed 90. Ignored if the file is not uploaded using
     * multipart/form-data. Thumbnails can’t be reused and can be only uploaded as a new file, so you can pass
     * “attach://<file_attach_name>” if the thumbnail was uploaded using multipart/form-data under <file_attach_name>.
    </file_attach_name></file_attach_name> */
    @JsonProperty("thumb")
    var thumb: InputFile? = null,
    /**
     * caption [String] Optional. Caption of the video to be sent, 0-200 characters
     */
    @JsonProperty("caption")
    override var caption: String? = null,
    /**
     * parse_mode [String] Optional. Send Markdown or HTML, if you want Telegram apps to show bold, italic, fixed-width text
     * or inline URLs in the media caption.
     */
    @JsonProperty("parse_mode")
    override var parseMode: String? = null,
    /**
     * width Integer Optional. Video width
     */
    @JsonProperty("width")
    var width: Int? = null,
    /**
     * height Integer Optional. Video height
     */
    @JsonProperty("height")
    var height: Int? = null,
    /**
     * duration Integer Optional. Video duration
     */
    @JsonProperty("duration")
    var duration: Int? = null,
    /**
     * supports_streaming Boolean Optional. Pass True, if the uploaded video is suitable for streaming
     */
    @JsonProperty("supports_streaming")
    var supportsStreaming: Boolean? = null
) : InputMedia()