package com.excelr.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "payments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false)
	    @Temporal(TemporalType.TIMESTAMP)
	    private Date paymentDate;

	    @Column(nullable = false)
	    private Double amount;

	    @Enumerated(EnumType.STRING)
	    @Column(nullable = false)
	    private PaymentMethod paymentMethod;

	    @Enumerated(EnumType.STRING)
	    @Column(nullable = false)
	    private PaymentStatus status;

	    @OneToOne
	    @JoinColumn(name = "order_id", nullable = false)
	    private Order order;
}
