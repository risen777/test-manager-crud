package ru.shumov.tm.repository;


import ru.shumov.tm.api.ITaskRepository;
import ru.shumov.tm.entity.Task;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class TaskRepository implements ITaskRepository {
    private final Map<String, Task> map = new LinkedHashMap<>();
    @Override
    public Task createTask(final String name) {
        final Task task = new Task();
        task.setName(name);
        merge(task);
        return task;
    }
    @Override
    public Task getTaskById(final String id) {
        if (id == null || id.isEmpty()) return null;
        return map.get(id);
    }
//    @Override
//    public Task getByOrderIndex(final Integer orderIndex) {
//        if (orderIndex == null) return null;
//        return getListTask().get(orderIndex);
//    }
    @Override
    public Task merge(final Task task) {
        if (task == null) return null;
        map.put(task.getId(), task);
        return task;
    }
    @Override
    public void removeTaskById(final String id) {
        if (id == null || id.isEmpty()) return;
        map.remove(id);
    }
    @Override
    public List<Task> getListTask() {
        return new ArrayList<>(map.values());
    }
    @Override
    public void clear() {
        map.clear();
    }
}