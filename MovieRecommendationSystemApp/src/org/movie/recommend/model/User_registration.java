package org.movie.recommend.model;

public class User_registration {
	
	private String User_name;
	private String User_password;
	private String User_contact_number;
	private String User_city_name;
	private int User_id;
	
	public int getUser_id() {
		return User_id;
	}

	public void setUser_id(int user_id) {
		User_id = user_id;
	}

	public User_registration() {
		
	}
	
     public User_registration(String User_name,String User_password ,String User_contact_number ,String User_city_name,int User_id ) {
		this.User_name=User_name;
		this.User_password=User_password;
		this.User_contact_number=User_contact_number;
		this.User_city_name=User_city_name;
		this.User_id=User_id;
		
	}
	
	
	
	
	public String getUser_name() {
		return User_name;
	}
	public void setUser_name(String user_name) {
		User_name = user_name;
	}
	public String getUser_password() {
		return User_password;
	}
	public void setUser_password(String user_password) {
		User_password = user_password;
	}
	public String getUser_contact_number() {
		return User_contact_number;
	}
	public void setUser_contact_number(String user_contact_number) {
		User_contact_number = user_contact_number;
	}
	public String getUser_city_name() {
		return User_city_name;
	}
	public void setUser_city_name(String user_city_name) {
		User_city_name = user_city_name;
	}


}
