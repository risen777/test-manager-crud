package ru.shumov.tm.api;

import ru.shumov.tm.entity.Project;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;
@WebService
public interface ProjectEndpoint {

    @WebMethod
    Project createProject(@WebParam(name = "name") String name);

    @WebMethod
    Project mergeProject(@WebParam(name = "project") Project project);

    @WebMethod
    Project getProjectById(@WebParam(name = "id") String id);

    @WebMethod
    void removeProjectById(@WebParam(name = "id") String id);

    @WebMethod
    List<Project> getListProject();

    @WebMethod
    void clear();

}
