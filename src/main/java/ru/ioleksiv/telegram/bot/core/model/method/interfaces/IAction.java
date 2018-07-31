package ru.ioleksiv.telegram.bot.core.model.method.interfaces;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.jetbrains.annotations.Nullable;
import ru.ioleksiv.telegram.bot.core.model.responses.CommonResponse;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class IAction<RES> {

    @JsonIgnore
    @Nullable
    public abstract RES send();

    @JsonIgnore
    protected abstract Class<? extends CommonResponse<RES>> getResultWrapperClass();
}
