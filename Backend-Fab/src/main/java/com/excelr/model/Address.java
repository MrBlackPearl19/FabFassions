package com.excelr.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "addresses")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Address {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false)
	    private String street;

	    @Column(nullable = false)
	    private String city;

	    @Column(nullable = false)
	    private String state;

	    @Column(nullable = false)
	    private String postalCode;

	    @Column(nullable = false)
	    private String country;

	   // @OneToOne(mappedBy = "address")
	   // private User user;

	    @OneToOne(mappedBy = "shippingAddress")
	    private Order order;
}
