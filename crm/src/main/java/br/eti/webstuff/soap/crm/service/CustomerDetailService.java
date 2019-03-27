package br.eti.webstuff.soap.crm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.eti.webstuff.soap.crm.bean.CustomerBean;
import br.eti.webstuff.soap.crm.enumeration.StatusCustomer;
import br.eti.webstuff.soap.crm.repository.CustomerDetailRepository;

@Service
public class CustomerDetailService {
	
	
	@Autowired
	private CustomerDetailRepository  customerRepository;


	public CustomerBean findById(Integer id) {

		Optional<CustomerBean> customerOptional = customerRepository.findById(id);
		if(customerOptional.isPresent()) {
			return customerOptional.get();
		}
		return null;
	}

	public List<CustomerBean> findAll() {
		return customerRepository.findAll();
	}

	public StatusCustomer deleteById(Integer id) {
		
		try {
			customerRepository.deleteById(id);
			return StatusCustomer.SUCCESS;
		}catch(Exception ex) {
			return StatusCustomer.FAILURE;
		}
	}

	public StatusCustomer insertClient(CustomerBean customer) {
		try {
			customerRepository.save(customer);
			return StatusCustomer.SUCCESS;
		}catch(Exception ex) {
			return StatusCustomer.FAILURE;
		}
	}

}
