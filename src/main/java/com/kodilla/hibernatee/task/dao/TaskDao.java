package com.kodilla.hibernatee.task.dao;

import com.kodilla.hibernatee.task.Task;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskDao extends CrudRepository<Task, Integer> {

    List<Task> findByDuration(int duration);
}