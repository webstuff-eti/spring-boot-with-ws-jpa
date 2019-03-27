package br.eti.webstuff.clientecrm.build;

import br.eti.webstuff.clientecrm.dto.CustomerDatailDTO;
import br.eti.webstuff.generated.stubs.GetCustomerDetailResponse;

public class Converter {
	
	public static CustomerDatailDTO converterCustomerDatailResponseToCustomerDatailDTO(
			GetCustomerDetailResponse customerDetailResponse) {

		CustomerDatailDTO customerDTO = new CustomerDatailDTO();

		customerDTO.setId(customerDetailResponse.getCustomerDetail().getId());
		customerDTO.setName(customerDetailResponse.getCustomerDetail().getName());
		customerDTO.setPhone(customerDetailResponse.getCustomerDetail().getPhone());
		customerDTO.setEmail(customerDetailResponse.getCustomerDetail().getEmail());

		return customerDTO;
	}

}
