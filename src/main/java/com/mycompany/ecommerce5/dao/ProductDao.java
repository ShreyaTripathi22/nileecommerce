
package com.mycompany.ecommerce5.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.mycompany.ecommerce5.entities.product;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ProductDao {
	
	public SessionFactory factory;

	public ProductDao(SessionFactory factory) {
		this.factory = factory;
	}
		
	
	
	public boolean saveProduct(product product)
	{
		boolean f=false;
		
		try {
			
			Session session= this.factory.openSession();
			Transaction tx=session.beginTransaction();
			
			session.save(product);
			f=true;
			
			
			tx.commit();
			session.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			f=false;
		}
		return f;
	}
        public List<product> getAllProducts()
	{
	 Session s=	this.factory.openSession();
	 Query query =s.createQuery("from product");
	 List<product> list=query.list();
	 return  list;

	}
        
        public List<product> getAllProductsById(int cid)
	{
	 Session s=	this.factory.openSession();
	 Query query =s.createQuery("from product as p where p.category.categoryid=:id");
	 query.setParameter("id", cid);
	 List<product> list=query.list();
	 return  list;

	}
	
	
}
	