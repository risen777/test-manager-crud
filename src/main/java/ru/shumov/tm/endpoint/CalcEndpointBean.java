package ru.shumov.tm.endpoint;

import ru.shumov.tm.api.CalcEndPoint;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService(endpointInterface = "ru.shumov.tm.api.CalcEndPoint")
public class CalcEndpointBean implements CalcEndPoint {

    public static final String WSDL = "http://localhost:8080/CalcEndPointBean?wsdl";


    @WebMethod
    public Double sum(
            @WebParam(name = "a") Double a,
            @WebParam(name = "b") Double b

    ) {

        return a + b;
    }

    public static void main(String[] args) {
        Endpoint.publish(WSDL, new CalcEndpointBean());
    }
    }




