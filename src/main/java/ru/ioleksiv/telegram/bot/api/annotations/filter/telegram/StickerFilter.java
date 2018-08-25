package ru.ioleksiv.telegram.bot.api.annotations.filter.telegram;

import ru.ioleksiv.telegram.bot.api.annotations.filter.primitive.IntegerFilter;
import ru.ioleksiv.telegram.bot.api.annotations.filter.primitive.StringFilter;
import ru.ioleksiv.telegram.bot.api.model.annotation.AnnotationState;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface StickerFilter {

    AnnotationState status() default AnnotationState.ON;

    String[] validator() default {};

    MaskPositionFilter maskPosition() default @MaskPositionFilter(status = AnnotationState.OFF);

    IntegerFilter width() default @IntegerFilter(status = AnnotationState.OFF);

    IntegerFilter height() default @IntegerFilter(status = AnnotationState.OFF);

    PhotoFilter thumb() default @PhotoFilter(status = AnnotationState.OFF);

    StringFilter emoji() default @StringFilter(status = AnnotationState.OFF);

    StringFilter setName() default @StringFilter(status = AnnotationState.OFF);

    IntegerFilter fileSize() default @IntegerFilter(status = AnnotationState.OFF);

}

