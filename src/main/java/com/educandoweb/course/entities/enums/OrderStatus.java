package com.educandoweb.course.entities.enums;

public enum OrderStatus {
	
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3), 
	DELIVERED(4),
	CANCELED(5);
	
	private int code;  // código do tipo enumerado
	
	// construtor do tipo enumerado (caso especial: private)
	private OrderStatus(int code) {
		this.code = code;
	}
	
	// método público para acessar o código anterior
	public int getCode() {
		return code;
	}
	
	// método estático para converter um valor numérico para um tipo enumerado
	public static OrderStatus valueOf(int code) { // passa um código e retorna um OrderStatus correspondente a esse código
		for (OrderStatus value : OrderStatus.values()) { // percorre todos os valores posíveis do OrderStatus
			if (value.getCode() == code) { // testa se o valor do OrderStatus é igual ao código passado como argumento
				return value;  // retorna o valor do código (ex.: PAID)
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");  // se não encontrar OrderStatus correspondente
	}
	
	
	

}
