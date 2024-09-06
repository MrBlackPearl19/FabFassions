package com.excelr.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
	
	    @Column(nullable = false)
	    @Temporal(TemporalType.TIMESTAMP)
	    private Date orderDate;

	    @Enumerated(EnumType.STRING)
	    @Column(nullable = false)
	    private OrderStatus status;

	    @Column(nullable = false)
	    private Double totalAmount;

	    @ManyToOne
	    @JoinColumn(name = "user_id", nullable = false)
	    private User user;
	
	    @OneToOne
	    @JoinColumn(name = "address_id", nullable = false)
	    private Address shippingAddress;
	     
        @ManyToMany
	    @JoinTable(
	        name = "order_product",
	        joinColumns = @JoinColumn(name = "order_id"),
	        inverseJoinColumns = @JoinColumn(name = "product_id")
	        )
        private Set<Product> products = new HashSet<>();
	 
	   

	  
}
