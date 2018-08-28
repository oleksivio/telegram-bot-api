package io.github.oleksivio.telegram.bot.api.annotations.filter.telegram;

import io.github.oleksivio.telegram.bot.api.annotations.filter.primitive.StringFilter;
import io.github.oleksivio.telegram.bot.api.model.annotation.AnnotationState;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface OrderInfoFilter {

    AnnotationState status() default AnnotationState.ON;

    String[] validator() default {};

    StringFilter name() default @StringFilter(status = AnnotationState.OFF);

    StringFilter phoneNumber() default @StringFilter(status = AnnotationState.OFF);

    StringFilter email() default @StringFilter(status = AnnotationState.OFF);

    ShippingAddressFilter shippingAddress() default @ShippingAddressFilter(status = AnnotationState.OFF);

}