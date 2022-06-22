import java.lang.RuntimeException

fun main() {
    val service = ChatService()

    service.createChat(listOf(4, 1, 5), Chat())
    service.createChat(listOf(1), Chat())
    service.addMessage(listOf(1), Message(messageText = "Hello"))
    //  println(service.chats)
    service.addMessage(listOf(3, 1, 5), Message(messageText = "Yoops", unRead = true))
    service.addMessage(listOf(1, 4, 5), Message(messageText = "123", unRead = true))
    service.addMessage(listOf(1, 4, 5), Message(messageText = "555"))
    println(service.chats)
    //  println(service.getListMessage(4))
    //   println(service.chats.get(listOf(5,1,7)))
    //  println(service.getUnreadChatsCount())
    //   service.deteteChat(4)

    service.addMessage(listOf(3, 1, 5), Message(messageText = "Ky-Ky"))
    //  println(service.chats)
    service.deleteMessage(2, 1)
    service.getListMessage(2)
    println(service.chats)
}

data class Message(
    var messageId: Int = 1,              // Id сообщения
    var messageText: String = "",          // Текст сообщения
    var unRead: Boolean = false           // false - не прочитанное сообщение, true - прочитанное
)

data class Chat(
    var chatId: Int = 0,                                      // Id чата
    var message: MutableList<Message> = mutableListOf()      // Сообщения чата
)

class ChatService {
    var chats = hashMapOf<List<Int>, Chat>()
    var countChat: Int = 0
    var countMessage: Int = 1


    fun createChat(userId: List<Int>, chat: Chat): Chat? {
        countChat++
        chat.chatId = countChat
        chat.message = mutableListOf(Message(messageText = "Hi", unRead = false))
        return chats.put(userId, chat)

    }

    fun addMessage(userIds: List<Int>, message: Message): Chat {
        if (chats.containsKey(userIds)) {
            countMessage = (chats[userIds]?.message?.last()?.messageId ?: 1) + 1
        } else countMessage = 1
        message.messageId = countMessage
        return chats.getOrPut(userIds) { Chat(chatId = countChat++) }.apply { this.message.add(message) }

    }

    fun getChats(userId: Int): List<Chat> {
        return chats.filter { entry -> entry.key.contains(userId) }.values.toList()
    }

    fun deleteMessage(chatId: Int, messageId: Int): Boolean {
        val chat = chats.values.find { it.chatId == chatId } ?: throw ChatNotFoundException("Чата $chatId нет в списке")
        if (chat.message.any { it.messageId > 1 }) {
            return chat.message.removeIf { it.messageId == messageId }
        } else {
            return deteteChat(chatId)
        }
    }

    fun deteteChat(chatId: Int): Boolean {
        return chats.keys.remove(chats.entries.find { it.value.chatId == chatId }?.key)

    }

    fun getUnreadChatsCount(): Int {
        return chats.count { entry -> entry.value.message.any { message -> !message.unRead } }

    }

    fun getListMessage(chatsId: Int): List<Message>? {
        val chat = chats.values.find { it.chatId == chatsId }
        chat?.message?.takeLastWhile {
            it.let {
                val unRead = it.unRead
                unRead == true
                unRead
            }
        }
        return chat?.message?.toList()
    }
}

class ChatNotFoundException(err: String) : RuntimeException(err)



