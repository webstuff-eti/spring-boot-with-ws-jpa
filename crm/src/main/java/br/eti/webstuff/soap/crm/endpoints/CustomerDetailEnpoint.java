package br.eti.webstuff.soap.crm.endpoints;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import br.eti.webstuff.soap.crm.generated.jaxb.customer.CustomerDetail;
import br.eti.webstuff.soap.crm.generated.jaxb.customer.GetCustomerDetailRequest;
import br.eti.webstuff.soap.crm.generated.jaxb.customer.GetCustomerDetailResponse;

@Endpoint
public class CustomerDetailEnpoint {
	
	@PayloadRoot(namespace="http://www.webstuff.eti.br/soap/crm/generated/jaxb/customer", localPart="GetCustomerDetailRequest")
	@ResponsePayload
	public GetCustomerDetailResponse processaCustomerDetailRequest(@RequestPayload GetCustomerDetailRequest request) {
		
		GetCustomerDetailResponse response = new GetCustomerDetailResponse();
		
		CustomerDetail  customerDetail = new CustomerDetail();
		
		customerDetail.setId(1);
		customerDetail.setName("Tiago");
		customerDetail.setEmail("tiago@gmail.com");
		customerDetail.setPhone("11 97070-7070");
		
		response.setCustomerDetail(customerDetail);
		
		return response;
	}

}
