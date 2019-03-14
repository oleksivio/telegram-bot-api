package io.github.oleksivio.telegram.bot.api.model.objects.payments

import com.fasterxml.jackson.annotation.JsonProperty
import io.github.oleksivio.telegram.bot.core.model.ITelegram
import java.util.*

/**
 * @see [ShippingOption](https://core.telegram.org/bots/api.shippingoption)
 */
data class ShippingOption(
        /**
         * id String Shipping option identifier
         */
        @JsonProperty("id")
        var id: String? = null,
        /**
         * title String Option title
         */
        @JsonProperty("title")
        var title: String? = null,
        /**
         * prices Array of LabeledPrice List of price portions
         */
        @JsonProperty("prices")
        var prices: List<LabeledPrice> = ArrayList()
) : ITelegram
