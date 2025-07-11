package com.example.chatapp;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByReceiverUsernameAndSeenFalse(String receiverUsername);
    List<Message> findBySenderUsernameAndReceiverUsername(String sender, String receiver);
}
