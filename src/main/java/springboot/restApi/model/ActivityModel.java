package springboot.restApi.model;

import java.io.Serializable;
import java.time.LocalDate;

public class ActivityModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	String header;
	String name;
	String shortDescription;
	String procurementChannel;
	LocalDate creationDate;
	String author;
	Integer quantity;
	Float price;
	String status;
	
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getProcurementChannel() {
		return procurementChannel;
	}
	public void setProcurementChannel(String procurementChannel) {
		this.procurementChannel = procurementChannel;
	}
	public LocalDate getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
