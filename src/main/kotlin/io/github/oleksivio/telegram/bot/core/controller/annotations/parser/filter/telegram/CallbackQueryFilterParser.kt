package io.github.oleksivio.telegram.bot.core.controller.annotations.parser.filter.telegram

import io.github.oleksivio.telegram.bot.api.annotations.filter.telegram.CallbackQueryFilter
import io.github.oleksivio.telegram.bot.api.model.objects.std.CallbackQuery
import io.github.oleksivio.telegram.bot.core.controller.annotations.parser.filter.FilterParser
import io.github.oleksivio.telegram.bot.core.controller.annotations.parser.finder.Finder
import io.github.oleksivio.telegram.bot.core.controller.handler.check.Validator
import io.github.oleksivio.telegram.bot.core.controller.handler.check.impl.UnionExtractValidator
import org.springframework.stereotype.Component

@Component
class CallbackQueryFilterParser : FilterParser<CallbackQueryFilter, CallbackQuery> {

    override val parserAnnotationClass = CallbackQueryFilter::class

    override fun createChecker(annotation: CallbackQueryFilter,
                               finder: Finder): Validator<CallbackQuery> {

        val unionExtractValidator = UnionExtractValidator<CallbackQuery>()

        annotation.validator
                .map { validatorName -> finder.find(validatorName, CallbackQuery::class) }
                .forEach { validator -> unionExtractValidator.add({ it }, validator) }

        val data = annotation.data
        if (data.status.isActive) {
            unionExtractValidator.add({ it.data }, finder.find(data))
        }
        val chatInstance = annotation.chatInstance
        if (chatInstance.status.isActive) {
            unionExtractValidator.add({ it.chatInstance }, finder.find(chatInstance))
        }
        val gameShortName = annotation.gameShortName
        if (gameShortName.status.isActive) {
            unionExtractValidator.add({ it.gameShortName }, finder.find(gameShortName))
        }
        val inlineMessageId = annotation.inlineMessageId
        if (inlineMessageId.status.isActive) {
            unionExtractValidator.add({ it.inlineMessageId }, finder.find(inlineMessageId))
        }
        val message = annotation.message
        if (message.status.isActive) {
            unionExtractValidator.add({ it.message }, finder.find(message))
        }
        return unionExtractValidator
    }

}



