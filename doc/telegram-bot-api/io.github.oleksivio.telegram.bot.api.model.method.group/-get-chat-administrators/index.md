[telegram-bot-api](../../index.md) / [io.github.oleksivio.telegram.bot.api.model.method.group](../index.md) / [GetChatAdministrators](./index.md)

# GetChatAdministrators

`data class GetChatAdministrators : ChatAction<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`ChatMember`](../../io.github.oleksivio.telegram.bot.api.model.objects.std/-chat-member/index.md)`>>`

**See Also**

[getChatAdministrators](#)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `GetChatAdministrators(chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`)` |

### Properties

| Name | Summary |
|---|---|
| [chatId](chat-id.md) | `val chatId: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>chat_id Integer or String Yes Unique identifier for the target chat or username of the target channel |
| [method](method.md) | `val method: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [resultWrapperClass](result-wrapper-class.md) | `val resultWrapperClass: `[`KClass`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)`<ChatMembersResponse>` |