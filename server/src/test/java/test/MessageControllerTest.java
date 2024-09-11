package test;

import challenge.MessageController;
import challenge.MessageModel;
import challenge.MessageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MessageControllerTest {

    @Mock
    private MessageService messageService;

    @InjectMocks
    private MessageController messageController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // Get all messagees
    @Test
    public void testListMessages() {
        // Arrange: Set up mock response
        List<Map<String, Object>> mockMessages = Collections.emptyList();
        when(messageService.getAllMessages()).thenReturn(mockMessages);

        // Act: Call the controller method
        List<Map<String, Object>> result = messageController.listMessages();

        System.out.println(result + "Test message Nelson3");
        assertEquals(mockMessages, result);
        verify(messageService, times(1)).getAllMessages();
    }
    /*retrieving a message by ID*/
    @Test
    public void testGetMessageById() {
        /*Set up mock message*/
        long messageId = 1L;
        MessageModel mockMessage = new MessageModel(messageId, "Mock message");
        when(messageService.getMessageById(messageId)).thenReturn(mockMessage);

        Optional<MessageModel> result = messageController.getMessageById(messageId);

        //System.out.println(result + "Test message Nelson1");
        assertEquals(Optional.of(mockMessage), result);
        verify(messageService, times(1)).getMessageById(messageId);
    }

    // ADD Message
    @Test
    public void testAddMessage() {
        String messageContent = "Mock Message";
        MessageModel mockMessage = new MessageModel(1L, messageContent);
        when(messageService.addMessage(messageContent)).thenReturn(mockMessage);

        MessageModel result = messageController.addMessage(messageContent);

        // System.out.println(result + "Test message Nelson2");
        assertEquals(mockMessage, result);
        verify(messageService, times(1)).addMessage(messageContent);
    }

    // Delete message by ID
    @Test
    public void testDeleteMessage() {
        /*mock for deletion*/
        long messageId = 1L;
        when(messageService.deleteMessage(messageId)).thenReturn(true);

        messageController.deleteMessage(messageId);

       // System.out.println(messageId + "Test message Nelson4");
        verify(messageService, times(1)).deleteMessage(messageId);
    }
}
