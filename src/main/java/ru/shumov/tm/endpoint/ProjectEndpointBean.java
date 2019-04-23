package ru.shumov.tm.endpoint;

import ru.shumov.tm.entity.Project;
import ru.shumov.tm.services.ProjectService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;
@WebService(endpointInterface = "ru.shumov.tm.endpoint.ProjectEndpoint")
public class ProjectEndpointBean implements ProjectEndpoint {

    private ProjectService projectService;

    public ProjectEndpointBean() {
    }

    public ProjectEndpointBean(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Override
    @WebMethod
    public Project createProject(@WebParam(name = "name") String name) {
        return projectService.createProject(name);
    }

    @Override
    @WebMethod
    public Project merge(@WebParam(name = "project") Project project) {
        return projectService.merge(project);
    }

    @Override
    @WebMethod
    public Project getProjectById(@WebParam(name = "id") String id) {
        return projectService.getProjectById(id);
    }

    @Override
    @WebMethod
    public void removeProjectById(@WebParam(name = "id") String id) {
        projectService.removeProjectById(id);
    }

    @Override
    @WebMethod
    public List<Project> getListProject() {
        return projectService.getListProject();
    }

    @Override
    @WebMethod
    public void clear() {
        projectService.clear();
    }


}
