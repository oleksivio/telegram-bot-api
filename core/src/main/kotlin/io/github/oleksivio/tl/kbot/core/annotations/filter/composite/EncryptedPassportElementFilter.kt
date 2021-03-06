package io.github.oleksivio.tl.kbot.core.annotations.filter.composite

import io.github.oleksivio.tl.kbot.core.annotations.filter.primitive.NotNullFilter
import io.github.oleksivio.tl.kbot.core.annotations.filter.primitive.StringFilter
import io.github.oleksivio.tl.kbot.core.model.annotation.AnnotationState
import io.github.oleksivio.tl.kbot.server.api.objects.passport.EncryptedPassportElement

@Retention
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@MustBeDocumented
annotation class EncryptedPassportElementFilter(
    val status: AnnotationState = AnnotationState.ON,
    val type: EncryptedPassportElement.Type = EncryptedPassportElement.Type.UNKNOWN,
    val validator: Array<String> = [],
    val data: NotNullFilter = NotNullFilter(
        status = AnnotationState.OFF
    ),
    val phoneNumber: StringFilter = StringFilter(
        status = AnnotationState.OFF
    ),
    val email: StringFilter = StringFilter(
        status = AnnotationState.OFF
    ),
    val fileArray: PassportFileArrayFilter = PassportFileArrayFilter(
        status = AnnotationState.OFF
    ),
    val frontSide: PassportFileFilter = PassportFileFilter(
        status = AnnotationState.OFF
    ),
    val reverseSide: PassportFileFilter = PassportFileFilter(
        status = AnnotationState.OFF
    ),
    val selfie: PassportFileFilter = PassportFileFilter(
        status = AnnotationState.OFF
    )
)
