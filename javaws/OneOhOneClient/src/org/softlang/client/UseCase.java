package org.softlang.client;

import java.net.URL;

import javax.xml.namespace.QName;

import org.softlang.service.Portal;
import org.softlang.service.PortalService;


public class UseCase {

	public static final void main(String[] args) throws Exception {

		URL localWSDL = new URL("http://127.0.0.1:8080/OneOhOneCompanies/Portal?wsdl");
		QName qname = new QName("http://service.softlang.org/", "PortalService");
		
		Portal service = new PortalService(localWSDL, qname).getPortalPort();
		System.out.println(service.totalCompany("meganalysis"));
	}

}
