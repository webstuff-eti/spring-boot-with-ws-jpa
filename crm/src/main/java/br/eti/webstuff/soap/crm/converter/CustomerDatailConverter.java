package br.eti.webstuff.soap.crm.converter;

import java.util.List;

import org.springframework.stereotype.Component;

import br.eti.webstuff.soap.crm.bean.CustomerBean;
import br.eti.webstuff.soap.crm.enumeration.StatusCustomer;
import br.eti.webstuff.soap.crm.generated.jaxb.customer.CustomerDetail;
import br.eti.webstuff.soap.crm.generated.jaxb.customer.GetAllCustomerDetailResponse;
import br.eti.webstuff.soap.crm.generated.jaxb.customer.GetCustomerDetailResponse;
import br.eti.webstuff.soap.crm.generated.jaxb.customer.Status;


@Component
public class CustomerDatailConverter {

	public static CustomerDetail converterCustomerBeanToCustomerDetail(CustomerBean customer) {

		CustomerDetail customerDetail = new CustomerDetail();

		customerDetail.setId(customer.getId());
		customerDetail.setName(customer.getName());
		customerDetail.setPhone(customer.getName());
		customerDetail.setEmail(customer.getEmail());

		return customerDetail;
	}
	
	
	
	public static GetCustomerDetailResponse   converterCustomerBeanToGetCustomerDetailResponse(CustomerBean customer) {
		
		GetCustomerDetailResponse response = new GetCustomerDetailResponse();
		
		response.setCustomerDetail(converterCustomerBeanToCustomerDetail(customer));
		
		return response;
	}
	
	
	
	public static GetAllCustomerDetailResponse converterListOfCustomerBeanToListOfCustomerDetailResponse(List<CustomerBean> customers) {
		
		GetAllCustomerDetailResponse responses = new GetAllCustomerDetailResponse();
		
		customers.stream().forEach(c -> responses.getCustomerDetail().add(converterCustomerBeanToCustomerDetail(c)));
		
		return responses;
	}
	
	
	public static Status converterStatusSOAPToStatusCustomer(StatusCustomer statusCustomer) {

		if(statusCustomer.name().equals(StatusCustomer.FAILURE)) {
			return Status.FAILURE;
		}
		
		return Status.SUCCESS;
	}

}
