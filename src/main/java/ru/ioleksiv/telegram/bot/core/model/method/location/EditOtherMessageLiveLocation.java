package ru.ioleksiv.telegram.bot.core.model.method.location;

import ru.ioleksiv.telegram.bot.core.controller.network.Networker;
import ru.ioleksiv.telegram.bot.core.model.responses.CommonResponse;
import ru.ioleksiv.telegram.bot.core.model.responses.ResponseCollection;

public class EditOtherMessageLiveLocation extends EditMessageLiveLocation<Boolean> {

    public EditOtherMessageLiveLocation(Networker networker) {
        super(networker);
    }

    @Override
   protected Class<? extends CommonResponse<Boolean>> getResultWrapperClass() {
        return ResponseCollection.BooleanResponse.class;
    }
}
