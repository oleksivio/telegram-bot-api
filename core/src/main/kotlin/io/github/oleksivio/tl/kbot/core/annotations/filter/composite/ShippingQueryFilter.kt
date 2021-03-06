package io.github.oleksivio.tl.kbot.core.annotations.filter.composite

import io.github.oleksivio.tl.kbot.core.annotations.filter.primitive.StringFilter
import io.github.oleksivio.tl.kbot.core.model.annotation.AnnotationState

@Retention
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@MustBeDocumented
annotation class ShippingQueryFilter(
    val status: AnnotationState = AnnotationState.ON,
    val validator: Array<String> = [],
    val from: UserFilter = UserFilter(
        status = AnnotationState.OFF
    ),
    val invoicePayload: StringFilter = StringFilter(
        status = AnnotationState.OFF
    ),
    val shippingAddress: ShippingAddressFilter = ShippingAddressFilter(
        status = AnnotationState.OFF
    )
)
