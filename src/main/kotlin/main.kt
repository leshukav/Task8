fun main() {
  val service= ChatService()

    service.createChat(listOf(4,1,5),Chat())
    service.createChat(listOf(1),Chat())
  //  println(service.chats)
    service.addMessage(listOf(3,1,5), Message(messageText = "Yoops", unRead = true))
    service.addMessage(listOf(1,4,5), Message(messageText = "123", unRead = true))
    service.addMessage(listOf(1,4,5), Message(messageText = "555"))
    println(service.chats)
    println(service.getListMessage(4))
 //   println(service.chats.get(listOf(5,1,7)))
  // println(service.getUnreadChatsCount())
}

data class Message(
    var messageId: Int = 1,              // Id сообщения
    var messageText: String ="",          // Текст сообщения
    var unRead: Boolean = false           // false - не прочитанное сообщение, true - прочитанное
)

data class Chat(
    var chatId: Int = 0,                                      // Id чата
    var message: MutableList<Message> = mutableListOf()      // Сообщения чата
)

class ChatService {
    var chats = hashMapOf<List<Int>,Chat>()
    var countChat: Int = 1
    var countMessage: Int = 1


    fun createChat(userId: List<Int>, chat: Chat) {
        chat.chatId = countChat
        countChat++
        chat.message = mutableListOf(Message(messageText = "Hi", unRead = false))
        chats.put(userId, chat)

    }
    fun addMessage(userIds: List<Int>, message: Message) {
        if (chats.containsKey(userIds)) {
            countMessage = (chats.get(userIds)?.message?.last()?.messageId ?: 1) + 1
        } else countMessage = 1
        message.messageId = countMessage
        chats.getOrPut(userIds) {Chat(chatId = countChat++)}.apply { chats.get(userIds)?.message?.add(message) }

    }

    fun getChats(userId: Int) : List<Chat> {
        return chats.filter { entry -> entry.key.contains(userId) }.values.toList()
    }

    fun deleteMessage(chatId: Int, messageId: Int) : Boolean {
        TODO()
    }
     fun deteteChat(chatId: Int) : Boolean {
         TODO()
     }
    fun getUnreadChatsCount() : Int {
  //    var b: Int
  //    chats.filter  {var b = chats.values.equals(Message().unRead) == false
   //      b -> b++   }

   ///     return b
        TODO()
    }
    fun getListMessage(chatsId: Int): List<Pair<List<Int>, Chat>> {
       return chats.filter { it.value.chatId == chatsId }.toList()

    }

}



