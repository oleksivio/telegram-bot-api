package io.github.oleksivio.telegram.bot.core.controller.annotations.parser.filter

import io.github.oleksivio.telegram.bot.core.controller.annotations.parser.Parser
import io.github.oleksivio.telegram.bot.core.controller.annotations.parser.finder.Finder
import io.github.oleksivio.telegram.bot.core.controller.handler.check.Validator

interface FilterParser<A : Annotation, IN> : Parser<A> {

    fun createChecker(annotation: A, finder: Finder): Validator<IN>

}
