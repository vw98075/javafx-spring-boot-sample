package com.example.springjavafxh2.controller;

import com.example.springjavafxh2.entity.InputText;
import javafx.beans.property.SimpleStringProperty;

public class OutputData {

    private final SimpleStringProperty inputText = new SimpleStringProperty("");

    private final SimpleStringProperty timestamp = new SimpleStringProperty("");

    private final SimpleStringProperty id = new SimpleStringProperty("");

    public OutputData() {
        this(0, "", "");
    }

    public OutputData(InputText inputText){
        this.setInputText(inputText.getInputText());
        this.setTimestamp(inputText.getTimestamp().toString());
        this.setId(String.valueOf(inputText.getId()));
    }
    public OutputData(int id, String inputText, String timestamp) {
        this.setInputText(inputText);
        this.setTimestamp(timestamp);
        this.setId(String.valueOf(id));
    }

    public String getInputText() {
        return inputText.get();
    }

    public String getTimestamp() {
        return timestamp.get();
    }

    public String getId() {
        return id.get();
    }

    public void setInputText(String inputText) {
        this.inputText.set(inputText);
    }

    public void setTimestamp(String timestamp) {
        this.timestamp.set(timestamp);
    }

    public void setId(String id) {
        this.id.set(id);
    }
}
