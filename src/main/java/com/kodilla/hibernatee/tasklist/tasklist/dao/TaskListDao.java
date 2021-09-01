package com.kodilla.hibernatee.tasklist.tasklist.dao;

import com.kodilla.hibernatee.tasklist.TaskList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TaskListDao extends CrudRepository<TaskList,Integer> {
    TaskList findByListName(String listName);
}
