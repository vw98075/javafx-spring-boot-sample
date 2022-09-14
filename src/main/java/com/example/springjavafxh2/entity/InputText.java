package com.example.springjavafxh2.entity;

import lombok.Data;
import lombok.ToString;

import java.time.Instant;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@ToString
public class InputText {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String inputText;

    private Instant dateTime;

    public InputText() {
    }

    public InputText(String inputText) {
        this.inputText = inputText;
        this.dateTime = Instant.now();
    }
}
