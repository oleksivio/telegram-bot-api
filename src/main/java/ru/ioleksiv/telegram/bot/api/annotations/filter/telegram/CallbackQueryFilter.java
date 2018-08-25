package ru.ioleksiv.telegram.bot.api.annotations.filter.telegram;

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
public @interface CallbackQueryFilter {

    MessageFilter message() default @MessageFilter(status = AnnotationState.OFF);

    StringFilter inlineMessageId() default @StringFilter(status = AnnotationState.OFF);

    StringFilter chatInstance() default @StringFilter(status = AnnotationState.OFF);

    StringFilter data() default @StringFilter(status = AnnotationState.OFF);

    StringFilter gameShortName() default @StringFilter(status = AnnotationState.OFF);

}