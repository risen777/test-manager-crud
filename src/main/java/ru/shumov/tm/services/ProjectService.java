package ru.shumov.tm.services;


import ru.shumov.tm.api.IProjectRepository;
import ru.shumov.tm.api.IProjectService;
import ru.shumov.tm.entity.Project;

import java.util.List;

public class ProjectService implements IProjectService {


    private final IProjectRepository projectRepository;
    public ProjectService(final IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
    @Override
    public Project createProject(final String name) {
        if (name == null || name.isEmpty()) return null;
        return projectRepository.createProject(name);
    }
    @Override
    public Project merge(final Project project) {
        if (project == null) return null;
        return projectRepository.merge(project);
    }
    @Override
    public Project getProjectById(final String id) {
        if (id == null || id.isEmpty()) return null;
        return projectRepository.getProjectById(id);
    }
    @Override
    public void removeProjectById(final String id) {
        if (id == null || id.isEmpty()) return;
        projectRepository.removeProjectById(id);
    }
    @Override
    public List<Project> getListProject() {
        return projectRepository.getListProject();
    }
    @Override
    public void clear() {
        projectRepository.clear();
    }
}
