package com.example.producerkafka.model;


import jakarta.persistence.*;

@Entity
@Table(name = "MESSAGES")
public class MessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    public MessageEntity() {}

    public MessageEntity(String content) {
        this.content = content;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}