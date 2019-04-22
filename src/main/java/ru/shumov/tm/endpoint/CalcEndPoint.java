package ru.shumov.tm.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
@WebService
public interface CalcEndPoint {


   @WebMethod
     Double sum(
            @WebParam(name = "a") Double a,
            @WebParam(name = "b") Double b

    );

}
