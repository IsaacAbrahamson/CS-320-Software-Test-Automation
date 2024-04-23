package com.example.project_one;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {
    @Test
    void findsExistingTask() {
        TaskService taskService = new TaskService();
        String id = "Test";
        Task task = new Task(id, "Test", "Test");
        taskService.addTask(task);
        assertNotNull(taskService.lookupTask(id));
    }

    @Test
    void findsNonExistingTask() {
        TaskService taskService = new TaskService();
        assertNull(taskService.lookupTask("Test"));
    }

    @Test
    void addsValidTasks() {
        TaskService taskService = new TaskService();
        String id1 = "Test1";
        String id2 = "Test2";
        Task task1 = new Task(id1, "Test", "Test");
        Task task2 = new Task(id2, "Test", "Test");
        taskService.addTask(task1);
        taskService.addTask(task2);
        assertNotNull(taskService.lookupTask(id1));
        assertNotNull(taskService.lookupTask(id2));
    }

    @Test
    void addTaskRequiresUniqueID() {
        TaskService taskService = new TaskService();
        String sameID = "Test";
        Task task1 = new Task(sameID, "Test", "Test");
        Task task2 = new Task(sameID, "Test", "Test");
        taskService.addTask(task1);
        assertThrows(IllegalArgumentException.class, () -> taskService.addTask(task2));
    }

    @Test
    void deletesValidTask() {
        TaskService taskService = new TaskService();
        String id = "Test";
        Task task = new Task(id, "Test", "Test");
        taskService.addTask(task);
        taskService.deleteTask(id);
        assertNull(taskService.lookupTask(id));
    }

    @Test
    void deleteTaskRequiresExistingID() {
        TaskService taskService = new TaskService();
        assertThrows(IllegalArgumentException.class, () -> taskService.deleteTask("Test"));
    }

    @Test
    void updatesValidTask() {
        TaskService taskService = new TaskService();
        String id = "Test";
        String name = "Test";
        Task task = new Task(id, name, "Test");
        taskService.addTask(task);
        assertEquals(taskService.lookupTask(id).getName(), name);

        String newName = "New Test";
        taskService.updateTask(id, newName, task.getDescription());
        assertEquals(taskService.lookupTask(id).getName(), newName);
    }

    @Test
    void updateTaskRequiresExistingID() {
        TaskService taskService = new TaskService();
        assertThrows(IllegalArgumentException.class, () ->
                taskService.updateTask("Test", "New Test", "New Test"));
    }
}