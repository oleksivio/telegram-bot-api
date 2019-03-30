package io.github.oleksivio.telegram.bot.api.annotations.filter.composite

import io.github.oleksivio.telegram.bot.api.annotations.filter.primitive.IntegerFilter
import io.github.oleksivio.telegram.bot.api.annotations.filter.primitive.StringFilter
import io.github.oleksivio.telegram.bot.api.model.annotation.AnnotationState
import io.github.oleksivio.telegram.bot.api.model.objects.std.MessageEntity

@Retention
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@MustBeDocumented
annotation class MessageEntityFilter(
        val status: AnnotationState = AnnotationState.ON,
        val type: MessageEntity.Type = MessageEntity.Type.ALL,
        val validator: Array<String> = [],
        val length: IntegerFilter = IntegerFilter(status = AnnotationState.OFF),
        val url: StringFilter = StringFilter(status = AnnotationState.OFF),
        val user: UserFilter = UserFilter(status = AnnotationState.OFF)
)