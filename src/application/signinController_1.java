package com.mycompany.mavenproject2;


import java.sql.ResultSet;
import java.sql.*;

import com.jfoenix.controls.JFXButton;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class signinController_1 {
    	static SampleController SC;

	   private Statement state;
	   private ResultSet result;
	   private  Connection connect;
	  @FXML
	    private JFXButton sign_in_button;

	    @FXML
	    private Button button_exit;

	    @FXML
	    private TextField userfield;

	    @FXML
	    private PasswordField passwordfield;
	    
	    @FXML
	    private Text error_message;
	    

	  private  Statement stat;
	   private  ResultSet rs;

   //quiter le panneau de SignIn
    @FXML
    void quit(ActionEvent event) {
        button_exit.getParent().getScene().getWindow().hide();   

    } 
    //se connecter 
    @FXML
    void sign_in(ActionEvent event) throws SQLException, ClassNotFoundException{    	
      
    	
    	
    	result=Conection.getInstance().createStatement().executeQuery("select * from users where mail='"+userfield.getText()+"'");
    	result.beforeFirst();
        
    	
    	if(!result.next()) {
    		error_message.setText("Impossible to kkkk");
    		error_message.setVisible(true);
    		
    		
    	}else {
    	
        	result.first();

    	if(result.getString("password").equals(passwordfield.getText().toString())) {
    		SampleController.username=userfield.getText();
    		SampleController.connect=true;
    		SampleController.UserID=result.getInt("id");
    	
    		SC.show_user_recomanded_movie();
    		
    		
    		userfield.getParent().getScene().getWindow().hide();  
    		
    		
    	
    	}else {
    		error_message.setVisible(true);
    		error_message.setText("Error in email or password");
    	}
    	
    	
    	}
    	
    	
    }
    
    
    
    
    
 
    
   
    }
