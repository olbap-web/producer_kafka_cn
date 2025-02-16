package com.example.producerkafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.producerkafka.model.MessageEntity;
import com.example.producerkafka.repository.MessageRepository;

import java.util.List;
import java.util.Optional;


@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public List<MessageEntity> getMessages(){
        return messageRepository.findAll();
    }

    @Override
    public MessageEntity getMessageById(Long id){
        Optional<MessageEntity> usrOpt = messageRepository.findById(id);
        if (usrOpt.isPresent()) {
            return usrOpt.get(); 
        } else {
            return null; 
        }
    }
    @Override
    public MessageEntity createMessage(MessageEntity message){

        return messageRepository.save(message);
    }
   
   
  
}
