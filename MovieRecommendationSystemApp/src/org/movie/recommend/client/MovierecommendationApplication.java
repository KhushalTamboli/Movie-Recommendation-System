package org.movie.recommend.client;

import java.sql.*;
import java.util.Scanner;

import org.movie.recommend.service.Adminservice;
import org.movie.recommend.service.User_login_service;
import org.movie.recommend.service.User_regis_service;


public class MovierecommendationApplication  {

	
	public static void main(String[] args)throws SQLException {
		
		Adminservice admservice= new Adminservice();
		User_regis_service  user_regis_service=new User_regis_service();
		User_login_service user_login_service=new User_login_service();
		
		Scanner xyz=new Scanner(System.in);	
		int Mainpanelchoice;
		
		
	do {
		System.out.println("===================================================================");
		System.out.println("\t\t\t WELCOME TO OUR PAGE");
		System.out.println("===================================================================");
		System.out.println("1:Admin Login");
		System.out.println("2:User Registration [New User]");
		System.out.println("3:User Login");
		System.out.println("Please Enter the choice:-");
		Mainpanelchoice=xyz.nextInt();
		System.out.println("===================================================================");
		
		switch(Mainpanelchoice) {
		
		case 1:
		
			admservice.Admin_Login();

		break;
		
		case 2:
			user_regis_service.User_Registration();
		break;
		
		
		case 3:
			user_login_service.user_Login();
		break;

		
		default:
			System.err.println("Wrong Choice");
			System.err.println("==========================================================================");
		}
		
	
	}while(Mainpanelchoice<=3);
	
		

	}

}
