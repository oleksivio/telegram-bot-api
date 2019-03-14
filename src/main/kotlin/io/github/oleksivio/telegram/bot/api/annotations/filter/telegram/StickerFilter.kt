package io.github.oleksivio.telegram.bot.api.annotations.filter.telegram

import io.github.oleksivio.telegram.bot.api.annotations.filter.primitive.IntegerFilter
import io.github.oleksivio.telegram.bot.api.annotations.filter.primitive.StringFilter
import io.github.oleksivio.telegram.bot.api.model.annotation.AnnotationState

@Retention
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@MustBeDocumented
annotation class StickerFilter(val status: AnnotationState = AnnotationState.ON, val validator: Array<String> = [], val maskPosition: MaskPositionFilter = MaskPositionFilter(status = AnnotationState.OFF), val width: IntegerFilter = IntegerFilter(status = AnnotationState.OFF), val height: IntegerFilter = IntegerFilter(status = AnnotationState.OFF), val thumb: PhotoFilter = PhotoFilter(status = AnnotationState.OFF), val emoji: StringFilter = StringFilter(status = AnnotationState.OFF), val setName: StringFilter = StringFilter(status = AnnotationState.OFF), val fileSize: IntegerFilter = IntegerFilter(status = AnnotationState.OFF))

