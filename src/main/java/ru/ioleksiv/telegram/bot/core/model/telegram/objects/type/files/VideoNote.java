package ru.ioleksiv.telegram.bot.core.model.telegram.objects.type.files;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @see <a href="https://core.telegram.org/bots/api#videonote">VideoNote</a>
 */
public class VideoNote {
    /**
     * file_id	String	Unique identifier for this files
     */
    @JsonProperty("file_id")
    private String fileId;
    /**
     * length	Integer	Video width and height as defined by sender
     */
    @JsonProperty("length")
    private Integer length;
    /**
     * duration	Integer	Duration of the video in seconds as defined by sender
     */
    @JsonProperty("duration")
    private Integer duration;
    /**
     * thumb	PhotoSize	Optional. Video thumbnail
     */
    @JsonProperty("thumb")
    private PhotoSize thumb;
    /**
     * file_size	Integer	Optional. File size
     */
    @JsonProperty("file_size")
    private Integer fileSize;

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public PhotoSize getThumb() {
        return thumb;
    }

    public void setThumb(PhotoSize thumb) {
        this.thumb = thumb;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }
}
