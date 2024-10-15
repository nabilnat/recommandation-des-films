package com.mycompany.mavenproject2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSlider;

import de.jensd.fx.glyphs.materialicons.MaterialIconView;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import de.jensd.fx.glyphs.octicons.OctIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;


public class signupController{
	
   private Statement state;
   private ResultSet result;

	@FXML
    private AnchorPane siginup;

    @FXML
    private TextField firstname_signuppanel;
    
    @FXML
    private PasswordField password_signuppanel;

    @FXML
    private TextField secondname_signuppanel;

    @FXML
    private PasswordField verification_password_signuppanel;

    @FXML
    private TextField mail_signuppanel;

   
    @FXML
    private JFXButton signup_button_signuppanel;
    
    
    @FXML
    private Label err_message;

    @FXML
    private MaterialIconView first_name_err;

    @FXML
    private MaterialIconView seconde_name_err;

    @FXML
    private MaterialIconView mail_err;

    @FXML
    private MaterialIconView password_err;

    @FXML
    private MaterialIconView password1_err;
    
    
    @FXML
    private JFXButton signup_button_signuppanel2;

    @FXML
    private Label action_label;

    @FXML
    private Label horror_label;

    @FXML
    private Label chaildre_label;

    @FXML
    private Label crime_label;

    @FXML
    private Label romance_label;

    @FXML
    private Label adventure_label;

    @FXML
    private Label animation_label;

    @FXML
    private Label comedy_label;

    @FXML
    private JFXSlider action_slider;

    @FXML
    private JFXSlider adventure_slider;

    @FXML
    private JFXSlider animation_slider;

    @FXML
    private JFXSlider comedy_slider;

    @FXML
    private JFXSlider romance_slider;

    @FXML
    private JFXSlider crime_slider;

    @FXML
    private JFXSlider childre_slider;

    @FXML
    private JFXSlider horror_slider;

    @FXML
    private Label min_label;

    @FXML
    private Label max_label;

    @FXML
    private Label median_label;
    
    @FXML
    private MaterialDesignIconView icons;
    
    
    
    
    private ResultSet RS;

   private boolean insert=false,sliders=false;

    
    //pour Saisir vos Donne�s d'insription 
    @FXML
    void signin(ActionEvent event) throws SQLException {
    	boolean B=false;
    	
    	
    	if(firstname_signuppanel.getText().length()>0 && secondname_signuppanel.getText().length()>0 &&
    		mail_signuppanel.getText().length()>0 && password_signuppanel.getText().equals(verification_password_signuppanel.getText()) 
    		&& password_signuppanel.getText().length()>0 && verification(mail_signuppanel.getText())) {
    		
    		
    		state=Conection.getInstance().createStatement();
    		RS=state.executeQuery("select * from users where mail='"+mail_signuppanel.getText()+"'");
    		
    		if(!RS.next()){
    			insert=true;
    			//slider_to_zero();
        		state.executeUpdate("INSERT INTO users (user,password,mail,firstname,secondename)"
        				+ "VALUES('user','"+password_signuppanel.getText()+"','"+mail_signuppanel.getText()+"','"+firstname_signuppanel.getText()+"','"+secondname_signuppanel.getText()+"')");

        		
    			to_next_page();
        		B=true;

    		}else {
    			err_message.setText("email already existe");
    			err_message.setVisible(true);
    		}
    		
    		
    		
    		
    		
    	}else {
    		
    		if(firstname_signuppanel.getText().length()==0) {
    			first_name_err.setVisible(true);
    		}else {
    			first_name_err.setVisible(false);

    		}
    		
    		if(secondname_signuppanel.getText().length()==0) {
    			seconde_name_err.setVisible(true);
    		}else {
    			seconde_name_err.setVisible(false);

    		}
    		
    		if(mail_signuppanel.getText().length()==0) {
    			mail_err.setVisible(true);
    		
    		
    		}else{
    			if(mail_signuppanel.getText().indexOf("@")<0){
    			    
    				err_message.setText("Email is not valid");
    		        err_message.setVisible(true);
    		        mail_err.setVisible(true);
    			
    			}else {
    				err_message.setVisible(false);
    		        mail_err.setVisible(false);

    				
    				
    				
    				mail_err.setVisible(false);
    			}
    			
    		}
    		
    		if(password_signuppanel.getText().length()==0) {
    			password_err.setVisible(true);
    		}else {
    			password_err.setVisible(false);
    		}
    		
    	
    		
    		if(verification_password_signuppanel.getText().length()==0){
    			password1_err.setVisible(true);
    		}else {
    			password1_err.setVisible(false);
    		
    		}
    		
    		
    		if(password_signuppanel.getText().equals(verification_password_signuppanel.getText())) {
    		    	
    		}else {
    			err_message.setText("passwords do not match");
    			err_message.setVisible(true);
    			password1_err.setVisible(true);
    			password_err.setVisible(true);
    			
    			
    			
    			
    		}
    		
    		
    		
    		
    	}
    /*	
      if(B)
        mail_signuppanel.getParent().getScene().getWindow().hide();   
    */	

        }
    //fermer le panneau d'inscription 
    @FXML
    void quit(ActionEvent event) {
       
     mail_signuppanel.getParent().getScene().getWindow().hide();   
    		
   
    }
    
   
    @FXML
    void signin2(ActionEvent event) throws SQLException {
        int id=0;
    	

    	result=state.executeQuery("SELECT id FROM users where mail='"+mail_signuppanel.getText()+"'");
    	
    	
    	result.first();
        id=result.getInt("id");
    	
    	
    	
    	state.executeUpdate("INSERT INTO preference VALUE('"+id+"','Action','"+(int) action_slider.getValue()+"')");
    	state.executeUpdate("INSERT INTO preference VALUE('"+id+"','Adventure','"+(int) adventure_slider.getValue()+"')");
    	state.executeUpdate("INSERT INTO preference VALUE('"+id+"','Animation','"+(int) animation_slider.getValue()+"')");
    	state.executeUpdate("INSERT INTO preference VALUE('"+id+"','Comedy','"+(int) comedy_slider.getValue()+"')");
    	state.executeUpdate("INSERT INTO preference VALUE('"+id+"','Romance','"+(int) romance_slider.getValue()+"')");
    	state.executeUpdate("INSERT INTO preference VALUE('"+id+"','Crime','"+(int) crime_slider.getValue()+"')");
    	state.executeUpdate("INSERT INTO preference VALUE('"+id+"','Children','"+(int) childre_slider.getValue()+"')");
    	state.executeUpdate("INSERT INTO preference VALUE('"+id+"','Horror','"+(int) horror_slider.getValue()+"')");

         	
    	
        mail_signuppanel.getParent().getScene().getWindow().hide();   

    	
    	
    	
    	
    }
   
    private void slider_to_zero() {
    	
    	 action_slider.setValue(0);
         adventure_slider.setValue(0);
         animation_slider.setValue(0);
         comedy_slider.setValue(0);
         romance_slider.setValue(0);
         crime_slider.setValue(0);
         childre_slider.setValue(0);
         horror_slider.setValue(0);
    	
    	
    	
    }
    
    private  void to_next_page() {
    	//first page off
    	

         firstname_signuppanel.setVisible(false);
         password_signuppanel.setVisible(false);
         secondname_signuppanel.setVisible(false);
         verification_password_signuppanel.setVisible(false);
         mail_signuppanel.setVisible(false);
         signup_button_signuppanel.setVisible(false);
         err_message.setVisible(false);
         first_name_err.setVisible(false);
         seconde_name_err.setVisible(false);
         mail_err.setVisible(false);
         password_err.setVisible(false);
         password1_err.setVisible(false);
         icons.setVisible(false);
    	
    	//next page on
    	 signup_button_signuppanel2.setVisible(true);
    	 action_label.setVisible(true);
         horror_label.setVisible(true);
         chaildre_label.setVisible(true);
         crime_label.setVisible(true);
         romance_label.setVisible(true);
         adventure_label.setVisible(true);
         animation_label.setVisible(true);
         comedy_label.setVisible(true);
         action_slider.setVisible(true);
         adventure_slider.setVisible(true);
         animation_slider.setVisible(true);
         comedy_slider.setVisible(true);
         romance_slider.setVisible(true);
         crime_slider.setVisible(true);
         childre_slider.setVisible(true);
         horror_slider.setVisible(true);
         min_label.setVisible(true);
         max_label.setVisible(true);
         median_label.setVisible(true);
    	
    	
    	
    }
    
    
    
    
    private boolean verification(String g) {
    	if(g.indexOf("@")>0) {
    		return true;
    	}else {
    		return false;
    	}
    }
    
    
    
    
    

}
