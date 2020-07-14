package org.example.map1;

import javax.persistence.*;
import java.util.List;

@Entity
public class Worker {

    @Id
    private int id;
    private String name;

    @ManyToMany
    @JoinTable(name = "project_worker_map",
            joinColumns = @JoinColumn(name = "col_1"),
            inverseJoinColumns = @JoinColumn(name = "col_2"))
    private List<Project> projects;

    public Worker() {
    }

    public Worker(int id, String name, List<Project> projects) {
        this.id = id;
        this.name = name;
        this.projects = projects;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
