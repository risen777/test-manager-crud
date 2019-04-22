package ru.shumov.tm.api;

import ru.shumov.tm.entity.Project;

import java.util.List;

public interface IProjectService {
    Project createProject(String name);

    Project merge(Project project);

    Project getProjectById(String id);

    void removeProjectById(String id);

    List<Project> getListProject();

    void clear();
}
