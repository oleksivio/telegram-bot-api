package ru.ioleksiv.telegram.bot.core.model.telegram.method.location;

import ru.ioleksiv.telegram.bot.core.controller.network.Networker;
import ru.ioleksiv.telegram.bot.core.model.telegram.objects.type.Message;
import ru.ioleksiv.telegram.bot.core.model.telegram.responses.CommonResponse;
import ru.ioleksiv.telegram.bot.core.model.telegram.responses.ResponseCollection;

public class EditOwnMessageLiveLocation extends EditMessageLiveLocation<Message> {

    public EditOwnMessageLiveLocation(Networker networker) {
        super(networker);
    }

    @Override
    public Class<? extends CommonResponse<Message>> getResultWrapperClass() {
        return ResponseCollection.MessageResponse.class;
    }
}
