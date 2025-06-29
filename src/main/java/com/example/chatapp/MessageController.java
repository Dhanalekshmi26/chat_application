package com.example.chatapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:5500")
@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @PostMapping("/send")
    public String sendMessage(@RequestBody Message message) {
        message.setTimestamp(LocalDateTime.now());
        message.setSeen(false);
        messageRepository.save(message);
        return "Message sent!";
    }

    @GetMapping("/unread/{username}")
    public List<Message> getUnreadMessages(@PathVariable String username) {
        return messageRepository.findByReceiverUsernameAndSeenFalse(username);
    }

    @PostMapping("/markAsSeen/{id}")
    public String markAsSeen(@PathVariable Long id) {
        Message message = messageRepository.findById(id).orElse(null);
        if (message != null) {
            message.setSeen(true);
            messageRepository.save(message);
            return "Message marked as seen.";
        }
        return "Message not found.";
    }

    @GetMapping("/conversation/{sender}/{receiver}")
    public List<message_dto> getConversation(@PathVariable String sender, @PathVariable String receiver) {
        List<Message> messages = messageRepository.findBySenderUsernameAndReceiverUsername(sender, receiver);
        return messages.stream().map(msg -> {
            message_dto dto = new message_dto();
            dto.setId(msg.getId());
            dto.setSenderUsername(msg.getSenderUsername());
            dto.setReceiverUsername(msg.getReceiverUsername());
            dto.setContent(msg.getContent());
            dto.setTimestamp(msg.getTimestamp());
            dto.setSeen(msg.isSeen());
            return dto;
        }).collect(Collectors.toList());
    }

}

