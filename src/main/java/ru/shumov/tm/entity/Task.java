package ru.shumov.tm.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Random;
import java.util.UUID;

@Entity
public class Task {
    @Id
    private String id = UUID.randomUUID().toString();
    private String name;

  //  private String id;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                '}';
    }
}
