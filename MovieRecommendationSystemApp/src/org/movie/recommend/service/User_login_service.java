package org.movie.recommend.service;

import java.util.*;

import org.movie.recommend.model.Movie;
import org.movie.recommend.model.User_registration;
import org.movie.recommend.repository.Movie_Repository;
import org.movie.recommend.repository.User_login_Repository;

import com.mysql.cj.protocol.SocksProxySocketFactory;

public class User_login_service {
          User_login_Repository user_login_repo=new User_login_Repository();
          Movie_service movie_service=new Movie_service();
          Movie_Repository movie_repo= new Movie_Repository();
	 int current_user_id;
	Scanner xyz=new Scanner(System.in);	
	public void user_Login() {
		boolean user_found_flag=false;
		System.out.println("Enter the user name");
		String temp_user_name=xyz.next();
		System.out.println("Enter the Password");
		String temp_user_password=xyz.next();
		
		List<User_registration>user_list=user_login_repo.getAllusers();
		if(user_list!=null)
		           {
			for (User_registration  user_regis : user_list) 
			               {     
				if(user_regis.getUser_name().equals(temp_user_name)&&user_regis.getUser_password().equals(temp_user_password))   //comparing the user name and password with input.
				{    current_user_id=user_regis.getUser_id();
				
					user_found_flag=true;  // if found  user then true the value.
				}

				           }

	               }
	
	          if(user_found_flag==true) 
	          {    
	        	  System.out.println("==============================================================");
	        	  System.out.println("User login Successfully");
	        	  
	        	  System.out.println("===============================================================");
		    	  System.out.println("\t\tLatest blockbuster movies");
		    	  System.out.println("________________________________________________________________");
		    	  
	        	  System.out.println("+------------+----------------+----------------+\r\n"
	        	  		+ "| movie_name | dateof_release | average_rating |\r\n"
	        	  		+ "+------------+----------------+----------------+\r\n"
	        	  		+ "| Aavesham   | 2024           |         4.3333 |\r\n"
	        	  		+ "| munja      | 2024           |         3.7500 |\r\n"
	        	  		+ "| yodha      | 2024           |         3.3333 |\r\n"
	        	  		+ "+------------+----------------+----------------+");
	        	  System.out.println("==============================================================");
	        	  int user_login_choice;
	        	  do {
	        		  
	        		  System.out.println("1:Watch[Latest Movie]");
	        		  System.out.println("2:Search movie");
	        		  System.out.println("3:Movie Suggested fo you");
	        		  System.out.println("4:Show the positive review about the movie");  		  
	        		  System.out.println("5:Show the negative review about the movie");
	        		  System.out.println("6:Show the neutral review about the movie");
	        		  System.out.println("7:Log out");
	        		  System.out.println("Enter your choice:-");
	        		  user_login_choice=xyz.nextInt();
	        		       switch(user_login_choice) {
	        		        
	        		       case 1:
//	        		    	   System.out.println("===========================================================================");
//	        		    	   System.out.println("\t\t\tLatest blockbuster movies");
//	        		    	   System.out.println("===========================================================================");  
//	        		    	   movie_repo.getAllmovies_lates_top_three_rating();
//	        		    	   System.out.println("===========================================================================");
	        		    	   movie_service.watch_movie(current_user_id);
//	        		    	   
	        		       break;
	        		       case 2:
	        		    	   movie_service.select_and_watch_movie(current_user_id);
	        		       break;
	        		       
	        		       case 3:
	        		    	   System.out.println("======================================================");
	        		    	   System.out.println("Movie Recommend base on Rating & Watch history");
	        		    	   System.out.println("======================================================");
	        		    	   movie_repo.getAllmovies_movie_recommend_for_user();
	        		    	   System.out.println("======================================================");
	        		    	   movie_service.recommend_watch_movie(current_user_id);
	        		    	   System.out.println("=======================================================");
	        		    	   
	        		       break;
	        		       
	        		       case 4:
	        		    	   System.out.println("=================================================================================================");
	        		    	   System.out.println("\t\t\tPositive review of movie[rating above 3");
	        		    	   System.out.println("=================================================================================================");
	        		    	   movie_repo.getAllmovies_above_three_rating();
	        		    	   System.out.println("=================================================================================================");
	        		    	   
	        		       break;
	        		    	   
	        		    	   
	        		       case 5:
	        		    	   System.out.println("=================================================================================================");
	        		    	   System.out.println("\t\t\tNegative review of movie[rating below 2");
	        		    	   System.out.println("=================================================================================================");	    	   
	        		    	   movie_repo.getAllmovies_below_three_rating();
	        		    	   System.out.println("=================================================================================================");	    	   
	        		    	   
	        		       break;
	        	
	        		       case 6:
	        		    	   System.out.println("=================================================================================================");
	        		    	   System.out.println("\t\t\tNeutral review of movie[rating is equal to 2");
	        		    	   System.out.println("=================================================================================================");	    	   	        		    	   
	        		    	   movie_repo.getAllmovies_which_has_three_rating();
	        		    	   System.out.println("=================================================================================================");	    	   
	        		    	   
	        		       break;
	        		    	   
	        		       default:
	   						System.err.println("Exit");
	   						System.err.println("==========================================================================");	   
	        		       
	        		       }
	     		  
	        	  }while(user_login_choice<=6);
	          }
	      	else {
				System.out.println("User not found");
			}

	
	}	
}