package io.github.oleksivio.tl.kbot.core.annotations.filter.composite

import io.github.oleksivio.tl.kbot.core.annotations.filter.primitive.NotNullFilter
import io.github.oleksivio.tl.kbot.core.annotations.filter.primitive.StringFilter
import io.github.oleksivio.tl.kbot.core.model.annotation.AnnotationState

@Retention
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@MustBeDocumented
annotation class ContactFilter(
    val status: AnnotationState = AnnotationState.ON,
    val validator: Array<String> = [],
    val phoneNumber: StringFilter = StringFilter(
        status = AnnotationState.OFF
    ),
    val firstName: StringFilter = StringFilter(
        status = AnnotationState.OFF
    ),
    val lastName: StringFilter = StringFilter(
        status = AnnotationState.OFF
    ),
    val vCard: StringFilter = StringFilter(
        status = AnnotationState.OFF
    ),
    val userId: NotNullFilter = NotNullFilter(
        status = AnnotationState.OFF
    )
)
