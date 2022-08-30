package com.example.springjavafxh2.controller;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import com.example.springjavafxh2.entity.InputText;
import com.example.springjavafxh2.service.InputTextService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

@Component
public class PrimaryController implements Initializable {

    private final Logger log = LoggerFactory.getLogger(PrimaryController.class);

    @FXML
    private Label outputText; 
    
    @FXML
    private TextField inputText;

    @Autowired
    private InputTextService service;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        log.debug("PrimaryController initialized!");
    }  
    
    @FXML protected void handleSubmitButtonAction(ActionEvent event) {
        log.debug("handleSubmitButtonAction");
        service.save(new InputText(inputText.getText(),LocalDateTime.now()));
        outputText.setText(inputText.getText() + "\t" + LocalDateTime.now() + "\nTotal Number: " + service.getTotal());
        inputText.setText("");
    }
}
