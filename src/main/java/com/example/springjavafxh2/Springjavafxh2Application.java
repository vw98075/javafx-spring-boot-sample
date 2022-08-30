package com.example.springjavafxh2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.gluonhq.ignite.spring.SpringContext;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

@SpringBootApplication
@ComponentScan({"com.gluonhq.ignite.spring", "com.example.springjavafxh2"})
public class Springjavafxh2Application extends Application implements ViewDefinitationFileLocation {

	public static void main(String[] args) {
		Application.launch(Springjavafxh2Application.class, args);
	}

    @Autowired
    private FXMLLoader loader;
    
    private final SpringContext context = new SpringContext(this);
    private static Scene scene;
	
	@Override
	public void start(Stage stage) throws Exception {
        context.init(() -> SpringApplication.run(Springjavafxh2Application.class));
        loader.setLocation(getViewLocation());
        Parent primaryView = loader.load();
		stage.setTitle("Spring Boot JavaFX Sample");
        stage.setScene(scene = new Scene(primaryView));
        stage.show();		
	}

	public static void setRoot(Parent view) {
        scene.setRoot(view);
    }	
}
