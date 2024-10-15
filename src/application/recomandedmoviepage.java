package com.mycompany.mavenproject2;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.layout.FlowPane;

public class recomandedmoviepage extends FlowPane{
	
	ArrayList<Movie>  M=new ArrayList();
	public  recomandedmoviepage(ArrayList<Movie> mv) {
	    M=mv;
	try {
	    for(int i=0;i<=4;i++) {
			
			this.getChildren().add(M.get(i));
			Insets in=new Insets(4,4,4,4);
			this.setMargin(M.get(i),in);
	
		}
	}catch(Exception e) {
			
		}
		this.setLayoutX(95);
		this.setLayoutY(400);
		this.setPrefWidth(700);
		
		
		
		
	}
	
	
	
	
	
	

}
