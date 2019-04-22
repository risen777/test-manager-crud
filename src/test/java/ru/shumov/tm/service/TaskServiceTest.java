package ru.shumov.tm.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import ru.shumov.tm.category.UnitTests;
import ru.shumov.tm.entity.Task;
import ru.shumov.tm.repository.TaskRepository;
import ru.shumov.tm.services.TaskService;


public class TaskServiceTest {
    @Category(UnitTests.class)
    @Test
    public void testEmpty() {
        final TaskRepository taskRepository = new TaskRepository();
        final TaskService taskService = new TaskService(taskRepository);
        Assert.assertTrue(taskService.getListTask().isEmpty());
    }

    @Category(UnitTests.class)
    @Test
    public void testList() {
        final TaskRepository taskRepository = new TaskRepository();
        final TaskService taskService = new TaskService(taskRepository);
        Assert.assertTrue(taskService.getListTask().isEmpty());
        taskService.merge(new Task());
        taskService.merge(new Task());
        taskService.merge(new Task());
        Assert.assertFalse(taskService.getListTask().isEmpty());
    }
    @Category(UnitTests.class)
    @Test
    public void testCreate() {
        final TaskRepository taskRepository = new TaskRepository();
        final TaskService taskService = new TaskService(taskRepository);
        final Task task = new Task();
        task.setName("DEMO TASK");
        Assert.assertNull(taskService.getTaskById(task.getId()));
        taskService.merge(task);
        Assert.assertFalse(taskService.getListTask().isEmpty());
        Assert.assertNotNull(taskService.getTaskById(task.getId()));
    }
    @Category(UnitTests.class)
    @Test
    public void testClear() {
        final TaskRepository taskRepository = new TaskRepository();
        final TaskService taskService = new TaskService(taskRepository);
        taskService.merge(new Task());
        taskService.merge(new Task());
        taskService.merge(new Task());
        Assert.assertFalse(taskService.getListTask().isEmpty());
        taskService.clear();
        Assert.assertTrue(taskService.getListTask().isEmpty());
    }

}
