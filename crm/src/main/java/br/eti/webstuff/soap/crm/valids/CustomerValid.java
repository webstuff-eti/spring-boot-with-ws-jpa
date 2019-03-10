package br.eti.webstuff.soap.crm.valids;

import br.eti.webstuff.soap.crm.enumeration.StatusCustomer;
import br.eti.webstuff.soap.crm.exceptions.CustomerNotFoundException;
import br.eti.webstuff.soap.crm.exceptions.custom.CustomerNotFoundCustomException;


public class CustomerValid extends RuntimeException {

	private static final long serialVersionUID = 1006431864062505901L;

	public static void validResponse(Object object, int id) {
		if(object == null) {
			throw new CustomerNotFoundException("Invalid Customer ID: " + id);
		}
	}
	
	public static void validCustomResponse(Object object, int id) {
		if(object == null) {
			throw new CustomerNotFoundCustomException("Invalid Customer ID: " + id);
		}
	}
	
	public static void validSuccess(Object object, int id) {
		if(object == StatusCustomer.FAILURE) {
			throw new CustomerNotFoundException("Invalid Customer ID: " + id);
		}
	}

}
