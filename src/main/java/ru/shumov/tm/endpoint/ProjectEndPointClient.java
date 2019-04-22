package ru.shumov.tm.endpoint;

import ru.shumov.tm.api.ProjectEndpoint;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class ProjectEndPointClient {




    public final static String NS = "http://endpoint.tm.shumov.ru/";
    public final static String LP = "ProjectEndpointBeanService";


    public static ProjectEndpoint getInstance() throws MalformedURLException {
        final URL wsdl = new URL(ProjectEndpointBean.WSDL);
        final QName qname = new QName(NS, LP);
        final Service service =  Service.create(wsdl, qname);
        return service.getPort(ProjectEndpoint.class);

    }

    public static void main(String[] args) throws MalformedURLException {
        System.out.println(getInstance().getListProject());
       getInstance().createProject("Project3");
    }
}
