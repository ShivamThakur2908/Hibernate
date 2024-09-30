package com.operation;

import java.util.Scanner;

import org.hibernate.Session;

public class MainClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		User user = new User();
		HibernateUtility hU = new HibernateUtility();
		
		while(true)
		{
			System.out.println("\nSelect Your Operation: ");
			System.out.println("1. Add User Details.\n2. Fetch User Details.\n3. Update User Details.\n4. Delete User Details.\n5. Exit.");
			int choice = sc.nextInt();
			
			if(choice == 1)
			{
				System.out.println("\nEnter the User Details\n");
				System.out.println("Enter User Id:");
				int id = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter User Name:");
				String name = sc.nextLine();
				System.out.println("Enter User Address:");
				String address = sc.nextLine();
				System.out.println("Enter User Designation:");
				String designation = sc.nextLine();
				System.out.println();
				
				user.setId(id);
				user.setName(name);
				user.setAddress(address);
				user.setDesignation(designation);
				Session session = hU.getSession();
				session.beginTransaction();
				session.save(user);
				
				session.getTransaction().commit();
				session.close();
				
				
			}
			else if(choice == 2)
			{
				System.out.println("Enter the User ID to fetch the User Details:");
				int id = sc.nextInt();
				User user1 = new User();Session session = hU.getSession();
				session.beginTransaction();
				user1 = session.get(User.class, id);
				session.close();
				System.out.println("User details are:\n");
				System.out.println("Id : "+user1.getId()+"\nUser Name : "+user1.getName()+"\nUser Address : "+user1.getAddress()+"\nUser Designation : "+user1.getDesignation());
				
			}
			else if(choice == 3)
			{
				System.out.println("Update the User details based on User ID\n\nEnter the User Id: ");
				int id = sc.nextInt();
				Session session = hU.getSession();
				session.beginTransaction();
				user = session.get(User.class, id);
				System.out.println("What you want to update: \n1. User Name.\n2. User Address.\n3. User Designation.\n4. Update All Details");
				int updateChoice = sc.nextInt();
				sc.nextLine();
				if(updateChoice == 1 && user != null)
				{
					System.out.println("Enter User Name:");
					String name = sc.nextLine();
					user.setName(name);
					session.saveOrUpdate(user);
					session.getTransaction().commit();
				}
				else if(updateChoice == 2 && user != null)
				{
					System.out.println("Enter User Address:");
					String address = sc.nextLine();
					user.setAddress(address);
					session.saveOrUpdate(user);
					session.getTransaction().commit();
				}
				else if(updateChoice == 3 && user != null)
				{
					System.out.println("Enter User Designation:");
					String designation = sc.nextLine();
					user.setDesignation(designation);
					session.saveOrUpdate(user);
					session.getTransaction().commit();
				}
				else if(updateChoice == 4 && user != null)
				{
					System.out.println("Enter User Name:");
					String name = sc.nextLine();
					System.out.println("Enter User Address:");
					String address = sc.nextLine();
					System.out.println("Enter User Designation:");
					String designation = sc.nextLine();
					user.setName(name);
					user.setAddress(address);
					user.setDesignation(designation);
					session.saveOrUpdate(user);
					session.getTransaction().commit();
				}
				session.close();
			}
			else if(choice == 4)
			{
				System.out.println("Enter User Id to delete the User Details: ");
				int id = sc.nextInt();	
				Session session = hU.getSession();
				session.beginTransaction();
				user = session.get(User.class, id);
				if(user != null)
				{
					session.delete(user);
					System.out.println("User details deleted successfully.");
				}
				else
				{
					System.out.println("No User found with this user id:" +id);
				}
				session.getTransaction().commit();
				session.close();
				
			}
			else if(choice == 5)
			{
				System.exit(0);
			}
		}
		

	}

}

