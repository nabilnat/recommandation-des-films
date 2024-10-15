package com.mycompany.mavenproject2;

import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.EventHandler;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javafx.scene.control.Button;
import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

//***********************************//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


//****************************************//
public class Movie extends AnchorPane{
	
	static SampleController SC;
	
	EventHandler MH; 
	Label lab,lab2;
	Image img;
	DropShadow DS;
	ImageView image;
	JFXButton B;
	private String Type,plot="";
	private int ID,sizex=0,sizey=0;
	
	private String URL="",db="",imdb="";
	ImageView imageView;
	Image imageI;
    URL url;
    HttpURLConnection con;
    
    
    DocumentBuilderFactory dbf;
    DocumentBuilder dbo;
    Document doc;
    
    
    int cpt=0;
	//Constructeur pour initialiser un Film avec ces Done�s 
	public Movie(String NameLab,String Type,int ID,int X,int Y,boolean Z,int imdb) {
		
		
        db=String.valueOf(imdb);
        
        cpt=7-db.length();
        
        for(int i=0;i<cpt;i++) {
        	
           db="0"+db;
        	
        	
        	
        }
        
        
        
        
        
        
		
		
		
		
		
		

		 try {

		 dbf = DocumentBuilderFactory.newInstance();
		 dbo = dbf.newDocumentBuilder();
		 doc =dbo.parse(new URL("http://www.omdbapi.com/?apikey=d55694d3&i=tt"+db+"&r=xml&plot=full").openStream());
		
		 
		 
		 } catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		 
        doc.getDocumentElement().normalize();
        
        
        NodeList d=doc.getElementsByTagName("movie"); 
        Node n=d.item(0);
        
        
        
        Element E=(Element) n;  
        

       URL=E.getAttribute("poster");
       plot=E.getAttribute("plot");

       
        
        
		B=new JFXButton();
        B.setVisible(true);

        
        final WebView browser = new WebView();
        final WebEngine webEngine = browser.getEngine();
       
        

        
        
        
        lab=new Label(NameLab);
		
        DS=new DropShadow();
 		DS.setWidth(10);
 		
 		


 		
 		
	 	this.setStyle("-fx-background-color:#FFFFFF");
		//this.setBottomAnchor(lab,0.5);
		
		this.setEffect(DS);
		
		
		
		
		
		

		
		
		if(Z) {
	        this.setPrefSize(X+10,Y+30);
	        B.setPrefSize(X+10,Y+30);//150 200 
            sizex=160;
            sizey=230;

		}else {
	        this.setPrefSize(X,Y);
	        B.setPrefSize(X,Y);
            sizex=150;
            sizey=200;
		}
	
		
		img=new Image(URL,sizex,sizey,false,false);
        BackgroundImage backgroundImage = new BackgroundImage(img,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
		B.setBackground(background);

		
			
			
			
			
	    this.getChildren().add(B);
        this.setVisible(true);
		this.setCursor(Cursor.OPEN_HAND);
		B.setOnAction(new javafx.event.EventHandler<ActionEvent>() {
      		//Quand En click Sur le Button Film cette function Sera appel�e 
			@Override
			public void handle(ActionEvent arg0) {
			try {
				SC.id=ID;
				SC.TYPE=Type;
				SC.showmovie(NameLab,Type,"",plot,ID,Type,URL);
				
				
				
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
						
				
			}
		});
	}
	
	
	}