package ru.shumov.tm;

import ru.shumov.tm.api.ITaskRepository;
import ru.shumov.tm.entity.Project;
import ru.shumov.tm.entity.Task;
import ru.shumov.tm.repository.ProjectRepository;
import ru.shumov.tm.repository.TaskRepository;
import ru.shumov.tm.services.ProjectService;
import ru.shumov.tm.services.TaskService;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {

    public   static final  EntityManagerFactory emf = Persistence.createEntityManagerFactory("tm");

    private static final Scanner scanner = new Scanner(System.in);
    private final TaskRepository taskRepository = new TaskRepository(emf);
    private final ProjectRepository projectRepository = new ProjectRepository(emf);

    private final TaskService taskService = new TaskService(taskRepository);

    private  final ProjectService projectService = new ProjectService(projectRepository);

    public static void main(String[] args) {


        final App app = new App();
        System.out.println("*** WELCOME TO TASK MANAGER ****");

        String command;
        while (true) {
            //  Scanner scanner = new Scanner(System.in);
            command = scanner.nextLine();
            if ("exit".equals(command)) break;
            if ("help".equals(command)) app.help();
            if ("project-list".equals(command)) app.projectList();
            if ("project-clear".equals(command)) app.projectClear();
            if ("project-create".equals(command)) app.projectCreate();
            if ("task-list".equals(command)) app.taskList();
            if ("task-clear".equals(command)) app.taskClear();
            if ("task-create".equals(command)) app.taskCreate();
            System.out.println();
        }
    }


    public void help() {
        System.out.println("{SHOW ALL PROJECTS}");
        System.out.println("exit");
        System.out.println("project-list");
        System.out.println("project-clear");
        System.out.println("project-create");
        System.out.println("task-list");
        System.out.println("task-clear");
        System.out.println("task-create");


    }

    public void projectClear() {
        projectService.clear();
        System.out.println("[PROJECTS REMOVED]");
    }


    public void projectList() {
        System.out.println("{PROJECT LIST}");
        Integer index = 1;
        for (final Project project : projectService.getListProject()) {
            System.out.println(index + "." + project.getName());
        }

    }

    public void projectCreate() {
        System.out.println("[PROJECT CREATE]");
        System.out.println("ENTER NAME:");
        //    Scanner scanner = new Scanner(System.in);
        final String name = scanner.nextLine();
        projectService.createProject(name);
        System.out.println("[OK]");

    }


    public void taskList() {
        System.out.println("[TASK List]");
        Integer index = 1;
        for (final Task task : taskService.getListTask()) {

            System.out.println(index + "." + task.getName());
            index++;
        }


    }

    public void taskCreate() {
        System.out.println("[TASK CREATE]");
        System.out.println("[ENTER NAME]");
        //  Scanner scanner = new Scanner(System.in);
        final String name = scanner.nextLine();
        taskService.createTask(name);
        System.out.println("[OK]");


    }


    public void taskClear() {

        taskService.clear();
        System.out.println("[TASK REMOVED]");
    }


}
