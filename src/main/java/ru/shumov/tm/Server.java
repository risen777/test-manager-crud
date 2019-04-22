package ru.shumov.tm;

import ru.shumov.tm.endpoint.ProjectEndpointBean;
import ru.shumov.tm.api.ProjectEndpoint;
import ru.shumov.tm.api.TaskEndpoint;
import ru.shumov.tm.endpoint.TaskEndpointBean;
import ru.shumov.tm.repository.ProjectRepository;
import ru.shumov.tm.repository.TaskRepository;
import ru.shumov.tm.services.ProjectService;
import ru.shumov.tm.services.TaskService;

import javax.xml.ws.Endpoint;

import static ru.shumov.tm.App.emf;


public class Server {

    private static final ProjectRepository projectRepository = new ProjectRepository(emf);

    private static final ProjectService projectService = new ProjectService(projectRepository);

    private static final TaskRepository taskRepository = new TaskRepository(emf);

    private static final TaskService taskService = new TaskService(taskRepository);

    private static final TaskEndpoint taskEndpoint = new TaskEndpointBean(taskService);

    private static final ProjectEndpoint projectEndpoint = new ProjectEndpointBean(projectService);

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/ProjectEndpointBean?wsdl", projectEndpoint);
        Endpoint.publish("http://localhost:8080/TaskEndpointBean?wsdl", taskEndpoint);
        System.out.println("SERVER STARTED AT PORT 8080...");
    }


}




//
//    public static void main(String[] args) {
//
//
//        Endpoint.publish("");
//        Endpoint.publish("");
//
//    }

