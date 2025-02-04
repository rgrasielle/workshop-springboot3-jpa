package com.educandoweb.course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.educandoweb.course.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant instant;  // usar a classe Instant ao invés de Date 
	
	private Integer orderStatus;  // integer somente aqui
	
	// Associação (muitos para um)
	@ManyToOne  // instrui o JPA a transformar em uma chave estrangeira
	@JoinColumn(name = "client_id")  // o nome que esse chave estrangeira vai ter no banco de dados
	private User client; // um pedido tem um cliente
	
	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> items = new HashSet<>();
	
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	private Payment payment;
	
	// Construtores
	public Order() {
	}

	public Order(Long id, Instant instant, OrderStatus orderStatus, User client) {
		super();
		this.id = id;
		this.instant = instant;
		setOrderStatus(orderStatus);
		this.client = client;
	}

	// Getters e setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getInstant() {
		return instant;
	}

	public void setInstant(Instant instant) {
		this.instant = instant;
	}
	
	public OrderStatus getOrderStatus() {  // recebe um inteiro e tem que guardar internamente um OrderStatus 
		return OrderStatus.valueOf(orderStatus);  // converter inteiro para OrderStatus
	}

	public void setOrderStatus(OrderStatus orderStatus) {  // recebe um OrderStatus e tem que guardar um num inteiro
		if (orderStatus != null) {
		this.orderStatus = orderStatus.getCode();
		}
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}
	
	public Set<OrderItem> getItems() {
		return items;
	}
	
	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	// HashCode e Equals (somente id)
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}

}
