package io.github.oleksivio.telegram.bot.api.controller

import io.github.oleksivio.telegram.bot.api.model.ServerErrorListener
import io.github.oleksivio.telegram.bot.core.model.method.Action

/**
 * Callback to initialize action
 *
 * @return action
 */
typealias ActionCreate<RES> = () -> Action<RES>

/**
 * All bot interactions with telegram server named actions.
 * Actions is object which used by [ActionBuilder] for call telegram bot api method.
 *
 *
 * For example:
 *
 * [io.github.oleksivio.telegram.bot.api.model.method.message.SendMessage] object action
 * are used for call [SendMessage](https://core.telegram.org/bots/api/#sendmessage) method.
 *
 * All actions are located in next packages:
 * - [io.github.oleksivio.telegram.bot.api.model.method.notify]
 * - [io.github.oleksivio.telegram.bot.api.model.method.file]
 * - [io.github.oleksivio.telegram.bot.api.model.method.game]
 * - [io.github.oleksivio.telegram.bot.api.model.method.group]
 * - [io.github.oleksivio.telegram.bot.api.model.method.info]
 * - [io.github.oleksivio.telegram.bot.api.model.method.inline]
 * - [io.github.oleksivio.telegram.bot.api.model.method.location]
 * - [io.github.oleksivio.telegram.bot.api.model.method.message]
 * - [io.github.oleksivio.telegram.bot.api.model.method.passport]
 * - [io.github.oleksivio.telegram.bot.api.model.method.payments]
 * - [io.github.oleksivio.telegram.bot.api.model.method.sticker]
 * - [io.github.oleksivio.telegram.bot.api.model.method.update]
 *
 * [ActionBuilder] interface for create telegram api action.
 *
 * [ActionErrorListener] used for print error description
 *
 * Example usage in spring rest controller:
 *
 * ```kotlin
 * @RestController
 * class Sender(private val actionBuilder: ActionBuilder) {
 *
 * @RequestMapping("/send")
 * fun greeting(@RequestParam(value = "msg") msg: String,
 * @RequestParam(value = "chatId") chatId: Long): Message = actionBuilder
 * .action {
 *      SendMessage(chatId, msg)
 * }
 * .errorListener { e -> println(e.errorDescription) }
 * .send() ?: Message(0)
 * }
 *
 * ```
 */
interface ActionBuilder {
    /**
     * @param initBlock - Action initializer which create [ActionCreate]
     *
     * @return [ActionErrorListener]
     */
    fun <RES> action(initBlock: ActionCreate<RES>): ActionErrorListener<RES>

    /**
     * @param action -  action object
     *
     * @return [ActionErrorListener]
     */
    fun <RES> action(action: Action<RES>): ActionErrorListener<RES>
}

/**
 * [ActionSend] interface for send telegram api action
 */
interface ActionSend<RES> {
    /**
     * Send action
     *
     * @return result telegram api action result
     */
    fun send(): RES?
}

/**
 * [ActionBuilder] interface for set [ServerErrorListener]
 * or send telegram api action
 */
interface ActionErrorListener<RES> {
    /**
     * @param serverErrorListener - [ServerErrorListener] used for
     *
     * set callback to handle telegram server error
     */
    fun errorListener(serverErrorListener: ServerErrorListener): ActionSend<RES>

    /**
     * Send action
     *
     * @return result telegram api action result
     */
    fun send(): RES?
}
