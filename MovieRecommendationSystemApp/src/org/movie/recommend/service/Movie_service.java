package org.movie.recommend.service;

import java.util.*;

import org.movie.recommend.model.Admin;
import org.movie.recommend.model.Movie;
import org.movie.recommend.model.User_registration;
import org.movie.recommend.repository.Movie_Repository;
import org.movie.recommend.repository.User_Regis_Repository;
import org.movie.recommend.repository.User_login_Repository;

import java.sql.*;
public class Movie_service {
	Movie_Repository movie_repo=new Movie_Repository();
	 User_login_Repository user_login_repo=new User_login_Repository();
   Scanner xyz=new Scanner(System.in);
	
   int movie_id;
 
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
   public void new_movie_add() {
         boolean movieflag=false;
         System.out.println("================================================================");
   	System.out.println("Add movie in the Application");

   	
		System.out.println("Enter the Movie name:-");
		 String New_movie_name=xyz.next();
		 String lower_case_New_movie_nameString;
		 String lower_case_database_movie_name;
		 lower_case_New_movie_nameString=New_movie_name.toLowerCase();  //converting movie name to lower case
		
		 movie_id=1;
			List<Movie>movie_list=movie_repo.getAllmovies();
			if(movie_list!=null) {
				for (Movie movie : movie_list) {
					lower_case_database_movie_name=movie.getMovie_name().toLowerCase(); // converting movie name to lower case from database
					movie_id=movie_id+1;
					if(lower_case_New_movie_nameString.equals(lower_case_database_movie_name))   //comparing the movie name with the movie present in database .
					{
						
						movieflag=true;  // if found  movie then true the value.
					}

					}
			
				}
			System.out.println("Movie_id:-"+movie_id);
			if(movieflag==false) {
		
			
								System.out.println("Enter the Movie release date:-");
								 xyz.nextLine();
								String New_dateof_release=xyz.next();
								System.out.println("Enter the Movie budget:-");
								 xyz.nextLine();
								 String New_movie_budget=xyz.next();
								 
								 Movie movie = new Movie();  // model class where we set details of new movie.
								 movie.setMovie_name(New_movie_name);

								movie.setDateof_release(New_dateof_release);
								movie.setMovie_budget(New_movie_budget);
								
								
									boolean b=movie_repo.isAdd_New_Movie(movie);
									if(b) {  
										System.out.println(" Movie added Successfully");

										System.out.println("Select Movie category:-");

										    System.out.println("1:Horror");
											System.out.println("2:Action");
											System.out.println("3:Drama");
											System.out.println("4:Thriller");
											System.out.println("5:Science Fiction");
											System.out.println("6:Comedy");
											System.out.println("7:Romance");
											System.out.println("8:Crime");
											System.out.println("9:Documentry");
											System.out.println("10:Animation");
											System.out.println("11:Historical");
											System.out.println("12:Adventure");
											System.out.println("13:Fiction");
											System.out.println("14:Cartoon");
											System.out.println("15:War\n\n");
										
											System.out.println("How many categories you want to add?");  
											int get_count_categories=xyz.nextInt();
											
											for(int i=1;i<=get_count_categories;i++) {
												System.out.println("Enter the category_id");
												int get_category_id=xyz.nextInt();
												boolean m=movie_repo.isAdd_movie_category_join(movie_id,get_category_id);
												if(m) {
													System.out.println("category add Successfully");
												}
												else {
													System.err.println("problem in adding category");
												}
												
											}
										System.out.println("==========================================================================");
									}
									
									else {
										System.err.println("Problem in adding movie");
										System.err.println("==========================================================================");
									}

						   

			    }
			else {
				System.err.println("Movie allready present");
			}
			
	
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	
	
	     public void movie_update() {
	    		boolean updatemovieflag=false;
				System.out.println("Update Movie Details");
				
				System.out.println("Enter the Movie name:-");
				 String New_movie_name=xyz.next();
				 String lower_case_update_movie_nameString;
				 String lower_case_database_update_movie_name;
				 lower_case_update_movie_nameString=New_movie_name.toLowerCase();
					List<Movie>movie_list=movie_repo.getAllmovies();
					if(movie_list!=null) {
						for (Movie movie : movie_list) {
							lower_case_database_update_movie_name=movie.getMovie_name().toLowerCase();
							if(lower_case_update_movie_nameString.equals(lower_case_database_update_movie_name))   //comparing the movie name with the movie present in database .
							{    
								 System.out.println("Enter the Movie name:-");
							     String Update_movie_name=xyz.next();
								
								System.out.println("Enter the Movie release date:-");
								 xyz.nextLine();
								String Update_dateof_release=xyz.next();
								System.out.println("Enter the Movie budget:-");
								 xyz.nextLine();
								 String Update_movie_budget=xyz.next();
								 boolean b=movie_repo.isUpdate_Movie(Update_movie_name,Update_dateof_release,Update_movie_budget,New_movie_name);
								updatemovieflag=true;  // if found  movie then true the value.
							}

							}
					
						}
				if(updatemovieflag==true) {
					System.out.println(" Movie details updation Successfully");
				      }
				else {
					System.out.println("Problem with Movie updation");
				}
	
	     }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	
	 public void movie_delete() {
		 
		
			System.err.println("Movie Delete");
			boolean deletemovieflag=false;
			
			System.out.println("Enter the Movie name:-");
			 String delete_movie_name=xyz.next();
			 String lower_case_delete_movie_nameString;
			 String lower_case_database_delete_movie_name;
			 lower_case_delete_movie_nameString=delete_movie_name.toLowerCase();

				List<Movie>movie_list=movie_repo.getAllmovies();
				if(movie_list!=null) {
					for (Movie movie : movie_list) {
						lower_case_database_delete_movie_name=movie.getMovie_name().toLowerCase();
						if(lower_case_delete_movie_nameString.equals(lower_case_database_delete_movie_name))   //comparing the movie name with the movie present in database .
						{    
							
							 boolean b=movie_repo.isDelete_Movie(delete_movie_name);
							 deletemovieflag=true;  // if found  movie then true the value.
						}

						}
				
					}
			if(deletemovieflag==true) {
				System.out.println(" Movie Delete Successfully");
			      }
			else {
				System.err.println("Problem with Movie Deletion");
			}
	 
	 }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	 
	 
	 public void movie_dashboard() {
		 int movie_count=0;
		 int user_count=0;
		 System.out.println("Dashboard [Movie]");
		  List<Movie>movie_list=movie_repo.getAllmovies();
			
					if(movie_list!=null) 
				     	{
						for (Movie movie : movie_list) 
						         {
							      
							         movie_count++;
					             }
						
						} 
					
					List<User_registration>user_list=user_login_repo.getAllusers();
					if(user_list!=null)
					           {
						for (User_registration  user_regis : user_list) 
						               {     
							              user_count++;

							           }

				               }
					
					
					System.out.println("Total Users in database:- "+user_count+"\n");
					System.out.println("Total movies in database:- "+movie_count+"\n");
					System.out.println("Movies with Rating:-"+"\n");
					System.out.println("Movies without Rating:-"+"\n");
					System.out.println("Movies with Reviews:-"+"\n");
					System.out.println("Movies without Reviews:-"+"\n");
					System.out.println("Trending movies:-"+"\n");
				
	             }

	 
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	  public void view_All_movie_details() {
		  
		  List<Movie>movie_list=movie_repo.getAllmovies();
	
			if(movie_list!=null) 
		     	{
				for (Movie movie : movie_list) 
				         {
					       System.out.println(movie.getMovie_name()+"\t"+movie.getDateof_release()+"\t"+movie.getMovie_budget());

			             }

				} 
			System.out.println("\n");
 
	  }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	public void select_and_watch_movie(int current_user_id) {
		 boolean movieflag=false;
		System.out.println("Search movie");
		System.out.println("Enter the Movie name:-");
		 String Search_movie_name=xyz.next();
		 String lower_case_Search_movie_nameString;
		 String lower_case_database_Search_movie_name;
		 lower_case_Search_movie_nameString=Search_movie_name.toLowerCase();  //converting movie name to lower case
		
			List<Movie>movie_list=movie_repo.getAllmovies();
			if(movie_list!=null) {
				for (Movie movie : movie_list) {
					lower_case_database_Search_movie_name=movie.getMovie_name().toLowerCase(); // converting movie name to lower case from database
					
					if(lower_case_Search_movie_nameString.equals(lower_case_database_Search_movie_name))   //comparing the movie name with the movie present in database .
					{
						System.out.println("Movie  found\n");
						System.out.println("Movie name:-"+movie.getMovie_name());
						System.out.println("Movie Release date:-"+movie.getDateof_release());
						System.out.println("Movie budget:-"+movie.getMovie_budget()+"\n");
						 movie_id=movie.getMovie_id();
						
						movieflag=true;  // if found  movie then true the value.
					}

					}
			if(movieflag==true) {
				
				System.out.println("do you want to watch this movie ?");
				System.out.println("Yes\t\tor\t\tNo");
				String get_permission_movie=xyz.next();
				String get_lower_case_get_permission_movie=get_permission_movie.toLowerCase();
				if(get_lower_case_get_permission_movie.equals("Yes")||get_lower_case_get_permission_movie.equals("YES")||get_lower_case_get_permission_movie.equals("yes"))
				{
					System.out.println(movie_id);
					System.out.println(current_user_id);
					

					int rating;

					do {
						System.out.println("Give rating [out of 5]:-");
						 rating=xyz.nextInt();
					}while(rating==0||rating>5);
					System.out.println("rating:-"+rating);
					
					System.out.println("Give reviews:-");
					String reviews=xyz.next();
					
					
					boolean b=movie_repo.isAdd_User_Movie_join(movie_id,current_user_id);
					boolean bb=movie_repo.isAdd_rating(movie_id,current_user_id,rating,reviews);
					
					
				}
				else if(get_lower_case_get_permission_movie.equals("No")||get_lower_case_get_permission_movie.equals("no")||get_lower_case_get_permission_movie.equals("NO"))
				{
					System.out.println("Thanks for searching");
					
				}
				
			}else {
				System.err.println("Movie not found");
			}
				
			
		
			}
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public void watch_movie(int current_user_id) {
		boolean movieflag=false;
		System.out.println("Select the Movie name:-");
		 String Search_movie_name=xyz.next();
		 String lower_case_Search_movie_nameString;
		 String lower_case_database_Search_movie_name;
		 lower_case_Search_movie_nameString=Search_movie_name.toLowerCase();  //converting movie name to lower case
		
			List<Movie>movie_list=movie_repo.getAllmovies();
			if(movie_list!=null) {
				for (Movie movie : movie_list) {
					lower_case_database_Search_movie_name=movie.getMovie_name().toLowerCase(); // converting movie name to lower case from database
					
					if(lower_case_Search_movie_nameString.equals(lower_case_database_Search_movie_name))   //comparing the movie name with the movie present in database .
					{
						movie_id=movie.getMovie_id();

						movieflag=true;  // if found  movie then true the value.
					}

					}
			if(movieflag==true) {
				
				System.out.println("do you want to watch this movie ?");
				System.out.println("Yes\t\tor\t\tNo");
				String get_permission_movie=xyz.next();
				String get_lower_case_get_permission_movie=get_permission_movie.toLowerCase();
				if(get_lower_case_get_permission_movie.equals("Yes")||get_lower_case_get_permission_movie.equals("YES")||get_lower_case_get_permission_movie.equals("yes"))
				{
					System.out.println(movie_id);
					System.out.println(current_user_id);
					

					int rating;

					do {
						System.out.println("Give rating [out of 5]:-");
						 rating=xyz.nextInt();
					}while(rating==0||rating>5);
					System.out.println("rating:-"+rating);
					
					System.out.println("Give reviews:-");
					String reviews=xyz.next();
					System.out.println("===========================================================");
					
					
					boolean b=movie_repo.isAdd_User_Movie_join(movie_id,current_user_id);
					boolean bb=movie_repo.isAdd_rating(movie_id,current_user_id,rating,reviews);
					
					
				}
				else if(get_lower_case_get_permission_movie.equals("No")||get_lower_case_get_permission_movie.equals("no")||get_lower_case_get_permission_movie.equals("NO"))
				{
					System.out.println("Thanks for searching");
					
				}
				
			}else {
				System.err.println("Movie not found");
			}
				
			
		
			}
	}
//////////////////////////////////////////////////////////////////////////////////
	
	public void recommend_watch_movie(int current_user_id) {
		boolean movieflag=false;
		System.out.println("Select the Movie name:-");
		 String Search_movie_name=xyz.next();
		 String lower_case_Search_movie_nameString;
		 String lower_case_database_Search_movie_name;
		 lower_case_Search_movie_nameString=Search_movie_name.toLowerCase();  //converting movie name to lower case
		
			List<Movie>movie_list=movie_repo.getAllmovies();
			if(movie_list!=null) {
				for (Movie movie : movie_list) {
					lower_case_database_Search_movie_name=movie.getMovie_name().toLowerCase(); // converting movie name to lower case from database
					
					if(lower_case_Search_movie_nameString.equals(lower_case_database_Search_movie_name))   //comparing the movie name with the movie present in database .
					{
						movie_id=movie.getMovie_id();

						movieflag=true;  // if found  movie then true the value.
					}

					}
			if(movieflag==true) {
				
				System.out.println("do you want to watch this movie ?");
				System.out.println("Yes\t\tor\t\tNo");
				String get_permission_movie=xyz.next();
				String get_lower_case_get_permission_movie=get_permission_movie.toLowerCase();
				if(get_lower_case_get_permission_movie.equals("Yes")||get_lower_case_get_permission_movie.equals("YES")||get_lower_case_get_permission_movie.equals("yes"))
				{
					System.out.println(movie_id);
					System.out.println(current_user_id);
					

					int rating;

					do {
						System.out.println("Give rating [out of 5]:-");
						 rating=xyz.nextInt();
					}while(rating==0||rating>5);
					System.out.println("rating:-"+rating);
					
					System.out.println("Give reviews:-");
					String reviews=xyz.next();
					System.out.println("===========================================================");
					
					
					boolean b=movie_repo.isAdd_User_Movie_join(movie_id,current_user_id);
					boolean bb=movie_repo.isAdd_rating(movie_id,current_user_id,rating,reviews);
					System.out.println("Thanks for watching movie9");
					
					
				}
				else if(get_lower_case_get_permission_movie.equals("No")||get_lower_case_get_permission_movie.equals("no")||get_lower_case_get_permission_movie.equals("NO"))
				{
					System.out.println("Thanks for searching");
					
				}
				
			}else {
				System.err.println("Movie not found");
			}
				
			
		
			}
	}
}
