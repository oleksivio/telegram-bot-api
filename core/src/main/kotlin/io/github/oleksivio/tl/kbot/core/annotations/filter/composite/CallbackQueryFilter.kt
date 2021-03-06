package io.github.oleksivio.tl.kbot.core.annotations.filter.composite

import io.github.oleksivio.tl.kbot.core.annotations.filter.primitive.StringFilter
import io.github.oleksivio.tl.kbot.core.model.annotation.AnnotationState

@Retention
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@MustBeDocumented
annotation class CallbackQueryFilter(
    val from: UserFilter = UserFilter(
        status = AnnotationState.OFF
    ),
    val message: MessageFilter = MessageFilter(
        status = AnnotationState.OFF
    ),
    val validator: Array<String> = [],
    val inlineMessageId: StringFilter = StringFilter(
        status = AnnotationState.OFF
    ),
    val chatInstance: StringFilter = StringFilter(
        status = AnnotationState.OFF
    ),
    val data: StringFilter = StringFilter(
        status = AnnotationState.OFF
    ),
    val gameShortName: StringFilter = StringFilter(
        status = AnnotationState.OFF
    )
)
