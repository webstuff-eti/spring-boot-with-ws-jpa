package br.eti.webstuff.clientecrm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.eti.webstuff.clientecrm.CustomerDatailService;
import br.eti.webstuff.clientecrm.dto.CustomerDatailDTO;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/api/cliente")
@CrossOrigin(origins = "*")
@NoArgsConstructor
public class CustomerDatailController {
	
	@Autowired
	private CustomerDatailService  customerDatailService;
	
	//TODO: Aplicar Lombok
	private static final Logger log = LoggerFactory.getLogger(CustomerDatailController.class);
	
	
	@GetMapping(value = "/id/{id}")
	public ResponseEntity<CustomerDatailDTO> searchCustomerById(@PathVariable("id") Integer id) {
	
		
		log.info("Iniciando busca do cliente pelo IDo: {} ");
		
		CustomerDatailDTO  customerDatailDTO = new CustomerDatailDTO();
		
		customerDatailDTO = customerDatailService.searchCustomerDatailById(id);
		
		return ResponseEntity.ok(customerDatailDTO);
    }

}
