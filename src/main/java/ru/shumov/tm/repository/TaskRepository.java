package ru.shumov.tm.repository;


import ru.shumov.tm.api.ITaskRepository;
import ru.shumov.tm.entity.Project;
import ru.shumov.tm.entity.Task;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class TaskRepository extends AbstractRepository implements ITaskRepository {
    private final Map<String, Task> map = new LinkedHashMap<>();

//    public TaskRepository(EntityManagerFactory emf) {
//    }
    public TaskRepository(EntityManagerFactory emf) {
        super(emf);
    }

    public TaskRepository() {
        super();
    }



//    public TaskRepository(EntityManagerFactory emf) {
//    }

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
        final EntityManager em =emf.createEntityManager();
        return em.find(Task.class, id);
//        if (id == null || id.isEmpty()) return null;
//        return map.get(id);
    }
//    @Override
//    public Task getByOrderIndex(final Integer orderIndex) {
//        if (orderIndex == null) return null;
//        return getListTask().get(orderIndex);
//    }
    @Override
    public Task merge(final Task task) {
        if (task == null) return null;
        final EntityManager em =emf.createEntityManager();
        em.getTransaction().begin();
        final Task result =em.merge(task);
        em.getTransaction().commit();
        return task;
//        if (task == null ) return null;
//        map.put(task.getId(), task);
//        return task;
    }
    @Override
    public void removeTaskById(final String id) {
        if (id == null || id.isEmpty()) return;
        final  EntityManager em =emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Project.class,id));
        em.getTransaction().commit();
//        if (id == null || id.isEmpty()) return;
//        map.remove(id);
    }
    @Override
    public List<Task> getListTask() {

        final   EntityManager em =emf.createEntityManager();
        return  em.createQuery("SELECT e FROM Task e",Task.class).getResultList();


    }
    @Override
    public void clear() {

        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Task e").executeUpdate();
        em.getTransaction().commit();

//
//        map.clear();
    }
}