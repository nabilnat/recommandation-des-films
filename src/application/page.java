package com.mycompany.mavenproject2;



import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.layout.FlowPane;

public class page extends FlowPane{

	ArrayList<Movie> M1=new ArrayList();
	
	
	//initialiser la page avec huit Films 
	public  page(ArrayList<Movie> mv){
	    M1=mv;
	    
		for(int i=0;i<M1.size();i++) {
			this.getChildren().add(M1.get(i));
			Insets in=new Insets(2,3,2,3);
			this.setMargin(M1.get(i),in);
		}
		
		this.setLayoutX(120);
		this.setLayoutY(150);
		this.setPrefWidth(670);
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
