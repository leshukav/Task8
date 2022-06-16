
import junit.framework.Assert.assertEquals
class ChatServiceTest {

    @org.junit.Test
    fun createChat() {
        val service= ChatService()
        service.createChat(listOf(1,5,2),Chat())
        service.createChat(listOf(6,8),Chat())
        assert(true)
    }
    @org.junit.Test
    fun createChatFalse() {
        val service= ChatService()
        service.createChat(listOf(1,5,2),Chat())
        service.createChat(listOf(6,8),Chat())
        assert(false)
    }

    @org.junit.Test
    fun addMessage() {
        val service= ChatService()
        service.createChat(listOf(1,2,3),Chat())
        service.addMessage(listOf(1), Message(messageText = "Hi"))

    }

    @org.junit.Test
    fun getChats() {
    }

    @org.junit.Test
    fun deteteChat() {
    }

    @org.junit.Test
    fun getUnreadChatsCount() {
    }

    @org.junit.Test
    fun getListMessage() {
    }
}