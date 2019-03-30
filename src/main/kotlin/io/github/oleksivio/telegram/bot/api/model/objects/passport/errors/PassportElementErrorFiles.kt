package io.github.oleksivio.telegram.bot.api.model.objects.passport.errors

import com.fasterxml.jackson.annotation.JsonProperty
import io.github.oleksivio.telegram.bot.api.model.objects.passport.PassportConstants
import io.github.oleksivio.telegram.bot.core.model.type.NamedType
import java.util.*

/**
 *  [PassportElementErrorFiles](https://core.telegram.org/bots/api/#passportelementerrorfiles)
 */
class PassportElementErrorFiles : PassportElementError() {
    @JsonProperty("source")
    val source: String = "files"
    /**
     * file_hashes Array of String List of base64-encoded file hashes
     */
    @JsonProperty("file_hashes")
    var fileHashes: List<String> = ArrayList()

    fun setType(type: Type) {
        this.type = type.stringName
    }

    enum class Type constructor(override val stringName: String) : NamedType {
        UTILITY_BILL(PassportConstants.UTILITY_BILL),
        BANK_STATEMENT(PassportConstants.BANK_STATEMENT),
        RENTAL_AGREENENT(PassportConstants.RENTAL_AGREENENT),
        PASSPORT_REGISTRATION(PassportConstants.PASSPORT_REGISTRATION),
        TEMPORARY_REGISTRATION(PassportConstants.TEMPORARY_REGISTRATION);

    }

}
