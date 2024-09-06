package com.excelr.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @Column(nullable = false,unique = true)
	    private String username;
	    
	    @Column(nullable = false)
	    private String password;
	    
	    @Column(nullable = false, unique = true)
	    private String email;
	    	    
	    @ManyToMany(fetch = FetchType.EAGER)
	    @JoinTable(
	        name = "user_roles",  // Name of the join table
	        joinColumns = @JoinColumn(name = "user_id"),   // Foreign key column for User
	        inverseJoinColumns = @JoinColumn(name = "role_id")  // Foreign key column for Role
	    )
	    private Set<com.excelr.model.Role> roles = new HashSet<>();
	    
	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "address_id", referencedColumnName = "id")
	    private Address address;
	    
	    //one user can have many orders
	    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	    private List<Order> orders;
//	    private Set<Order> orders = new HashSet<>();
}

