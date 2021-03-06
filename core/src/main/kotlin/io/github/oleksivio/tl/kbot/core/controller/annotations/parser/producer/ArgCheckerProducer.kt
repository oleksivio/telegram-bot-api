package io.github.oleksivio.tl.kbot.core.controller.annotations.parser.producer

import io.github.oleksivio.tl.kbot.core.controller.annotations.parser.filter.FilterParser
import io.github.oleksivio.tl.kbot.core.controller.annotations.parser.finder.Finder
import io.github.oleksivio.tl.kbot.core.controller.handler.check.Validator
import io.github.oleksivio.tl.kbot.server.api.model.ITelegram

import kotlin.reflect.KFunction

/**
 * Created by oleksivio on 15.03.19 at 00:21
 * Project: telegram-bot-api
 */

class ArgCheckerProducer(private val filterParsers: Collection<FilterParser<*, *>>, private val finder: Finder) {

    fun <A : Annotation, T : ITelegram> create(func: KFunction<*>): Validator<T> {

        for (filterParser in filterParsers) {
            val annotationAbstract = func.annotations
                .firstOrNull { it.annotationClass == filterParser.parserAnnotationClass }
            if (annotationAbstract != null) {
                val annotation = annotationAbstract as A
                val filter = filterParser as FilterParser<A, T>
                return filter.createChecker(annotation, finder)
            }
        }

        return { true }
    }
}
