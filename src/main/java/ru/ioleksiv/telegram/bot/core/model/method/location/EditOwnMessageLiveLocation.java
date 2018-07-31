package ru.ioleksiv.telegram.bot.core.model.method.location;

import ru.ioleksiv.telegram.bot.core.controller.network.Networker;
import ru.ioleksiv.telegram.bot.core.model.objects.std.Message;
import ru.ioleksiv.telegram.bot.core.model.responses.CommonResponse;
import ru.ioleksiv.telegram.bot.core.model.responses.ResponseCollection;

public class EditOwnMessageLiveLocation extends EditMessageLiveLocation<Message> {

    public EditOwnMessageLiveLocation(Networker networker) {
        super(networker);
    }

    @Override
   protected Class<? extends CommonResponse<Message>> getResultWrapperClass() {
        return ResponseCollection.MessageResponse.class;
    }
}
