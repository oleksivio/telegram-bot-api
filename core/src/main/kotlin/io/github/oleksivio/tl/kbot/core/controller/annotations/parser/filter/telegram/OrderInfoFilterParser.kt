package io.github.oleksivio.tl.kbot.core.controller.annotations.parser.filter.telegram

import io.github.oleksivio.tl.kbot.core.annotations.filter.composite.OrderInfoFilter
import io.github.oleksivio.tl.kbot.core.controller.annotations.parser.filter.FilterParser
import io.github.oleksivio.tl.kbot.core.controller.annotations.parser.finder.Finder
import io.github.oleksivio.tl.kbot.core.controller.handler.check.Validator
import io.github.oleksivio.tl.kbot.core.controller.handler.check.impl.UnionExtractValidator
import io.github.oleksivio.tl.kbot.server.api.objects.payments.OrderInfo

class OrderInfoFilterParser :
    FilterParser<OrderInfoFilter, OrderInfo> {

    override val parserAnnotationClass = OrderInfoFilter::class

    override fun createChecker(annotation: OrderInfoFilter, finder: Finder): Validator<OrderInfo> {
        val unionExtractValidator =
            UnionExtractValidator<OrderInfo>()

        annotation.validator
            .map { validatorName -> finder.find(validatorName, OrderInfo::class) }
            .forEach { validator -> unionExtractValidator.add({ it }, validator) }

        val name = annotation.name
        if (name.status.isActive) {
            unionExtractValidator.add({ it.name }, finder.find(name))
        }
        val phoneNumber = annotation.phoneNumber
        if (phoneNumber.status.isActive) {
            unionExtractValidator.add({ it.phoneNumber }, finder.find(phoneNumber))
        }
        val email = annotation.email
        if (email.status.isActive) {
            unionExtractValidator.add({ it.email }, finder.find(email))
        }
        val shippingAddress = annotation.shippingAddress
        if (shippingAddress.status.isActive) {
            unionExtractValidator.add({ it.shippingAddress }, finder.find(shippingAddress))
        }

        return unionExtractValidator
    }
}

