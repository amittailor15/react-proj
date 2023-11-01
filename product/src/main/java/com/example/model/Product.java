package com.example.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="pname")
	private String pname;

	@Column(name="pprice")
	private float pprice;
	
	@Column(name="pdescription")
	private String pdescription;
	
	@Column(name="pimage")
	private String pimage;
	
	//@OneToOne(mappedBy = "product")
	//private Order order;
	
	
	
	
}
