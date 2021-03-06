package io.github.oleksivio.tl.kbot.core.controller.annotations.composer

import io.github.oleksivio.tl.kbot.core.controller.annotations.parser.producer.ArgCheckerProducer
import io.github.oleksivio.tl.kbot.core.controller.annotations.parser.producer.ArgUnpackerProducer
import io.github.oleksivio.tl.kbot.core.controller.annotations.parser.producer.InvokerProducer
import io.github.oleksivio.tl.kbot.core.controller.handler.Handler
import io.github.oleksivio.tl.kbot.core.controller.handler.check.impl.ExtractValidator
import io.github.oleksivio.tl.kbot.server.api.model.ITelegram
import org.slf4j.LoggerFactory

import kotlin.reflect.KFunction

class HandlerCreator(
    private val argCheckerProducer: ArgCheckerProducer,
    private val argUnpackerProducer: ArgUnpackerProducer,
    private val invokerProducer: InvokerProducer
) {

    fun <ARG : ITelegram> create(
        classInstance: Any,
        func: KFunction<*>
    ): Handler<*>? {

        val argUnpacker = argUnpackerProducer.create<ARG>(func)
        val argChecker = argCheckerProducer.create<Annotation, ARG>(func)


        if (argUnpacker == null) {
            // LOG.error(" Receiver annotation was not found for method $func")
            return null
        }

        val invoker = invokerProducer.create(
            func,
            classInstance,
            argUnpacker.updateUnpacker.outClass
        ) ?: return null

        val updateChecker = ExtractValidator(
            argUnpacker.updateUnpacker.unpacker,
            argChecker
        )

        return Handler(
            invoker,
            updateChecker,
            argUnpacker.updateUnpacker.unpacker
        )
    }

    companion object {
        private val LOG = LoggerFactory.getLogger(HandlerCreator::class.java)
    }
}
