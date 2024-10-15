package com.mycompany.mavenproject2;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class Conection {
	

		  private static String url = "jdbc:mysql://localhost:3306/films";
		  private static String user = "root";
		  private static String passwd = "";
		  private static Connection connect;
		   
		  //pour connecter a la base de donne�s 
		  public static Connection getInstance(){
		    if(connect == null){
		      try {
		        connect = (Connection) DriverManager.getConnection(url, user, passwd);
		      } catch (SQLException e) {
		        e.printStackTrace();
		      }
		    }      
		    return connect;
		  }   
		}

