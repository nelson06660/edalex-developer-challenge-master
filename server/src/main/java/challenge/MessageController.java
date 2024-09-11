package challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/message")
public class MessageController {
    /*@GetMapping
    List<MessageModel> listMessages() {
        // TODO - This is just a place holder, we expect to see this replaced using your service/persistence layer
        List<MessageModel> messages = new ArrayList<>();
        messages.add(new MessageModel(1, "First Message"));
        messages.add(new MessageModel(2, "Second Message"));
        messages.add(new MessageModel(3, "Third Message"));
        // end

        return messages;
    }*/

    @Autowired
    private MessageService messageService;
    /*@Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }*/

    // GET(get all messages)
    @GetMapping
    public List<Map<String, Object>> listMessages() {
        return messageService.getAllMessages();
    }

    // GET(get message by its ID)
    @GetMapping("/{id}")
    public Optional<MessageModel> getMessageById(@PathVariable Long id) {
        return Optional.ofNullable(messageService.getMessageById(id));
    }

    // POST(post method for adding message)
    @PostMapping
    public MessageModel addMessage(@RequestBody String messageContent) {
        return messageService.addMessage(messageContent);
    }

    // DELETE(removing message using its unique ID)
    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable Long id) {
        boolean removed = messageService.deleteMessage(id);
        if (!removed) {
            throw new RuntimeException("Message not found with id " + id);
        }
    }

}
