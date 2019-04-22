package ru.shumov.tm.services;

import ru.shumov.tm.api.IProjectRepository;
import ru.shumov.tm.api.ITaskRepository;
import ru.shumov.tm.entity.Project;
import ru.shumov.tm.entity.Task;
import ru.shumov.tm.repository.TaskRepository;

import java.util.List;

public class TaskService implements ITaskRepository {

    private final ITaskRepository taskRepository;
    public TaskService(final ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(String name) {
        if (name == null || name.isEmpty()) return null;
        return taskRepository.createTask(name);
    }

    @Override
    public Task getTaskById(String id) {
        if (id == null || id.isEmpty()) return null;
        return taskRepository.getTaskById(id);
    }

//    @Override
//    public Task getByOrderIndex(Integer orderIndex) {
//        return null;
//    }

//    @Override
//    public Task getByOrderIndex(Integer orderIndex) {
//        if (orderIndex == null ) return null;
//        return taskRepository.getTaskById(orderIndex);
//    }

    @Override
    public Task merge(Task task) {
        if (task == null) return null;
        return taskRepository.merge(task);
    }

    @Override
    public void removeTaskById(String id) {
        if (id == null || id.isEmpty()) return;
        taskRepository.removeTaskById(id);
    }

    @Override
    public List<Task> getListTask() {
        return taskRepository.getListTask();
    }


    @Override
    public void clear() {
        taskRepository.clear();

    }
}
