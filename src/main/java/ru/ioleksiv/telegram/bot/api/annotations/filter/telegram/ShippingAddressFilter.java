package ru.ioleksiv.telegram.bot.api.annotations.filter.telegram;

import ru.ioleksiv.telegram.bot.api.annotations.filter.primitive.StringFilter;
import ru.ioleksiv.telegram.bot.api.model.annotation.AnnotationState;
import ru.ioleksiv.telegram.bot.api.model.annotation.CustomValidator;
import ru.ioleksiv.telegram.bot.api.model.annotation.stub.StubShippingAddressValidator;
import ru.ioleksiv.telegram.bot.api.model.objects.payments.ShippingAddress;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface ShippingAddressFilter {

    AnnotationState status() default AnnotationState.ON;

    String[] validator() default {};

    StringFilter countryCode() default @StringFilter(status = AnnotationState.OFF);

    StringFilter state() default @StringFilter(status = AnnotationState.OFF);

    StringFilter city() default @StringFilter(status = AnnotationState.OFF);

    StringFilter streetLine1() default @StringFilter(status = AnnotationState.OFF);

    StringFilter streetLine2() default @StringFilter(status = AnnotationState.OFF);

    StringFilter postCode() default @StringFilter(status = AnnotationState.OFF);

}
