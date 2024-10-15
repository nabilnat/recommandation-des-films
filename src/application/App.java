package com.mycompany.mavenproject2;

import java.io.IOException;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.fxml.FXMLLoader;


public class App extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			StackPane root = (StackPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));	
			  
                        Scene scene = new Scene(root);
                        System.out.println(getClass().getResource("application.css").getPath());
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
                        primaryStage.setTitle("Systeme De Recommandation");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		//faire Une Connection Avec La Base De Donneés 
		Conection.getInstance();
             
		launch(args);
	}
}
