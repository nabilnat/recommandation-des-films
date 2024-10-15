package com.mycompany.mavenproject2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class costumecell extends Label{

	private String Type,Title;
	private int ID;
	ImageView IMGV;
	
	
	
	public costumecell(String Title,String Type,int ID,String IMGPATH) throws FileNotFoundException {
		IMGV=new ImageView(new Image(new FileInputStream(IMGPATH)));
		this.setGraphic(IMGV);
		this.Title=Title;
		if(Title.length()>30) {
			this.setText(Title.substring(0,30)+"..");
		}else {
			this.setText(Title);
		}

		this.setStyle("-fx-border-color:#FFFFFF");
		this.ID=ID;
        this.Type=Type;
	}

	public String getTitle() {
		return this.Title;
	}
	
	
   public int getID() {
	   return ID;
   }




public String getType() {
	return Type;
}

}
