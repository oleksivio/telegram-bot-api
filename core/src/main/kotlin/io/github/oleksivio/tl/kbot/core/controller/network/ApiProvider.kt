package io.github.oleksivio.tl.kbot.core.controller.network

import io.github.oleksivio.tl.kbot.core.model.ErrorResponse
import io.github.oleksivio.tl.kbot.server.api.model.method.Action

private const val TELEGRAM_SERVER_URL = "https://api.telegram.org/bot"
private const val URL_SEPARATOR = '/'

abstract class ApiProvider(token: String) {

    val url = TELEGRAM_SERVER_URL + token + URL_SEPARATOR

    abstract fun <RES> send(action: Action<RES>, serverErrorListener: ServerErrorListener): RES?
}

typealias ServerErrorListener = (error: ErrorResponse) -> Unit

