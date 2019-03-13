package br.eti.webstuff.soap.crm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.eti.webstuff.soap.crm.bean.CustomerBean;
import br.eti.webstuff.soap.crm.enumeration.StatusCustomer;

@Service
public class CustomerDetailService {
	
	
	private static List<CustomerBean> customersBeans = new ArrayList<>();
	
	//FIXME: Excluir código abaixo e implementar busca em banco de dados
	static {
		
		CustomerBean cristina = new CustomerBean(1, "Cristina", "99999", "ristina@gmail.com");
		customersBeans.add(cristina);
		
		CustomerBean nilva = new CustomerBean(2, "Nilva", "88888", "nilva@gmail.com");
		customersBeans.add(nilva);
		
		CustomerBean rogerio = new CustomerBean(3, "Rogério", "77777", "rogerio@gmail.com");
		customersBeans.add(rogerio);
		
		CustomerBean luiz = new CustomerBean(4, "Luiz", "66666", "luiz@gmail.com");
		customersBeans.add(luiz);
		
		CustomerBean aleixe = new CustomerBean(5, "Aleixe", "55555", "aleixe@gmail.com");
		customersBeans.add(aleixe);
	}
	
	
	public CustomerBean findById(int id) {
		
		Optional<CustomerBean> customerOptinal = customersBeans.stream().filter(c -> c.getId() == id).findAny();
		
		if(customerOptinal.isPresent()) {
			return customerOptinal.get();
		}
		return null;
	}
	
	public List<CustomerBean> findAll(){
		return customersBeans;
	}
	
	public StatusCustomer deleteById(int id) {
		
		Optional<CustomerBean> customerOptinal = customersBeans.stream().filter(c -> c.getId()  == id).findAny();
		
		if(customerOptinal.isPresent()) {
			
			customersBeans.remove(customerOptinal.get());
			
			return StatusCustomer.SUCCESS;
		}
		
		return StatusCustomer.FAILURE;
	}

}
