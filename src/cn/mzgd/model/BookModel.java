package cn.mzgd.model;

import java.util.Date;

public class BookModel {
    private Integer id;
    private Integer num;
    private String  name;
    private String  catogary;
    private double  price;
    private Date    date;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCatogary() {
		return catogary;
	}
	public void setCatogary(String catogary) {
		this.catogary = catogary;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "BookModel [id=" + id + ", num=" + num + ", name=" + name + ", catogary=" + catogary + ", price=" + price
				+ ", date=" + date + "]";
	}
    
}
