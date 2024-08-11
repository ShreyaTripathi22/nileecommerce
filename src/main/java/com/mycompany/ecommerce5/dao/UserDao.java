/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ecommerce5.dao;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mycompany.ecommerce5.entities.user;
import org.hibernate.HibernateException;

public class UserDao {

	private SessionFactory factory;

	public UserDao(SessionFactory factory) {
		this.factory=factory;
	}
	
	//getuser by email and password
	public user getUserByEmailAndPassword(String email,String password)
	{
            user user=null;
            try {
		
		   String query="from user where userEmail=:e and userPassword=:p";
		   Session session=this.factory.openSession();
		   Query q=session.createQuery(query);
		   q.setParameter("e",email);
		   q.setParameter("p",password);
		   user= (user)q.uniqueResult();
		   
		   session.close();
		   
		   
            } catch (HibernateException e) {
                    e.printStackTrace();
            }
	   return user;
	}
	
	 
}
