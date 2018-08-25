package ru.ioleksiv.telegram.bot.core.controller.annotations.parser.filter.telegram;

import org.springframework.stereotype.Component;
import ru.ioleksiv.telegram.bot.api.annotations.filter.primitive.StringFilter;
import ru.ioleksiv.telegram.bot.api.annotations.filter.telegram.OrderInfoFilter;
import ru.ioleksiv.telegram.bot.api.annotations.filter.telegram.PreCheckoutQueryFilter;
import ru.ioleksiv.telegram.bot.api.annotations.filter.telegram.UserFilter;
import ru.ioleksiv.telegram.bot.api.model.objects.payments.PreCheckoutQuery;
import ru.ioleksiv.telegram.bot.core.controller.annotations.parser.filter.FilterParser;
import ru.ioleksiv.telegram.bot.core.controller.annotations.parser.finder.Finder;
import ru.ioleksiv.telegram.bot.core.controller.handler.check.Validator;
import ru.ioleksiv.telegram.bot.core.controller.handler.check.impl.UnionExtractValidator;

import java.util.Optional;

@Component
public class PreCheckoutQueryFilterParser implements FilterParser<PreCheckoutQueryFilter, PreCheckoutQuery> {

    @Override
    public Validator<PreCheckoutQuery> createChecker(PreCheckoutQueryFilter annotation, Finder finder) {
        UnionExtractValidator<PreCheckoutQuery> unionExtractValidator = new UnionExtractValidator<>();

        UserFilter from = annotation.from();
        if (from.status().isActive()) {
            unionExtractValidator.add(in -> Optional.ofNullable(in.getFrom()), finder.find(from));
        }
        StringFilter currency = annotation.currency();
        if (currency.status().isActive()) {
            unionExtractValidator.add(in -> Optional.ofNullable(in.getCurrency()), finder.find(currency));
        }
        StringFilter totalAmount = annotation.totalAmount();
        if (totalAmount.status().isActive()) {
            unionExtractValidator.add(in -> Optional.ofNullable(in.getTotalAmount()), finder.find(totalAmount));
        }
        StringFilter invoicePayload = annotation.invoicePayload();
        if (invoicePayload.status().isActive()) {
            unionExtractValidator.add(in -> Optional.ofNullable(in.getInvoicePayload()), finder.find(invoicePayload));
        }
        StringFilter shippingOptionId = annotation.shippingOptionId();
        if (shippingOptionId.status().isActive()) {
            unionExtractValidator.add(in -> Optional.ofNullable(in.getShippingOptionId()), finder.find(shippingOptionId));
        }
        OrderInfoFilter orderInfo = annotation.orderInfo();
        if (orderInfo.status().isActive()) {
            unionExtractValidator.add(in -> Optional.ofNullable(in.getOrderInfo()), finder.find(orderInfo));
        }

        return unionExtractValidator;
    }

    @Override
    public Class<PreCheckoutQueryFilter> getAnnotationClass() {
        return PreCheckoutQueryFilter.class;
    }

}
