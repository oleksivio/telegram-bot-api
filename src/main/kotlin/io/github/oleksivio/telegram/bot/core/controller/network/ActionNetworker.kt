package io.github.oleksivio.telegram.bot.core.controller.network

import io.github.oleksivio.telegram.bot.api.model.ServerErrorListener
import io.github.oleksivio.tl.kbot.server.api.model.CommonResponse
import io.github.oleksivio.tl.kbot.server.api.model.method.Action
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller

@Controller
class ActionNetworker(@Value("\${telegram.bot.token}") token: String) : Networker(token) {

    fun <T : CommonResponse<*>> run(action: Action<*>,
                                                                                 clazz: Class<T>,
                                                                                 serverErrorListenerOpt: ServerErrorListener): T? {
        return safelyRun(serverErrorListenerOpt) { template, url -> template.postForEntity(url, action, clazz).body }
    }

}

