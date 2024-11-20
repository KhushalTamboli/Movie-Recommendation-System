package org.movie.recommend.service;
import org.movie.recommend.config.*;
import java.util.*;
import java.sql.*;

import org.movie.recommend.model.*;
import org.movie.recommend.repository.*;


public class User_regis_service {
	
	User_Regis_Repository user_rigis_repo=new User_Regis_Repository();
    Scanner xyz=new Scanner(System.in);
	
    
    
    
    
    
	public void User_Registration() {
		 System.out.println("Welcome to User Registration...");
		 
		 System.out.println("Enter your Name:-");
		 String User_name=xyz.next();
		 System.out.println("Enter the Password:-");
		 xyz.nextLine();
		 String User_password=xyz.next();
		 System.out.println("Enter Contact Number:-");
		 xyz.nextLine();
		 String User_contact_number=xyz.next();
		 System.out.println("Enter City name:-");
		 xyz.nextLine();
		 String User_city_name=xyz.next();
		 User_registration user_resig = new User_registration();  // model class where we set details of new user.
		 user_resig.setUser_name(User_name);
		 user_resig.setUser_password(User_password);
		 user_resig.setUser_contact_number(User_contact_number);
		 user_resig.setUser_city_name(User_city_name);
			boolean b=user_rigis_repo.isAddNewUser(user_resig);
			if(b) {  
				System.out.println(" Registration Successfully");
				System.out.println("==========================================================================");
			}
			
			else {
				System.err.println("Problem in  Registration");
				System.err.println("==========================================================================");
			}
	}
	
}
