package br.eti.webstuff.clientecrm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.eti.webstuff.clientecrm.build.Converter;
import br.eti.webstuff.clientecrm.dto.CustomerDatailDTO;
import br.eti.webstuff.clientecrm.security.HeaderHandlerResolver;
import br.eti.webstuff.generated.stubs.CustomerPort;
import br.eti.webstuff.generated.stubs.CustomerPortService;
import br.eti.webstuff.generated.stubs.GetCustomerDetailRequest;
import br.eti.webstuff.generated.stubs.GetCustomerDetailResponse;

@Service
public class CustomerDatailService {


	@Autowired
	private HeaderHandlerResolver headerHandlerResolver;


	public CustomerDatailDTO searchCustomerDatailById(Integer id) {
		
		GetCustomerDetailRequest customerDetailRequest = new GetCustomerDetailRequest();
		GetCustomerDetailResponse customerDetailResponse = new GetCustomerDetailResponse();
		
		CustomerPortService customerPortService = new CustomerPortService();
		
		CustomerDatailDTO customerDTO = null;

		customerPortService.setHandlerResolver(headerHandlerResolver);
		
		CustomerPort port = customerPortService.getCustomerPortSoap11();
		
		customerDetailRequest.setId(id);
		customerDetailResponse = port.getCustomerDetail(customerDetailRequest);

		//TODO: Aplicar validações
		
		
		if (customerDetailResponse != null) {
			customerDTO = new CustomerDatailDTO();
			customerDTO = Converter.converterCustomerDatailResponseToCustomerDatailDTO(customerDetailResponse);
		}
		
		return customerDTO;
	}

}

