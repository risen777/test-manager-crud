package ru.shumov.tm.repository;


import org.hibernate.criterion.ProjectionList;
import ru.shumov.tm.api.IProjectRepository;
import ru.shumov.tm.entity.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class ProjectRepository extends AbstractRepository implements IProjectRepository {
    private final Map<String, Project> map = new LinkedHashMap<>();

    public ProjectRepository(EntityManagerFactory emf) {
        super(emf);
    }

    public ProjectRepository() {
        super();
    }


    @Override
    public Project createProject(final String name) {
        final Project project = new Project();
        project.setName(name);
        merge(project);
        return project;
    }
    @Override
    public Project updateProject(final String id, String name) {
        final Project project = getProjectById(id);
        if (project == null) return null;
        project.setName(name);
        return merge(project);
    }
    @Override
    public Project merge(final Project project) {
        if (project == null) return null;
      final EntityManager em =emf.createEntityManager();
      em.getTransaction().begin();
      final Project result =em.merge(project);
      em.getTransaction().commit();
        return result;
    }
    @Override
    public Project getProjectById(final String id) {
        if (id == null || id.isEmpty()) return null;
        final  EntityManager em =emf.createEntityManager();
        return em.find(Project.class, id);
    }
    @Override
    public void removeProjectById(final String id) {
        if (id == null || id.isEmpty()) return;
       final  EntityManager em =emf.createEntityManager();
       em.getTransaction().begin();
       em.remove(em.find(Project.class,id));
       em.getTransaction().commit();



    }
    @Override
    public List<Project> getListProject() {
        final   EntityManager em =emf.createEntityManager();
        return  em.createQuery("SELECT e FROM Project e",Project.class).getResultList();
    }
    @Override
    public void clear() {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Project e").executeUpdate();
        em.getTransaction().commit();

    }}













