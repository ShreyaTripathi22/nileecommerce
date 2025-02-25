package com.mycompany.ecommerce5.entities;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryid;
    private String categoryTitle;
    private String categoryDescription;
    @OneToMany
     private List<product> products = new ArrayList<>();

    public category(int categoryid, String categoryTitle, String categoryDescription) {
        this.categoryid = categoryid;
        this.categoryTitle = categoryTitle;
        this.categoryDescription = categoryDescription;
    }

    public category(String categoryTitle, String categoryDescription) {
        this.categoryTitle = categoryTitle;
        this.categoryDescription = categoryDescription;
    }
    
    public category(String categoryTitle, String categoryDescription, List<product> products) {
        this.categoryTitle = categoryTitle;
        this.categoryDescription = categoryDescription;
        this.products = products;
    }
    
    
    public category() {
    }

    
    
    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
        
    }

    public List<product> getProducts() {
        return products;
    }

    public void setProducts(List<product> products) {
        this.products = products;
    }

     
    @Override
    public String toString() {
        return "Category{" + "categoryid=" + categoryid + ", categoryTitle=" + categoryTitle + ", categoryDescription=" + categoryDescription + '}';
    }
    
    
    
}
