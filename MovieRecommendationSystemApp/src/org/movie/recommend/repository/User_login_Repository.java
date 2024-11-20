package org.movie.recommend.repository;

import org.movie.recommend.config.DBHelper;
import org.movie.recommend.model.Movie;
import org.movie.recommend.model.User_registration;


import java.sql.*;
import java.util.*;


public class User_login_Repository extends DBHelper{
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
//this method return the all user info.
public List<User_registration> getAllusers(){
List<User_registration>user_list=new ArrayList<User_registration>();

try {
stmt=conn.prepareStatement("select *from userinfo");
rs=stmt.executeQuery();
while(rs.next()) {
User_registration user_regis=new User_registration();
user_regis.setUser_id(rs.getInt(1));
user_regis.setUser_name(rs.getString(2));
user_regis.setUser_password(rs.getString(3));
user_regis.setUser_contact_number(rs.getString(4));
user_regis.setUser_city_name(rs.getString(5));

user_list.add(user_regis);

}
return user_list.size()>0?user_list:null;
}
catch(Exception ex) {
System.out.println("Error is"+ex);
return null;
}

}


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

	     
	

}
