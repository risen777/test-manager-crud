package ru.shumov.tm.endpoint;

import ru.shumov.tm.entity.Task;
import ru.shumov.tm.services.TaskService;


import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;



@WebService(endpointInterface = "ru.shumov.tm.endpoint.TaskEndpoint")
public class TaskEndpointBean implements TaskEndpoint {

    private TaskService taskService;

    public TaskEndpointBean() {
    }

    public TaskEndpointBean(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    @WebMethod
    public Task createTask(@WebParam(name = "name") String name) {
        return taskService.createTask(name);
    }

    @Override
    @WebMethod
    public Task getTaskById(@WebParam(name = "id") String id) {
        return taskService.getTaskById(id);
    }

    @Override
    @WebMethod
    public Task merge(@WebParam(name = "task") Task task) {
        return taskService.merge(task);
    }

    @Override
    @WebMethod
    public void removeTaskById(@WebParam(name = "id") String id) {
        taskService.removeTaskById(id);
    }

    @Override
    @WebMethod
    public List<Task> getListTask() {
        return taskService.getListTask();
    }

    @Override
    @WebMethod
    public void clear() {
        taskService.clear();
    }
}
