package com.product.MobileApplication.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(
		name="mobile_store",
		uniqueConstraints = @UniqueConstraint(
				name = "modelname_unique",
				columnNames = "modelName"
		)
)
public class Mobile {
	@Id
	@SequenceGenerator(
			name="mobile_sequence",
			sequenceName = "mobile_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "mobile_sequence"
	)
	private int seriesno;
	@Column(
			nullable = false
	)
	private String modelname;
	@Column(
			nullable = false
	)
	private int storage;
	@Column(nullable = false)
	private int price;
	public Mobile(int seriesno, String modelname, int storage, int price) {
		super();
		this.seriesno = seriesno;
		this.modelname = modelname;
		this.storage = storage;
		this.price = price;
	}
	public int getSeriesno() {
		return seriesno;
	}
	public void setSeriesno(int seriesno) {
		this.seriesno = seriesno;
	}
	public String getModelname() {
		return modelname;
	}
	public void setModelname(String modelname) {
		this.modelname = modelname;
	}
	public int getStorage() {
		return storage;
	}
	public void setStorage(int storage) {
		this.storage = storage;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Mobile() {
		super();
	}
	
	
}
