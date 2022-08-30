package com.example.springjavafxh2;

import java.net.URL;

public interface ViewDefinitationFileLocation {
    default URL getViewLocation() {
        return getClass().getResource("primary.fxml");
    }
}