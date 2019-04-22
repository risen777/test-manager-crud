package ru.shumov.tm.api;


import ru.shumov.tm.entity.Project;
import ru.shumov.tm.entity.Task;

import java.util.List;

public interface ITaskRepository {

    Task createTask(String name);
    Task getTaskById(String id);
   // Task getByOrderIndex(Integer orderIndex);
    Task merge(Task task);
    void removeTaskById(String id);

    List<Task> getListTask();

    void clear();

}
