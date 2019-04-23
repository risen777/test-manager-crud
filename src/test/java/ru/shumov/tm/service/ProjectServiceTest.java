package ru.shumov.tm.service;

import org.junit.Assert;
import org.junit.Test;
import ru.shumov.tm.entity.Project;
import ru.shumov.tm.repository.ProjectRepository;
import ru.shumov.tm.services.ProjectService;


public class ProjectServiceTest {

    @Test
    public void testEmpty() {
        final ProjectRepository taskRepository = new ProjectRepository();
        final ProjectService taskService = new ProjectService(taskRepository);
        Assert.assertTrue(taskService.getListProject().isEmpty());
    }

    @Test
    public void testList() {
        final ProjectRepository taskRepository = new ProjectRepository();
        final ProjectService taskService = new ProjectService(taskRepository);
        Assert.assertTrue(taskService.getListProject().isEmpty());
        taskService.merge(new Project());
        taskService.merge(new Project());
        taskService.merge(new Project());
        Assert.assertFalse(taskService.getListProject().isEmpty());
    }

    @Test
    public void testCreate() {
        final ProjectRepository taskRepository = new ProjectRepository();
        final ProjectService taskService = new ProjectService(taskRepository);
        final Project task = new Project();
        task.setName("DEMO TASK");
        Assert.assertNull(taskService.getProjectById(task.getId()));
        taskService.merge(task);
        Assert.assertFalse(taskService.getListProject().isEmpty());
        Assert.assertNotNull(taskService.getProjectById(task.getId()));
    }

    @Test
    public void testClear() {
        final ProjectRepository taskRepository = new ProjectRepository();
        final ProjectService taskService = new ProjectService(taskRepository);
        taskService.merge(new Project());
        taskService.merge(new Project());
        taskService.merge(new Project());
        Assert.assertFalse(taskService.getListProject().isEmpty());
        taskService.clear();
        Assert.assertTrue(taskService.getListProject().isEmpty());
    }
    
}
