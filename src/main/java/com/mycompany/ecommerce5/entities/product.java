package com.mycompany.ecommerce5.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Shreya
 */
@Entity
public class product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pId;
    @Column(length = 3000)
    private String pDesc;
    	private String pName;
    @Column(length =3000)
    private String pPhoto;
    private int pPrice;
    private int pQuantity;
    @ManyToOne
    private  category category;
   
    

    public product(int pId,String pName, String pDesc, String pPhoto, int pPrice, int pQuantity) {
        this.pId = pId;
        this.pName = pName;
        this.pDesc = pDesc;
        this.pPhoto = pPhoto;
        this.pPrice = pPrice;
        this.pQuantity = pQuantity;
    }

    public product(String pName,String pDesc, String pPhoto, int pPrice, int pQuantity) {
        this.pDesc = pDesc;
        this.pName = pName;
        this.pPhoto = pPhoto;
        this.pPrice = pPrice;
        this.pQuantity = pQuantity;
    }

    public product(int pId,String pName, String pDesc, String pPhoto, int pPrice, int pQuantity, category category) {
        this.pId = pId;
        this.pName = pName;
        this.pDesc = pDesc;
        this.pPhoto = pPhoto;
        this.pPrice = pPrice;
        this.pQuantity = pQuantity;
        this.category = category;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }
    
    

    public product() {
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getpDesc() {
        return pDesc;
    }

    public void setpDesc(String pDesc) {
        this.pDesc = pDesc;
    }

    public String getpPhoto() {
        return pPhoto;
    }

    public void setpPhoto(String pPhoto) {
        this.pPhoto = pPhoto;
    }

    public int getpPrice() {
        return pPrice;
    }

    public void setpPrice(int pPrice) {
        this.pPrice = pPrice;
    }

    public int getpQuantity() {
        return pQuantity;
    }

    public void setpQuantity(int pQuantity) {
        this.pQuantity = pQuantity;
    }

    public void setCategory(category category) {
        this.category = category;
    }
    

    @Override
    public String toString() {
        return "Product{" + "pId=" + pId + ", pDesc=" + pDesc + ", pPhoto=" + pPhoto + ", pPrice=" + pPrice + ", pQuantity=" + pQuantity + '}';
    }
    
    
    
    
}
