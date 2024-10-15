package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageGetter {

	ImageView imageView;
	Image image;
    URL url;
    HttpURLConnection con;
 public ImageGetter(int tmbdid) throws IOException {
	  
	    url = new URL("http://api.themoviedb.org/3/movie/"+tmbdid+"/images?api_key=66c576deb3c98a9df791f33badd0619d");
	    con = (HttpURLConnection) url.openConnection();
	    
    
       con.setDoOutput(true);
       con.setRequestMethod("GET");
       con.setRequestProperty("backdrop_path", "application/json");
       BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
       String output;
       String[] s;
      // System.out.println("Output from Server .... \n");
       output = br.readLine();
       System.out.println(output);
       s=output.split(",");
       output =s[9].substring(13, s[9].length()-1);
       System.out.println(output);   
       image= new Image("https://image.tmdb.org/t/p/original"+output);
       imageView= new ImageView(image);
       imageView.setFitWidth(150);
       imageView.setFitHeight(150);
       
       
    }   
       
       
}
