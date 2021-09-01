package com.kodilla.hibernatee.tasklist.dao;

import com.kodilla.hibernatee.tasklist.TaskList;
import com.kodilla.hibernatee.tasklist.tasklist.dao.TaskListDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskListDaoTestSuite {
    private static final String LIST_NAME = "Test list name";
    private static final String DESCRIPTION = "Start List Test";

    @Autowired
    private TaskListDao taskListDao;

    @Test
    void testFindByListName() {
        //Given
        TaskList taskList = new TaskList(LIST_NAME, DESCRIPTION);

        //When
        taskListDao.save(taskList);

        //Then
        String listName = taskList.getListName();
        TaskList taskListFromDb = taskListDao.findByListName(listName);
        assertEquals(DESCRIPTION, taskListFromDb.getDescription());

        //CleanUp
        taskListDao.deleteById(taskListFromDb.getId());
    }
}
