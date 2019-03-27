package br.eti.webstuff.soap.crm.exceptions.custom;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode=FaultCode.CUSTOM, customFaultCode="{http://www.webstuff.eti.br/soap/crm/generated/jaxb/customer}01_CustomerNotFound")
public class CustomerNotFoundCustomException extends RuntimeException {
	private static final long serialVersionUID = 3517365682776639502L;
	public CustomerNotFoundCustomException(String message) {
		super(message);
	}
}
