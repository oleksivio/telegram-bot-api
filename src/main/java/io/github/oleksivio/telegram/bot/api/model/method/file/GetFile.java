package io.github.oleksivio.telegram.bot.api.model.method.file;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.oleksivio.telegram.bot.api.model.NetworkError;
import io.github.oleksivio.telegram.bot.api.model.objects.std.files.File;
import io.github.oleksivio.telegram.bot.core.controller.network.ActionNetworker;
import io.github.oleksivio.telegram.bot.core.model.responses.FileResponse;
import io.github.oleksivio.telegram.bot.core.model.method.RunnableAction;
import io.github.oleksivio.telegram.bot.core.model.responses.CommonResponse;

/**
 * @see <a href="https://core.telegram.org/bots/api#getfile">getFile</a>
 */
public class GetFile extends RunnableAction<File> {
    private static final String METHOD = "getFile";
    /**
     * file_id String  File identifier to get info about
     */
    @JsonProperty("file_id")
    private String fileId = null;

    public GetFile(ActionNetworker actionNetworker) {
        super(METHOD, actionNetworker);
    }

    public String getFileId() {
        return fileId;
    }

    public GetFile setFileId(String fileId) {
        this.fileId = fileId;
        return this;
    }

    @Override
    protected Class<? extends CommonResponse<File>> getResultWrapperClass() {
        return FileResponse.class;
    }

    @Override
    public GetFile setNetworkErrorListener(NetworkError onNetworkError) {
        pSetNetworkErrorListener(onNetworkError);
        return this;
    }
}