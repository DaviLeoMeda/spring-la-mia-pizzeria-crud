package org.java.app.db.pizza;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pizza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@Column(length = 128 , nullable = false)
	private String name;
	private String description;
	private String pic;
	private String price;
	
	public Pizza() { }
	public Pizza(String name, String description, String pic, String price) {
		setName(name);
		setDescription(description);
		setPic(pic);
		setPrice(price);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Pizza [id= " + id + ", "
					+ "name= " + name + ", "
					+ "description= " + description 
					+ ", pic= " + pic 
					+ ", price= " + price + "]";
	}
	
	
}
