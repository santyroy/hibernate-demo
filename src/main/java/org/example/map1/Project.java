package org.example.map1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Project {
    @Id
    private int id;
    @Column(name = "project_name")
    private String name;

    // Project won't create a separate table for mapping, it will be handled by Worker
    @ManyToMany(mappedBy = "projects")
    private List<Worker> workers;

    public Project() {
    }

    public Project(int id, String name, List<Worker> workers) {
        this.id = id;
        this.name = name;
        this.workers = workers;
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

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }
}
