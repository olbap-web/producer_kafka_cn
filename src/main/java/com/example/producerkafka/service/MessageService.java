package com.example.producerkafka.service;

import java.util.List;

import com.example.producerkafka.model.MessageEntity;

public interface MessageService {
    List<MessageEntity> getMessages();
    MessageEntity getMessageById(Long id);

    MessageEntity createMessage(MessageEntity message);

}