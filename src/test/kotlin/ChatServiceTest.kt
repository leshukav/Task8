
import junit.framework.Assert.assertEquals
class ChatServiceTest {

    @org.junit.Test
    fun createChat() {
        val service= ChatService()
        service.createChat(listOf(1,5,2),Chat())
        val chat = service.createChat(listOf(6,8),Chat())

        assertEquals(true, chat)
    }
    @org.junit.Test
    fun createChatFalse() {
        val service= ChatService()
        service.createChat(listOf(1,5,2),Chat())
        val chat = service.createChat(listOf(6,8),Chat())

        assertEquals(false, chat)
    }

    @org.junit.Test
    fun addMessage() {
        val service= ChatService()
        service.createChat(listOf(1,2,3),Chat())
        service.addMessage(listOf(1), Message(messageText = "Hi"))
        service.addMessage(listOf(1),Message(messageText = "ky-ky"))
        val countMessage = service.countMessage
        assertEquals(2,countMessage)

    }
    @org.junit.Test
    fun addMessageFalse() {
        val service= ChatService()
        service.createChat(listOf(1,2,3),Chat())
        service.addMessage(listOf(1), Message(messageText = "Hi"))
        service.addMessage(listOf(1),Message(messageText = "ky-ky"))
        val countMessage = service.countMessage
        assertEquals(1,countMessage)

    }

    @org.junit.Test
    fun getChats() {
        val service= ChatService()
        service.createChat(listOf(1,2,3),Chat())
        service.createChat(listOf(3),Chat())
        service.getChats(2)
        val id = service.countChat
        assertEquals(2,id)
    }
    @org.junit.Test
    fun getChatsFalse() {
        val service= ChatService()
        service.createChat(listOf(1,2,3),Chat())
        service.createChat(listOf(3),Chat())
        service.getChats(2)
        val id = service.countChat
        assertEquals(3,id)
    }

    @org.junit.Test
    fun deteteChat() {
        val service= ChatService()
        service.createChat(listOf(1,2,3),Chat())
        service.createChat(listOf(3),Chat())
        val flag = service.deteteChat(2)
        assertEquals(true,flag)
    }
    @org.junit.Test
    fun deteteChatFalse() {
        val service= ChatService()
        service.createChat(listOf(1,2,3),Chat())
        service.createChat(listOf(3),Chat())
        val flag = service.deteteChat(5)
        assertEquals(true,flag)
    }

    @org.junit.Test
    fun getUnreadChatsCount() {
        val service= ChatService()
        service.createChat(listOf(1,2,3),Chat())
        service.createChat(listOf(3),Chat())
        val count = service.getUnreadChatsCount()
        assertEquals(2,count)
    }
    @org.junit.Test
    fun getUnreadChatsCountFalse() {
        val service= ChatService()
        service.createChat(listOf(1,2,3),Chat())
        service.createChat(listOf(3),Chat())
        val count = service.getUnreadChatsCount()
        assertEquals(1,count)
    }



    @org.junit.Test
    fun getListMessage() {
        val service= ChatService()
        service.createChat(listOf(1,2,3),Chat())
        service.createChat(listOf(3),Chat())
        service.addMessage(listOf(1), Message(messageText = "Hi"))
        service.addMessage(listOf(1),Message(messageText = "ky-ky"))
        val listMes = service.getListMessage(5)
        assertEquals(null,listMes)
    }

    @org.junit.Test
    fun deleteMessage(){
        val service= ChatService()
        service.createChat(listOf(1,2,3),Chat())
        service.createChat(listOf(3),Chat())
        val flag = service.deleteMessage(2,1)
        assertEquals(true, flag)
    }

    @org.junit.Test
    fun deleteMessageFalse(){
        val service= ChatService()
        service.createChat(listOf(1,2,3),Chat())
        service.createChat(listOf(3),Chat())
        val flag = service.deleteMessage(2,3)
        assertEquals(true, flag)
    }
}