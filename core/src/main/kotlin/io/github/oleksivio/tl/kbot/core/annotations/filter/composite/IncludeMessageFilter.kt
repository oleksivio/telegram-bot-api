package io.github.oleksivio.tl.kbot.core.annotations.filter.composite

import io.github.oleksivio.tl.kbot.core.annotations.filter.primitive.BooleanFilter
import io.github.oleksivio.tl.kbot.core.annotations.filter.primitive.LongFilter
import io.github.oleksivio.tl.kbot.core.annotations.filter.primitive.NotNullFilter
import io.github.oleksivio.tl.kbot.core.annotations.filter.primitive.StringFilter
import io.github.oleksivio.tl.kbot.core.model.annotation.AnnotationState

@Retention
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@MustBeDocumented
annotation class IncludeMessageFilter(
    val status: AnnotationState = AnnotationState.ON,
    val validator: Array<String> = [],
    val from: UserFilter = UserFilter(
        status = AnnotationState.OFF
    ),
    val date: LongFilter = LongFilter(
        status = AnnotationState.OFF
    ),
    val chat: ChatFilter = ChatFilter(
        status = AnnotationState.OFF
    ),
    val forwardFrom: UserFilter = UserFilter(
        status = AnnotationState.OFF
    ),
    val forwardChat: ChatFilter = ChatFilter(
        status = AnnotationState.OFF
    ),
    val forwardFromMessageId: NotNullFilter = NotNullFilter(
        status = AnnotationState.OFF
    ),
    val forwardSignature: StringFilter = StringFilter(
        status = AnnotationState.OFF
    ),
    val forwardDate: NotNullFilter = NotNullFilter(
        status = AnnotationState.OFF
    ),
    val editDate: NotNullFilter = NotNullFilter(
        status = AnnotationState.OFF
    ),
    val mediaGroupId: NotNullFilter = NotNullFilter(
        status = AnnotationState.OFF
    ),
    val authorSignature: StringFilter = StringFilter(
        status = AnnotationState.OFF
    ),
    val text: StringFilter = StringFilter(
        status = AnnotationState.OFF
    ),
    val audio: AudioFilter = AudioFilter(
        status = AnnotationState.OFF
    ),
    val photoArray: PhotoArrayFilter = PhotoArrayFilter(
        status = AnnotationState.OFF
    ),
    val caption: StringFilter = StringFilter(
        status = AnnotationState.OFF
    ),
    val contact: ContactFilter = ContactFilter(
        status = AnnotationState.OFF
    ),
    val location: LocationFilter = LocationFilter(
        status = AnnotationState.OFF
    ),
    val newChatMembers: UserArrayFilter = UserArrayFilter(
        status = AnnotationState.OFF
    ),
    val leftChatMember: UserFilter = UserFilter(
        status = AnnotationState.OFF
    ),
    val document: DocumentFilter = DocumentFilter(
        status = AnnotationState.OFF
    ),
    val animation: AnimationFilter = AnimationFilter(
        status = AnnotationState.OFF
    ),
    val game: GameFilter = GameFilter(
        status = AnnotationState.OFF
    ),
    val newChatTitle: StringFilter = StringFilter(
        status = AnnotationState.OFF
    ),
    val sticker: StickerFilter = StickerFilter(
        status = AnnotationState.OFF
    ),
    val video: VideoFilter = VideoFilter(
        status = AnnotationState.OFF
    ),
    val voice: VoiceFilter = VoiceFilter(
        status = AnnotationState.OFF
    ),
    val entityArray: MessageEntityArrayFilter = MessageEntityArrayFilter(
        status = AnnotationState.OFF
    ),
    val captionEntityArray: MessageEntityArrayFilter = MessageEntityArrayFilter(
        status = AnnotationState.OFF
    ),
    val videoNote: VideoNoteFilter = VideoNoteFilter(
        status = AnnotationState.OFF
    ),
    val newChatPhoto: PhotoFilter = PhotoFilter(
        status = AnnotationState.OFF
    ),
    val deleteChatPhoto: BooleanFilter = BooleanFilter(
        status = AnnotationState.OFF
    ),
    val groupChatCreated: BooleanFilter = BooleanFilter(
        status = AnnotationState.OFF
    ),
    val venue: VenueFilter = VenueFilter(
        status = AnnotationState.OFF
    ),
    val supergroupChatCreated: BooleanFilter = BooleanFilter(
        status = AnnotationState.OFF
    ),
    val channelChatCreated: BooleanFilter = BooleanFilter(
        status = AnnotationState.OFF
    ),
    val migrateToChatId: NotNullFilter = NotNullFilter(
        status = AnnotationState.OFF
    ),
    val migrateFromChatId: NotNullFilter = NotNullFilter(
        status = AnnotationState.OFF
    ),
    val invoice: InvoiceFilter = InvoiceFilter(
        status = AnnotationState.OFF
    ),
    val successfulPayment: SuccessfulPaymentFilter = SuccessfulPaymentFilter(
        status = AnnotationState.OFF
    ),
    val connectedWebsite: StringFilter = StringFilter(
        status = AnnotationState.OFF
    ),
    val passportData: PassportDataFilter = PassportDataFilter(
        status = AnnotationState.OFF
    )
)
