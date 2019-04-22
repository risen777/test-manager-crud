package ru.shumov.tm;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;
import ru.shumov.tm.entity.Task;
import ru.shumov.tm.repository.TaskRepository;
import ru.shumov.tm.services.TaskService;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
//    @Test
//    public void shouldAnswerWithTrue()
//    {
//        assertTrue( true );
//    }
    @Test
    public void testCreate() {

        final TaskRepository taskRepository = new TaskRepository();
        final TaskService taskService = new TaskService(taskRepository);


        final Task task = new Task();

        Assert.assertNull(taskService.getTaskById(null));
        taskService.merge(task);


    }


}
