package ru.shumov.tm.endpoint;



import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class CalcEndPointClient {


    public final static String NS = "http://endpoint.tm.shumov.ru/";
    public final static String LP = "CalcEndpointBeanService";

    public static CalcEndPoint getInstance() throws MalformedURLException {
        final URL wsdl = new URL(CalcEndpointBean.WSDL);
        final QName qname = new QName(NS, LP);
        final Service service =  Service.create(wsdl, qname);
        return service.getPort(CalcEndPoint.class);

    }

    public static void main(String[] args) throws MalformedURLException {
        System.out.println(getInstance().sum(10D, 20D));
    }


}

























