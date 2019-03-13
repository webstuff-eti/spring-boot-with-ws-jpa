package br.eti.webstuff.clientecrm.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CustomerDatailDTO {

	private int id;
	private String name;
	private String phone;
	private String email;
}
