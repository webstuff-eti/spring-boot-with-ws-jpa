package br.eti.webstuff.clientecrm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

		// TODO: Preparando para autenticação quando for implemementada
		//this.customerPortService.setHandlerResolver(headerHandlerResolver);
		
	
		//TODO: ESTAMOS SEM SEGURANÇA/ AUTORIZAÇÃO E AUTENTICAÇÃO
		CustomerPort port = customerPortService.getCustomerPortSoap11();
		
		customerDetailRequest.setId(id);
		customerDetailResponse = port.getCustomerDetail(customerDetailRequest);

		//TODO: Aplicar validações
		if (customerDetailResponse != null) {
			customerDTO = new CustomerDatailDTO();
			customerDTO = Converters.converterCustomerDatailResponseToCustomerDatailDTO(customerDetailResponse);
		}
		
		return customerDTO;
	}

}