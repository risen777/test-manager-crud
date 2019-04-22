package ru.shumov.tm.repository;


import ru.shumov.tm.api.IProjectRepository;
import ru.shumov.tm.entity.Project;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ProjectRepository  implements IProjectRepository {
    private final Map<String, Project> map = new LinkedHashMap<>();
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
        map.put(project.getId(), project);
        return project;
    }
    @Override
    public Project getProjectById(final String id) {
        if (id == null || id.isEmpty()) return null;
        return map.get(id);
    }
    @Override
    public void removeProjectById(final String id) {
        if (id == null || id.isEmpty()) return;
        map.remove(id);
    }
    @Override
    public List<Project> getListProject() {
        return new ArrayList<>(map.values());
    }
    @Override
    public void clear() { map.clear(); }
}








