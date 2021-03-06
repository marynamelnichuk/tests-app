package com.mmelnychuk.bootapp.testsapp.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "test_bases")
public class TestBase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name="owner_id")
    private User owner;

    @Column(name = "created_date")
    @DateTimeFormat(pattern = "hh:mm:ss dd/MM/yyyy")
    protected LocalDateTime createdDate;

    @OneToMany(mappedBy="testBase", cascade=CascadeType.ALL)
    private List<TestBaseTask> testBaseTasks;

    @OneToMany(mappedBy="testBase", cascade=CascadeType.ALL)
    private Set<Test> tests;

    @OneToMany(mappedBy="testBaseTask", cascade=CascadeType.ALL)
    protected List<TestResultTask> testResultTasks;

    @PrePersist
    public void beforeSave() {
        createdDate = LocalDateTime.now();
    }

    public TestBase(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<TestBaseTask> getTestBaseTasks() {
        return testBaseTasks;
    }

    public void setTestBaseTasks(List<TestBaseTask> testBaseTasks) {
        this.testBaseTasks = testBaseTasks;
    }

    public Set<Test> getTests() {
        return tests;
    }

    public void setTests(Set<Test> tests) {
        this.tests = tests;
    }
}
