package br.eti.webstuff.clientecrm.security;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

import org.springframework.stereotype.Component;

@Component
public class HeaderHandlerResolver implements HandlerResolver{

	@Override
	public List<Handler> getHandlerChain(PortInfo portInfo) {
		
		List<Handler> handlerChain = new ArrayList<Handler>();
		
		HeaderHandler headerHandler = new HeaderHandler();
		handlerChain.add(headerHandler);
		
		return handlerChain;
	}

}
