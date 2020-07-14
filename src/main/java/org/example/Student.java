package org.example;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity // if entity has a name then the new name would be considered in HQL rather than default class name (Student)
// @Table(name = "mystudents") // this name will only be used as table name in the Database
@Cacheable // to enable second level cache for this entity
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Student {

    @Id
    private int id;
    private String name;
    private String city;

    private Certificate certificate;

    public Student() {
    }

    public Student(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", certificate=" + certificate +
                '}';
    }
}
