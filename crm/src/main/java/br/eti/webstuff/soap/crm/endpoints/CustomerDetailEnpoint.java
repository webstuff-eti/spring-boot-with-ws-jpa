package br.eti.webstuff.soap.crm.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import br.eti.webstuff.soap.crm.bean.CustomerBean;
import br.eti.webstuff.soap.crm.converter.CustomerDatailConverter;
import br.eti.webstuff.soap.crm.enumeration.StatusCustomer;
import br.eti.webstuff.soap.crm.generated.jaxb.customer.DeleteCustomerRequest;
import br.eti.webstuff.soap.crm.generated.jaxb.customer.DeleteCustomerResponse;
import br.eti.webstuff.soap.crm.generated.jaxb.customer.GetAllCustomerDetailRequest;
import br.eti.webstuff.soap.crm.generated.jaxb.customer.GetAllCustomerDetailResponse;
import br.eti.webstuff.soap.crm.generated.jaxb.customer.GetCustomerDetailRequest;
import br.eti.webstuff.soap.crm.generated.jaxb.customer.GetCustomerDetailResponse;
import br.eti.webstuff.soap.crm.generated.jaxb.customer.InsertCustomerDetailRequest;
import br.eti.webstuff.soap.crm.generated.jaxb.customer.InsertCustomerDetailResponse;
import br.eti.webstuff.soap.crm.service.CustomerDetailService;
import br.eti.webstuff.soap.crm.valids.CustomerValid;

@Endpoint
public class CustomerDetailEnpoint {
	
	@Autowired
	private CustomerDetailService service;
	
	@Autowired
	private CustomerDatailConverter converter;
	
	
	@PayloadRoot(namespace="http://www.webstuff.eti.br/soap/crm/generated/jaxb/customer", localPart="GetCustomerDetailRequest")
	@ResponsePayload
	public GetCustomerDetailResponse processaCustomerDetailRequest(@RequestPayload GetCustomerDetailRequest request) throws Exception {
		
		CustomerBean customer = service.findById(request.getId());
		
		CustomerValid.validResponse(customer, request.getId());
		
		return converter.converterCustomerBeanToGetCustomerDetailResponse(customer);
	}
	
	
	@PayloadRoot(namespace="http://www.webstuff.eti.br/soap/crm/generated/jaxb/customer", localPart="GetAllCustomerDetailRequest")
	@ResponsePayload
	public GetAllCustomerDetailResponse processaGetAllCustomerDetailRequest(@RequestPayload GetAllCustomerDetailRequest request) {
		
		List<CustomerBean> customerBeans = service.findAll();
		
		return converter.converterListOfCustomerBeanToListOfCustomerDetailResponse(customerBeans);
	}
	
	
	@PayloadRoot(namespace="http://www.webstuff.eti.br/soap/crm/generated/jaxb/customer", localPart="DeleteCustomerRequest")
	@ResponsePayload
	public DeleteCustomerResponse processaDeleteCustomerRequest(@RequestPayload DeleteCustomerRequest request) throws Exception  {
		
		DeleteCustomerResponse response = new DeleteCustomerResponse();
		
		StatusCustomer statusCustomer = service.deleteById(request.getId());
		
		CustomerValid.validSuccess(statusCustomer, request.getId());
		
		response.setStatus(converter.converterStatusSOAPToStatusCustomer(statusCustomer));

		return response;
	}
	
	
	@PayloadRoot(namespace="http://www.webstuff.eti.br/soap/crm/generated/jaxb/customer", localPart="InsertCustomerDetailRequest")
	@ResponsePayload
	public InsertCustomerDetailResponse processaInsertCustomerDetailRequest(@RequestPayload InsertCustomerDetailRequest request) {
		
		CustomerBean customerBean = converter.converterInsertCustomerDetailRequestToInsertCustomerDetailResponse(request);
		
		//CustomerValid.validIfNameAndEmailOfCustomerIsNull(customerBean);
		
		InsertCustomerDetailResponse response = new InsertCustomerDetailResponse();
		
		response.setStatus(converter.converterStatusSOAPToStatusCustomer(service.insertClient(customerBean)));
		
		return response;
	}
	
	
	

}
