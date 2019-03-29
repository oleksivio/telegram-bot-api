package io.github.oleksivio.telegram.bot.api.model.annotation.validator.impl

import io.github.oleksivio.telegram.bot.api.model.annotation.validator.FilterValidator
import io.github.oleksivio.telegram.bot.api.model.objects.std.Location
import io.github.oleksivio.telegram.bot.core.controller.handler.check.Validator

class LocationFilterValidator(validator: Validator<Location>) : FilterValidator<Location>(Location::class, validator)
