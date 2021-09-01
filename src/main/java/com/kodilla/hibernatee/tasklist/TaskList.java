package com.kodilla.hibernatee.tasklist;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "TASKSlIST")
public final class TaskList {
    private int id;
    private String listName;
    private String description;

    public TaskList() {
    }

    public TaskList(String listName, String description) {
        this.description = description;
        this.listName = listName;
    }

    public TaskList(int id, String listName, String description) {
        this.id = id;
        this.description = description;
        this.listName = listName;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name ="ID", unique = true)
    public int getId() {
        return id;
    }

    @Column(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NotNull
    @Column(name = "NameLIst")
    public String getListName() {
        return listName;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    private  void setListName(String listName) {
        this.listName = listName;
    }
}
