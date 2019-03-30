package io.github.oleksivio.telegram.bot.api.controller

import io.github.oleksivio.telegram.bot.api.model.objects.Update

/**
 * [TelegramProcessor] interface allowed setup webhook receiver
 *
 * Realisation of webhook variant of [receiving updates](https://core.telegram.org/bots/api#getting-updates)
 *
 * Example:
 *
 * ```kotlin
 * @RestController
 * class TelegramWebhookReceiver(private val processor: TelegramProcessor) {
 *
 * @RequestMapping(path = ["/receive"])
 * fun receiver(update: Update): String {
 *     processor.receive(update)
 *     return "OK"
 * }
 *
 * }
 * ```
 */
interface TelegramProcessor {
    /**
     * Function to receive telegram update
     *
     * @param update - incoming telegram update
     */
    fun receive(update: Update)
}
