package challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MessageService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MessageService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Get all messages (display recently added based on requirements)
    public List<Map<String, Object>> getAllMessages() {
        return jdbcTemplate.queryForList("SELECT * FROM message ORDER BY id DESC");
    }

    // Query to get message by ID
    public MessageModel getMessageById(long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM message WHERE id = ?", new Object[]{id}, MessageModel.class);
    }

    // Add a new message
    public MessageModel addMessage(String messageContent) {
        jdbcTemplate.update("INSERT INTO message (name) VALUES (?)", messageContent);
        return null;
    }

    // Delete a message by ID
    public boolean deleteMessage(long id) {
        jdbcTemplate.update("DELETE FROM message WHERE id = ?", id);
        return false;
    }
}