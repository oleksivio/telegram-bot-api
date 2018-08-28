package io.github.oleksivio.telegram.bot.api.model.method.location;

import io.github.oleksivio.telegram.bot.core.controller.network.ActionNetworker;
import io.github.oleksivio.telegram.bot.core.model.responses.BooleanResponse;
import io.github.oleksivio.telegram.bot.core.model.method.location.StopMessageLiveLocation;
import io.github.oleksivio.telegram.bot.core.model.responses.CommonResponse;

public class StopOtherMessageLiveLocation extends StopMessageLiveLocation<Boolean> {
    public StopOtherMessageLiveLocation(ActionNetworker actionNetworker) {
        super(actionNetworker);
    }

    @Override
    protected Class<? extends CommonResponse<Boolean>> getResultWrapperClass() {
        return BooleanResponse.class;
    }
}