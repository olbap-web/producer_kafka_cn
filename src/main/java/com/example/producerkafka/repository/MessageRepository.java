package com.example.producerkafka.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.producerkafka.model.MessageEntity;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, Long> {}
