package io.github.oleksivio.tl.kbot.core.controller.annotations.parser.filter.primitive

import io.github.oleksivio.tl.kbot.core.annotations.filter.primitive.BooleanFilter
import io.github.oleksivio.tl.kbot.core.controller.annotations.parser.filter.FilterParser
import io.github.oleksivio.tl.kbot.core.controller.annotations.parser.finder.Finder
import io.github.oleksivio.tl.kbot.core.controller.handler.check.Validator
import io.github.oleksivio.tl.kbot.core.controller.handler.check.impl.BooleanValidator

class BooleanFilterParser :
    FilterParser<BooleanFilter, Boolean> {

    override val parserAnnotationClass = BooleanFilter::class

    override fun createChecker(annotation: BooleanFilter, finder: Finder): Validator<Boolean> {
        return BooleanValidator(annotation.state)
    }
}
