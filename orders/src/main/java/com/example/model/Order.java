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
@Table(name="order1")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="cname")
	private String cname;

	@Column(name="totalprice")
	private float totalprice;
	
	@Column(name="status")
	private String status;
	
	@OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "pid", referencedColumnName = "id")
    private Product product;
	
	
}
