package com.example.springjavafxh2.controller;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.example.springjavafxh2.entity.InputText;
import com.example.springjavafxh2.service.InputTextService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import java.io.File;

@Component
public class PrimaryController implements Initializable {

    private final Logger log = LoggerFactory.getLogger(PrimaryController.class);

    @FXML
    private Label outputText; 
    
    @FXML
    private TextField inputText;

    @FXML
    private TableView outputView;

    @Autowired
    private InputTextService service;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        log.debug("PrimaryController initialized!");
        outputView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }  
    
    @FXML protected void handleSubmitButtonAction(ActionEvent event) {
        log.debug("handleSubmitButtonAction");
        service.save(new InputText(inputText.getText()));

        List<OutputData> outputDataList = new ArrayList<>();
        service.getAll().forEach(e -> outputDataList.add(new OutputData(e)));
        ObservableList<OutputData> list = FXCollections.observableArrayList(outputDataList);
        outputView.setItems(list);

        inputText.setText("");
    }
}
