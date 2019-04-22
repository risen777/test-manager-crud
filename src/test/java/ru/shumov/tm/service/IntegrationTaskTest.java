package ru.shumov.tm.service;



import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import ru.shumov.tm.category.SoapTests;

import ru.shumov.tm.category.UnitTests;
import ru.shumov.tm.entity.Project;
import ru.shumov.tm.entity.Task;
import ru.shumov.tm.repository.ProjectRepository;
import ru.shumov.tm.repository.TaskRepository;
import ru.shumov.tm.services.ProjectService;
import ru.shumov.tm.services.TaskService;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.Scanner;




public class IntegrationTaskTest {
    public   static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("tm");

    private static final Scanner scanner = new Scanner(System.in);
    private final TaskRepository taskRepository = new TaskRepository(emf);
    private final ProjectRepository projectRepository = new ProjectRepository(emf);

    private final TaskService taskService = new TaskService(taskRepository);

    private  final ProjectService projectService = new ProjectService(projectRepository);






    @Category(SoapTests.class)
    @Test
    public void testList() {

       // Assert.assertTrue(taskService.getListTask().isEmpty());
        taskService.merge(new Task());
        taskService.merge(new Task());
        taskService.merge(new Task());
        Assert.assertFalse(taskService.getListTask().isEmpty());
    }

    @Category(UnitTests.class)
    @Test
    public void testEmpty() {

        Assert.assertTrue(taskService.getListTask().isEmpty());
    }



}




