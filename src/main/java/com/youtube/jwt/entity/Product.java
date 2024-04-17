package com.youtube.jwt.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer productId;
	private String productName;
	private String productDescription;
	private Double productDiscountedPrice;
	private Double productActualPrice;
	
	@ManyToMany(fetch=FetchType.EAGER , cascade=CascadeType.ALL)
	@JoinTable(name="product_images",
		joinColumns ={
				@JoinColumn(name="product_id")
		},
		inverseJoinColumns= {
				@JoinColumn(name="image_id")
		}
	)
	private Set<ImageModel> productImages;
	/**
	 * @return the productImages
	 */
	public Set<ImageModel> getProductImages() {
		return productImages;
	}
	/**
	 * @param productImages the productImages to set
	 */
	public void setProductImages(Set<ImageModel> productImages) {
		this.productImages = productImages;
	}
	/**
	 * @return the productId
	 */
	public Integer getProductId() {
		return productId;
	}
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @return the productDescription
	 */
	public String getProductDescription() {
		return productDescription;
	}
	/**
	 * @param productDescription the productDescription to set
	 */
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	/**
	 * @return the productDiscountedPrice
	 */
	public Double getProductDiscountedPrice() {
		return productDiscountedPrice;
	}
	/**
	 * @param productDiscountedPrice the productDiscountedPrice to set
	 */
	public void setProductDiscountedPrice(Double productDiscountedPrice) {
		this.productDiscountedPrice = productDiscountedPrice;
	}
	/**
	 * @return the productActualPrice
	 */
	public Double getProductActualPrice() {
		return productActualPrice;
	}
	/**
	 * @param productActualPrice the productActualPrice to set
	 */
	public void setProductActualPrice(Double productActualPrice) {
		this.productActualPrice = productActualPrice;
	}
	
}
