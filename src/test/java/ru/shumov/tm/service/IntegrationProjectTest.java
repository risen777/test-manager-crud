package ru.shumov.tm.service;


import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import ru.shumov.tm.category.SoapTests;
import ru.shumov.tm.category.UnitTests;
import ru.shumov.tm.entity.Project;
import ru.shumov.tm.repository.ProjectRepository;
import ru.shumov.tm.repository.TaskRepository;
import ru.shumov.tm.services.ProjectService;
import ru.shumov.tm.services.TaskService;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class IntegrationProjectTest {
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("tm");
    private final ProjectRepository projectRepository = new ProjectRepository(emf);
    private final ProjectService projectService = new ProjectService(projectRepository);

    final Project project = new Project();


    @Category(SoapTests.class)
    @Test
    public void projectCreate() {
        System.out.println("[PROJECT CREATE]");
        System.out.println("ENTER NAME:");
        //    Scanner scanner = new Scanner(System.in);
        final String name = "Project3";
        projectService.createProject(name);
        System.out.println("[OK]");
        Assert.assertTrue(!projectService.getListProject().isEmpty());
    }

    @Category(UnitTests.class)
    @Test
    public void testEmpty() {

        Assert.assertTrue(projectService.getListProject().isEmpty());
    }

    @Category(UnitTests.class)
    @Test
    public void testList() {

        Assert.assertTrue(projectService.getListProject().isEmpty());
        projectService.merge(new Project());
        projectService.merge(new Project());
        projectService.merge(new Project());
        Assert.assertFalse(projectService.getListProject().isEmpty());
    }

//
//    @Category(UnitTests.class)
//    @Test
//    public void testCreate() {
//
//        project.setName("DEMO TASK");
//        Assert.assertNull(projectService.getListProject(project.getId()));
//        ProjectService.merge(project);
//        Assert.assertFalse(projectService.getListProject().isEmpty());
//        Assert.assertNotNull(projectService.getProjectById(project.getId()));
//    }


}













