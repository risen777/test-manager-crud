package ru.shumov.tm.endpoint;

import ru.shumov.tm.entity.Task;


import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;



@WebService
public interface TaskEndpoint {

    @WebMethod
    Task createTask(@WebParam(name = "name") String name);

    @WebMethod
    Task getTaskById(@WebParam(name = "id") String id);

    @WebMethod
    Task merge(@WebParam(name = "task") Task task);

    @WebMethod
    void removeTaskById(@WebParam(name = "id") String id);

    @WebMethod
    List<Task> getListTask();

    @WebMethod
    void clear();
}
