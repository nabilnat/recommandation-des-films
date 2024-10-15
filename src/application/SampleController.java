package com.mycompany.mavenproject2;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.controlsfx.control.Rating;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXListView;
import com.mysql.jdbc.SocketMetadata.Helper;

import de.jensd.fx.glyphs.materialicons.MaterialIconView;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javafx.scene.web.WebView; 




public class SampleController implements Initializable{
	

    @FXML
    private AnchorPane mainpane;

    @FXML
    private WebView webview;
     
    @FXML
    private AnchorPane search_banner;

    @FXML
    private TextField search;

    @FXML
    private JFXButton tendance;

    @FXML
    private JFXButton search_button;

    @FXML
    private JFXButton Filter_pane;

    @FXML
    private MaterialDesignIconView swip_left_image;

    @FXML
    private JFXButton swip_left_button;

    @FXML
    private MaterialDesignIconView swipe_right_image;

    @FXML
    private JFXButton swipe_right_button;

    @FXML
    private JFXButton logout;

    @FXML
    private Label user_label;

    @FXML
    private MaterialDesignIconView accountlogo;

    @FXML
    private JFXButton signin;

    @FXML
    private JFXButton signupp;

    @FXML
    private JFXButton watch_button;

    @FXML
    private MaterialDesignIconView watch_button_icon;

    @FXML
    private Label title_label;

    @FXML
    private MaterialDesignIconView return_icon;

    @FXML
    private JFXButton return_button;

    @FXML
    private Label Rating_Label;

    @FXML
    private Label Views_label;

    @FXML
    private Label views_values;

    @FXML
    private Label rating_values;

    @FXML
    private MaterialDesignIconView rating_star_icon;

    @FXML
    private JFXButton movie_button_image;

    @FXML
    private Label categorie_label;

    @FXML
    private Label categorie_values;

    @FXML
    private Label desci_label;


    @FXML
    private Label RM_label;

    @FXML
    private MaterialDesignIconView swipe_left_rmv_image;

    @FXML
    private JFXButton swipe_left_rmv;

    @FXML
    private MaterialDesignIconView swipe_right_rmv_image;

    @FXML
    private JFXButton swipe_right_rmv;

    @FXML
    private AnchorPane FilterPane;

    @FXML
    private JFXCheckBox Action_Combox;

    @FXML
    private JFXCheckBox Comedy_Combox;

    @FXML
    private JFXCheckBox Drama_Combox;

    @FXML
    private JFXCheckBox Animation_Combox;

    @FXML
    private JFXCheckBox Horror_Combox;

    @FXML
    private JFXCheckBox Fantasy_Combox;

    @FXML
    private JFXCheckBox Children_Combox;

    @FXML
    private JFXCheckBox Mystery_Combox;

    @FXML
    private JFXCheckBox Ratings_Combox;

    @FXML
    private JFXCheckBox Views_Combox;

    @FXML
    private JFXButton Filter;
    
    @FXML
    private MaterialIconView SHMICON;

    @FXML
    private JFXButton SHM;
    

    @FXML
    private AnchorPane leftbanner;
    
    @FXML
    private JFXButton HHM;
    
    @FXML
    private Rating RatingBar;
    
    @FXML
    private JFXListView<costumecell> History_LV;
    
    @FXML
    private JFXListView<costumecell> WishList;
    
    
    @FXML 
    private JFXButton HomeButton;
    
    
    @FXML
    private Label AddtowishlistLabel;

    @FXML
    private JFXCheckBox wishlistcheckbox;
    
    
    @FXML
    private Text descrition_label_text;
    
    @FXML
    private MediaView media_view;
    
    
    @FXML
    private AnchorPane movie_anchor;
    
    
    @FXML
    private Text username_text;
    
    
    
    
    

    
    private MediaPlayer mp;
    
    private Media m;
    
    
    

    boolean ofirst=true;

    Stage newStage ;
    private int movie_id,pos,pos2;
    static int id,UserID;
    static boolean connect=false;
    boolean RM,FiterPanelStatus=false,COMBO[]=new boolean[9];
    static String username;
    
    private Statement state;
    private ResultSet result,result1,result2,result3,result4,RS;
    
    static ArrayList<Movie>MV=new ArrayList<>();
    static ArrayList<Movie> RMV=new ArrayList<Movie>();
    static page P;
    static recomandedmoviepage P1;
    
    static String TYPE;
    
    static Statement state1;
    
	 private BackgroundImage backgroundImage;
	 private Background background;
     private Image img;
 	 private String URL;
 	 private int imdbid;
 	 
 	 private ArrayList<CAL> CALR;
 	 
 	 
 	 
 	 private DocumentBuilderFactory dbf;
     private DocumentBuilder dbo;
     private Document doc;
     
     
     
     

     
    
    
    
    
    
    


//pour afficher le Sign up page
@FXML 
void showsinguppane(ActionEvent event) throws Exception {
    	signupp.getParent().setEffect(new BoxBlur());
        signupp.getParent().setDisable(true);
    	Stage newStage = new Stage();
        AnchorPane anchorPanePopup = (AnchorPane) FXMLLoader.load(getClass().getResource("signup.fxml"));
        Scene scene = new Scene(anchorPanePopup);
        newStage.setScene(scene);
        newStage.initStyle(StageStyle.UNDECORATED);
        newStage.initModality(Modality.APPLICATION_MODAL);
        newStage.showAndWait();
        signupp.getParent().setEffect(null);
        signupp.getParent().setDisable(false);        
    }

//pour afficher le Sign in page
@FXML
void showsinginpane(ActionEvent event) throws IOException {
    	signin.getParent().setEffect(new BoxBlur());
    	signin.getParent().setDisable(true);
    	Stage newStage = new Stage();
        AnchorPane anchorPanePopup = (AnchorPane) FXMLLoader.load(getClass().getResource("signin.fxml"));
        Scene scene = new Scene(anchorPanePopup);
        newStage.setScene(scene);
        newStage.initStyle(StageStyle.UNDECORATED);
        newStage.initModality(Modality.APPLICATION_MODAL);
        newStage.showAndWait();
        signin.getParent().setEffect(null);
        signin.getParent().setDisable(false);
        if(connect) {
      	  signupp.setVisible(false);
      	  signin.setVisible(false);
      	  logout.setVisible(true);
      	 
      	  
      	  username_text.setText(username); 
      	  username_text.setVisible(true);
      	  
      	  accountlogo.setVisible(true);
        }
    }
//Pour Deconnecter 
@FXML
void logout(ActionEvent event)throws SQLException {
    
    	  signupp.setVisible(true);
    	  signin.setVisible(true);
    	  logout.setVisible(false);
    	  user_label.setText("");
    	  username_text.setVisible(false);
    	  accountlogo.setVisible(false);
          connect=false;
          load_default_movie();

          
    }
private boolean moviepaneopened=false;
//pour voir un film 
@FXML
void watch(ActionEvent event) throws SQLException {
         
        state.executeUpdate("update tendance set nbvue=nbvue+1 where movieId='"+id+"' ");
    
        if(id!=0) {
            result4=state.executeQuery("SELECT  AS S FROM  WHERE movieId='"+id+"' ");
            result4.first();
            int S=result4.getInt("S");
            mp.play();        	
        	media_view.setVisible(true);
        	media_view.toFront();
        	movie_anchor.setVisible(true);
        	moviepaneopened=true;
        	watch_button.setVisible(false);
        	watch_button_icon.setVisible(false);
        }else {
        
        show_movie(false);
    	show_mainpage(true);

        }    	
    	if(connect) {
    		
    		
    		result4=state.executeQuery("SELECT COUNT(*) AS S FROM wishlist WHERE movieId='"+id+"' ");
    		
    		
    		result4.first();

    		int S=result4.getInt("S");
    		
    		if(S>0) {
    			state.executeUpdate("DELETE FROM wishlist WHERE movieId='"+id+"'");
    		}

    	   
    		state.executeUpdate("INSERT INTO historique(userId,movieId) VALUES('"+UserID+"','"+id+"'); ");

    	
    	}
    	
    	
    	
    }

//pour changer agauche les films dans le main page 
@FXML
void swip_left(ActionEvent event) throws SQLException {
    	
        if(MV.size()>0)MV.clear();
        
       
    	  for(int i=0;i<8&&result.next();i++) {
    	   
    	   String S=result.getString("title");
    	   String Y="";
    	  Y=AUDD(S);
        MV.add(new Movie(Y,result.getString("genres"),result.getInt("movieId"),150,200,true,result.getInt("imdbid"))); 
       
        
       
    	  
      }
     
        mainpane.getChildren().remove(P);
   	    P=new page(MV);
 		mainpane.getChildren().add(P);
 		
        on_off_swipe();


    
    }

//pour changer a droite les films dans le main page 
@FXML
void swipe_right(ActionEvent event) throws SQLException {
    	
    	
        if(MV.size()>0)MV.clear();
        
        for(int j=0;j<16;j++)result.previous();
        for(int i=0;result.next()&& i<8;i++) {
           String S=result.getString("title");
      	   String Y="";
      	   Y=AUDD(S);
       	MV.add(new Movie(Y,result.getString("genres"),result.getInt("movieId"),150,200,true,result.getInt("imdbid"))); 

      	
       
        }
    	mainpane.getChildren().remove(P);
    	P=new page(MV);
	    mainpane.getChildren().add(P);
        on_off_swipe();

        
    }

//pour voir la tendance
@FXML
void tendance(ActionEvent event) throws SQLException {		
    
        result=state.executeQuery("SELECT movies.imdbid,movies.title,movies.genres,movies.movieId,tendance.nbvue FROM tendance,movies WHERE tendance.movieId=movies.movieId ORDER BY tendance.nbvue DESC "); 	
        if(MV.size()>0)MV.clear();
        
        for(int i=0;result.next()&& i<8;i++) {
    	   
        	
				MV.add( new Movie( AUDD ( result.getString("title") ),result.getString("genres"),result.getInt("movieId"),150,200,true,result.getInt("imdbid")) );

       }
       
        mainpane.getChildren().remove(P);
   	    P=new page(MV);
 		mainpane.getChildren().add(P);

    	
    }
 
//cette function sera lancer an lancement de l'application elle sert a initiliaser le main page    
public void initialize(URL location, ResourceBundle resources){
		   
    		Movie.SC=this;
    		signinController.SC=this;
     	   	//String mediaPath = "file:///C:/Users/admin/Documents/NetBeansProjects/mavenproject2/src/main/java/com/mycompany/mavenproject2/TOY.mp4"; 
        	//m=new Media(mediaPath);
                

        	
        	//mp=new MediaPlayer(m);
                
                
                //System.out.println("media");
        	//media_view.setMediaPlayer(mp);
        	//media_view.setScaleX(1.6);
        	//media_view.setLayoutX(143);
        	
        	
        	
        	
        	CALR=new ArrayList<CAL>();
        	
    		try {
				state=Conection.getInstance().createStatement();
			
           
				load_default_movie();
            } catch (SQLException e1) {
				e1.printStackTrace();
			}
 
             
     		
		
		
		
	}
 
//charger film part default dans la page de film 
private void load_default_movie() throws SQLException {
          
	      if(MV.size()>0)MV.clear();

            result=state.executeQuery("SELECT * FROM movies ");
           for(int i=0;result.next()&& i<8;i++) {
        	  
            MV.add(new Movie(AUDD(result.getString("title")),result.getString("genres"),result.getInt("movieId"),150,200,true,result.getInt("imdbid"))); 
            RMV.add(new Movie("zzz","zzzz",44,130,200,false,result.getInt("imdbid")));
           }
        	
            P1=new recomandedmoviepage(RMV);
        	
            mainpane.getChildren().remove(P);
       	    P=new page(MV);
     		mainpane.getChildren().add(P);

    	}
    	
//cette function sert a couper les String en multiple String   	
private String AUDD(String S) {
    	    	String Y="",m="";
    	    	 if(S.length()>=20) {
    	      	   while(S.length()>=20) {
    	      		   
    	      		   Y=S.substring(0,20);
    	      		   m=Y+"\n"+m;
    	      		   S=S.substring(20,S.length());
    	      	   }
    	      	   Y=Y+"\n"+S;
    	      	  }else {
    	      		  Y=S;
    	      	  }
    	    	 return Y;
    	    }

//afficher la Page De Film 
void showmovie(String Title,String Categorie,String Range,String Description,int ID,String type,String URL)throws SQLException
{
	String rate="0.0",vu="0";
    
	
	img=new Image(URL,204,272,false,false);
	backgroundImage = new BackgroundImage(img,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
    background = new Background(backgroundImage);
  
    
    movie_button_image.setBackground(background);
    
    
	movie_button_image.setStyle("-fx-background-image:img");
	
	
    show_mainpage(false);
	show_movie(true);
    
	result2=state.executeQuery("SELECT sum(ratings.rating)/count(ratings.userId) as result,tendance.nbvue FROM ratings inner JOIN tendance on ratings.movieId=tendance.movieId WHERE ratings.movieId='"+ID+"'");
  
	
   
    
    	
    	result2.beforeFirst();
        result2.first();
        try {
    	rate=String.valueOf(result2.getFloat("result")).substring(0,result2.getString("result").indexOf(".")+2);
       
        }catch(Exception e) {
        	
        }
        vu=String.valueOf(result2.getInt("nbvue"));

    
    
    title_label.setText(Title);
    rating_values.setText(rate);
    views_values.setText(vu);

    categorie_values.setText(type);
    
    
    
    if(Description.length()>=541) {
    	String s="";
    	s=Description.substring(0,541)+"...";
        descrition_label_text.setText(s);

    }else {
    descrition_label_text.setText(Description);
    }
    show_recomanded_movie(type);
	
    id=ID;
	    
}

//allumer les contents de la page film par true 
private void show_movie(boolean F) {
	
	 watch_button.setVisible(F);
     watch_button_icon.setVisible(F);
     title_label.setVisible(F);
     return_button.setVisible(F);
     return_icon.setVisible(F);
     views_values.setVisible(F);
     Views_label.setVisible(F);
     rating_values.setVisible(F);
     Rating_Label.setVisible(F);
     rating_star_icon.setVisible(F);
     movie_button_image.setVisible(F);
     categorie_label.setVisible(F);
     categorie_values.setVisible(F);
     desci_label.setVisible(F);
     RM_label.setVisible(F);
     swipe_left_rmv_image.setVisible(F); 
     descrition_label_text.setVisible(F);
     swipe_left_rmv.setVisible(F);
     swipe_right_rmv_image.setVisible(F);
     swipe_right_rmv.setVisible(F);
     
     RatingBar.setVisible(false);
    
     AddtowishlistLabel.setVisible(false);
     wishlistcheckbox.setVisible(false);
     
     desci_label.setLayoutX(381);desci_label.setLayoutY(180);
     descrition_label_text.setLayoutX(381);descrition_label_text.setLayoutY(212);
     
     
     
     
     if(connect) {
    	 username_text.setVisible(true);
    	 logout.setVisible(false);
         RatingBar.setVisible(true);
         
         AddtowishlistLabel.setVisible(true);
         AddtowishlistLabel.setLayoutX(381);AddtowishlistLabel.setLayoutY(180);
         
         wishlistcheckbox.setVisible(true);
         wishlistcheckbox.setLayoutX(498);wishlistcheckbox.setLayoutY(182);
         
             
         desci_label.setLayoutX(383);desci_label.setLayoutY(210);
         descrition_label_text.setLayoutX(383);descrition_label_text.setLayoutY(242);

         
         
     
     }
     

    if(F)
     mainpane.getChildren().add(P1);
     P1.setVisible(F);

     
}

//allumer les contents de la page main 
private void show_mainpage(boolean F) throws SQLException {
	    search_banner.setVisible(F);
        tendance.setVisible(F);
        swip_left_button.setVisible(F);
        swip_left_image.setVisible(F);
        swipe_right_button.setVisible(F);
        swipe_right_image.setVisible(F);
        P.setVisible(F);
        signin.setVisible(F);
        signupp.setVisible(F);
        
        logout.setVisible(false);
        username_text.setVisible(false);
        accountlogo.setVisible(false);
       
        
        RatingBar.setVisible(false);
        wishlistcheckbox.setVisible(false);
        AddtowishlistLabel.setVisible(false);
        
        mainpane.getChildren().remove(P1);
        
        media_view.setVisible(false);
        
        if(connect) {
        	signin.setVisible(false);
        	signupp.setVisible(false);
            
        	logout.setVisible(true);
            
        	username_text.setVisible(true);
            accountlogo.setVisible(true);

        	
        }
             RM=false;
}

//retour a la main_page
@FXML
void retun_to_mainpage(ActionEvent event)throws Exception{
	
	if(moviepaneopened) {
		movie_anchor.setVisible(false);
	    moviepaneopened=false;
        mp.stop();
        watch_button.setVisible(true);
        watch_button_icon.setVisible(true);

	}else {
	
    show_movie(false);
	show_mainpage(true);
	}
	
	if(connect) {
		if(RatingBar.getRating()>0)
		 state.executeUpdate("INSERT INTO ratings value('"+UserID+"','"+id+"','"+RatingBar.getRating()+"','0')");
	    
	     RatingBar.setRating(0);
	     
	    if(wishlistcheckbox.isSelected()) {
	    	
	    	state.executeUpdate("INSERT INTO wishlist(userId,movieId) value('"+UserID+"','"+id+"')");
	        wishlistcheckbox.setSelected(false);
	        
	    
	    }
	     
	 
	     
	
	}
	
	
}

//afficher les films recommander 
void show_recomanded_movie(String genres) throws SQLException {
	
	mainpane.getChildren().remove(P1);
	if(RMV.size()>0)RMV.clear();
	
    result1=state.executeQuery("SELECT title,genres,movieId,imdbid FROM itemitems,movies WHERE itemitems.movieId1="+id+" AND  itemitems.movieId2=movies.movieId ORDER BY itemitems.semelarite DESC LIMIT 200");
    
    
    if(!result1.next()) {

       result1=state.executeQuery("SELECT * FROM movies where genres like '"+genres+"%' and movieId!='"+id+"'");
       System.out.println("SELECT * FROM movies where genres like '"+genres+"%' and movieId!='"+id+"'");
    
    }else {
    	result1.beforeFirst();
    	
    }
 
    for(int i=0;i<5&&result1.next();i++){
	    
    	
    	RMV.add(new Movie(AUDD(result1.getString("title")),result1.getString("genres"),result1.getInt("movieId"),130,200,false,result1.getInt("imdbid")));    	
    	
     }

    P1=new recomandedmoviepage(RMV);
    mainpane.getChildren().add(P1);
    
	 
	
}

//changer les film recommander a gauche
@FXML
void Fswipe_left_rmv(ActionEvent event) throws SQLException {
      
	if(RMV.size()>0)RMV.clear();
	
	  mainpane.getChildren().remove(P1);
	  
      
    	  for(int i=0;i<5&&result1.next();i++){

    		  RMV.add(new Movie(AUDD(result1.getString("title")),result1.getString("genres"),result1.getInt("movieId"),130,200,false,result1.getInt("imdbid")));    	

    	  }
    	  
    	   P1=new recomandedmoviepage(RMV);
    	    
    	   mainpane.getChildren().add(P1);
      }

//changer les film recommander a Droite
@FXML
void Fswipe_right_rmv(ActionEvent event) throws SQLException {
    
	if(RMV.size()>0)RMV.clear();
	

	  mainpane.getChildren().remove(P1);

		for(int i=0;i<10;i++)result1.previous();

		
		for(int i=0;i<5&&result1.next();i++) {
        
	    	RMV.add(new Movie(AUDD(result1.getString("title")),result1.getString("genres"),result1.getInt("movieId"),130,200,false,result1.getInt("imdbid")));    	
	                                        }
		

	    P1=new recomandedmoviepage(RMV);
	    
	    mainpane.getChildren().add(P1);
		
		
		
	}

//recherche d'un film
@FXML
void go_search(ActionEvent event) throws SQLException {
	
	if(search.getText().length()>0) {
     result=state.executeQuery("select * from movies where title like '"+search.getText()+"%'");
     mainpane.getChildren().remove(P);
     if(MV.size()>0)MV.clear();
     for(int i=0;result.next()&&i<8;i++ )
     {
  	  
    	MV.add(new Movie(AUDD(result.getString("title")),result.getString("genres"),result.getInt("movieId"),150,200,true,result.getInt("imdbid"))); 

    	 
    	
     }
     
	    P=new page(MV);
		mainpane.getChildren().add(P);
        on_off_swipe();
        System.out.println(MV.size());	
	}
}

//mettre le button de changement de film a off 
private void on_off_swipe() {
	if(MV.size()<7)swip_left_button.setDisable(true);
	if(MV.size()>=8)swip_left_button.setDisable(false);
}

//charger les films recommander pour l'utilisateur 
void show_user_recomanded_movie() throws SQLException {

	result=state.executeQuery("SELECT movies.imdbid,movies.movieId,movies.title,movies.genres FROM movies,useritems where movies.movieId=useritems.movieId AND useritems.userid='"+UserID+"' order by useritems.semelarite DESC LIMIT 250");
	 mainpane.getChildren().remove(P);
	
	 if(!result.next()) {
		 String IN="";

		 result2=state.executeQuery("SELECT * FROM preference WHERE userId="+UserID+" AND genrevalue>0 ORDER BY genrevalue DESC ");
        
		  
		 while(result2.next()) {
			 
			 
			 CALR.add(new CAL(result2.getString("genre"),result2.getInt("genrevalue")));
			 
		 }
		 
		 
		 if(CALR.size()==1)IN="('"+CALR.get(0).getG()+"')";
		  if(CALR.size()==2)IN="('"+CALR.get(0).getG()+"','"+CALR.get(1).getG()+"','"+CALR.get(0).getG()+"|"+CALR.get(1).getG()+"')";
		   if(CALR.size()==3)IN="('"+CALR.get(0).getG()+"','"+CALR.get(1).getG()+"','"+CALR.get(2).getG()+"','"+CALR.get(0).getG()+"|"+CALR.get(1).getG()+"','"+CALR.get(0).getG()+"|"+CALR.get(1).getG()+"|"+CALR.get(2).getG()+"','"+CALR.get(1).getG()+"|"+CALR.get(2).getG()+"')";
		 
		 
		 if(CALR.size()>=4) {
              String S[]= {"","","","","","","","",""};

              S[0]=CALR.get(0).getG();
              
              S[1]=CALR.get(0).getG()+"|"+CALR.get(1).getG();
              S[2]=CALR.get(0).getG()+"|"+CALR.get(1).getG()+"|"+CALR.get(2).getG();
              S[3]=CALR.get(1).getG()+"|"+CALR.get(2).getG();
              S[4]=CALR.get(0).getG()+"|"+CALR.get(2).getG()+"|"+CALR.get(3).getG();
              S[5]=CALR.get(1).getG()+"|"+CALR.get(2).getG()+"|"+CALR.get(3).getG();
              
              S[6]=CALR.get(1).getG();
              S[7]=CALR.get(2).getG();
			  S[8]=CALR.get(3).getG();
              
              
              
				 IN="('"+S[0]+"','"+S[1]+"','"+S[2]+"','"+S[3]+"','"+S[4]+"','"+S[5]+"','"+S[6]+"','"+S[7]+"','"+S[8]+"')";
				 
				 
			 }
         System.out.println("SELECT * FROM movies WHERE genres IN"+IN+"^^"+CALR.size());
		 result=state.executeQuery("SELECT * FROM movies WHERE genres IN"+IN);
         CALR.clear();
			 
			 
		 }
         
	 MV.clear();
	 
	   for(int i=0;result.next()&& i<8;i++) {
		  
	    MV.add(new Movie(AUDD(result.getString("title")),result.getString("genres"),result.getInt("movieId"),150,200,true,result.getInt("imdbid"))); 
	   }
	   P=new page(MV);
	   mainpane.getChildren().add(P);
		if(MV.size()<7)swip_left_button.setDisable(true);
		if(MV.size()>=8)swip_left_button.setDisable(false);

         		 
		 
		 
	 }
	 
	 
	 


	 
	 








//filtrer les films 
@FXML
void Filter_movie(ActionEvent event) throws Exception {
String Query[]= {"","","","","","","","",""},S="",S1="",S11="";
	if(Action_Combox.isSelected())Query[0]=Query[0]+"movies.genres like '%Action%'";
		if(Comedy_Combox.isSelected())Query[1]=Query[1]+"movies.genres like '%Comedy%'";
			if(Drama_Combox.isSelected())Query[2]=Query[2]+"movies.genres like '%Drama%'";
				if(Animation_Combox.isSelected())Query[3]=Query[3]+"movies.genres like '%Animation%'";
					if(Horror_Combox.isSelected())Query[4]=Query[4]+"movies.genres like '%Horror%'";
						   if(Fantasy_Combox.isSelected())Query[5]=Query[5]+"movies.genres like '%Fantasy%'";
								if(Children_Combox.isSelected())Query[6]=Query[6]+"movies.genres like '%Children%'";
							       if(Mystery_Combox.isSelected())Query[7]=Query[7]+"movies.genres like '%Mystery%'";



                                for(int i=0;i<8;i++) {
                                	
                                	if(Query[i].length()>0) {
                                	   
                                		S=S+Query[i]+" AND ";
                                		
                                	}
                                	
                                	
                                	
                                }
                                boolean T=false;
                                if(Views_Combox.isSelected() && Ratings_Combox.isSelected()) {
                                	
                                	
                                	result=state.executeQuery("SELECT * FROM movies where "+S.substring(0,S.length()-4));
                                    
                                	T=true;
                                	
                                }

                                
  
                                if(Views_Combox.isSelected()) {
                                	S11="tendance";
                                	S1="ORDER by "+S11+".nbvue DESC";
                                }
                                
                                
                                
                                if(Ratings_Combox.isSelected()) {
                                	S11="ratings";
                                	S1="ORDER by "+S11+".rating DESC";
                                }
                                
                                
             if(!T)
               result=state.executeQuery("SELECT movies.imdbid,movies.title,movies.genres,movies.movieId FROM movies,"+S11+" where movies.movieId="+S11+".movieId AND "+S.substring(0,S.length()-4)+""+S1);								    
								     
                                
                                
             if(MV.size()>0)MV.clear();
             
             for(int i=0;i<8&&result.next();i++) {
            	 
            	 
            	 MV.add(new Movie(AUDD(result.getString("title")),result.getString("genres"),result.getInt("movieId"),150,200,true,result.getInt("imdbid")));
            	 
            	 
            	 
             }
		    mainpane.getChildren().remove(P);
		    P=new page(MV);
		    mainpane.getChildren().add(P);
		
      
	        FilterPane.setVisible(false);
	        FiterPanelStatus=false;
	
	
	
	
	
}

//afficher le panneau de filtrage 
@FXML
void show_filter_pane(ActionEvent event) throws IOException {


  	
 
  	if(!FiterPanelStatus) {
      FilterPane.setVisible(true);
      FilterPane.toFront();
      FiterPanelStatus=true;

  	}else {
        FilterPane.setVisible(false);
        FiterPanelStatus=false;
  		
  	}
  	
}

@FXML
void GoHome(ActionEvent event) {
	
	
	try {
		show_movie(false);
		show_mainpage(true);
	
	} catch (SQLException e) {
	}
	

}





@FXML
void show_hidden_menu(ActionEvent event) {
	leftbanner.setVisible(true); 
	leftbanner.toFront();
	if(connect) {
	try {

	result3=state.executeQuery("SELECT movies.movieId,movies.title,movies.genres,movies.imdbId FROM movies,historique WHERE historique.userId='"+UserID+"' AND movies.movieId=historique.movieId ORDER BY historique.id DESC LIMIT 50");	
	
//	result3.beforeFirst();
	
	if(!History_LV.getItems().isEmpty())
		History_LV.getItems().clear();
		
		
		
		
	while(result3.next()){
		 
		 History_LV.getItems().add(new costumecell(result3.getString("title"),result3.getString("genres"),result3.getInt("movieId"),"C:\\Users\\mouha\\Desktop\\Film-icon.png"));
		
		 
	 
	 
	 }
	
	result3=state.executeQuery("SELECT movies.imdbid,movies.title,movies.genres,movies.movieId from wishlist ,movies where wishlist.movieId=movies.movieId and wishlist.userId='"+UserID+"'");	
 
	
	//result3.first();
	
    if(!WishList.getItems().isEmpty())	
    	WishList.getItems().clear();
	
	
	while(result3.next()){
		 
		 WishList.getItems().add(new costumecell(result3.getString("title"),result3.getString("genres"),result3.getInt("movieId"),"C:\\Users\\mouha\\Desktop\\favorites.png"));
		
		 
	 
	 
	 }
	 
	
	
	}catch(Exception e) {}

	}else {
		if(!History_LV.getItems().isEmpty()) {
			History_LV.getItems().clear();
		}
		
		if(!WishList.getItems().isEmpty()) {
			WishList.getItems().clear();
		}
		
		
	}
	
	TranslateTransition openNav=new TranslateTransition(Duration.seconds(2), leftbanner);
	
		openNav.setByX(300);
	
     openNav.play();
     
     ofirst=false;
}

@FXML
void hide_hidden_menu(ActionEvent event) {
	
	
	    
	   
	   
	   TranslateTransition CloseNav=new TranslateTransition(Duration.seconds(2), leftbanner);
       CloseNav.setByX(-300);
       CloseNav.play();
	
       
}







@FXML
void Items_clicked(MouseEvent e) throws SQLException {

    
		   leftbanner.toFront();
		   TranslateTransition CloseNav=new TranslateTransition(Duration.seconds(2), leftbanner);
	       CloseNav.setByX(-300);
	       CloseNav.play();
	     
	       
	       
	       
	       
	     this.id=History_LV.getSelectionModel().getSelectedItem().getID();
	    
	     System.out.println(this.id);
	  /*   
	     RS=state.executeQuery("select imdbid from movies where movieId='"+id+"'");
	 	 RS.next();
		 
	 	 
	 	 
	 	 
		 imdbid=RS.getInt("imdbid");
	     	 
		String  db=String.valueOf(imdbid);
	        
	       int cpt=7-db.length();
	        
	        for(int i=0;i<cpt;i++)db="0"+db;

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
          	   showmovie(WishList.getSelectionModel().getSelectedItem().getTitle(),WishList.getSelectionModel().getSelectedItem().getType(), "", E.getAttribute("plot"), WishList.getSelectionModel().getSelectedItem().getID(),WishList.getSelectionModel().getSelectedItem().getType(),E.getAttribute("poster"));
	     */
	
}


@FXML
void Items_clickedWL(MouseEvent event)throws SQLException {

	

	
	 leftbanner.toFront();
	   TranslateTransition CloseNav=new TranslateTransition(Duration.seconds(2), leftbanner);
       CloseNav.setByX(-300);
       CloseNav.play();
	 this.id=WishList.getSelectionModel().getSelectedItem().getID();
	 System.out.println(id);
	 RS=state.executeQuery("select imdbid from movies where movieId='"+id+"'");
 	 RS.next();
	 
 	 
 	 
 	 
	 imdbid=RS.getInt("imdbid");
     	 
	String  db=String.valueOf(imdbid);
        
       int cpt=7-db.length();
        
        for(int i=0;i<cpt;i++)db="0"+db;

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
           

        	
	 
	 
	 showmovie(WishList.getSelectionModel().getSelectedItem().getTitle(),WishList.getSelectionModel().getSelectedItem().getType(), "", E.getAttribute("plot"), WishList.getSelectionModel().getSelectedItem().getID(),WishList.getSelectionModel().getSelectedItem().getType(),E.getAttribute("poster"));

	
}	
	
	


}
