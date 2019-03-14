package io.github.oleksivio.telegram.bot.api.model.objects.passport.errors

import com.fasterxml.jackson.annotation.JsonProperty
import io.github.oleksivio.telegram.bot.api.model.objects.passport.PassportConstants
import io.github.oleksivio.telegram.bot.core.model.type.NamedType

/**
 * @see [PassportElementErrorFile](https://core.telegram.org/bots/api.passportelementerrorfile)
 */
data class PassportElementErrorFile(
        @JsonProperty("source")
        val source: String = "file",

        /**
         * file_hash String Base64-encoded hash of the file with the front side of the document
         */
        @JsonProperty("file_hash")
        var fileHash: String? = null
) : PassportElementError() {

    fun setType(type: Type) {
        this.type = type.stringName
    }

    enum class Type(override val stringName: String) : NamedType {
        UTILITY_BILL(PassportConstants.UTILITY_BILL),
        BANK_STATEMENT(PassportConstants.BANK_STATEMENT),
        RENTAL_AGREENENT(PassportConstants.RENTAL_AGREENENT),
        PASSPORT_REGISTRATION(PassportConstants.PASSPORT_REGISTRATION),
        TEMPORARY_REGISTRATION(PassportConstants.TEMPORARY_REGISTRATION);
    }

}
