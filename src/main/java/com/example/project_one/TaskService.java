package com.example.project_one;

import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private final Map<String, Task> taskMap = new HashMap<>();

    /**
     * Finds a task in the task service.
     */
    public Task lookupTask(String taskId) {
        return taskMap.get(taskId);
    }

    /**
     * Adds a new unique task to the task service.
     */
    public void addTask(Task task) {
        String id = task.getTaskID();
        if (taskMap.get(id) != null) {
            throw new IllegalArgumentException("Task with that ID already exists!");
        }
        taskMap.put(id, task);
    }

    /**
     * Removes a task from the task service.
     */
    public void deleteTask(String taskID) {
        if (taskMap.get(taskID) == null) {
            throw new IllegalArgumentException("No task with that ID exists!");
        }
        taskMap.remove(taskID);
    }

    /**
     * Updates a task in the task service.
     */
    public void updateTask(String taskID, String name, String description) {
        if (taskMap.get(taskID) == null) {
            throw new IllegalArgumentException("No task with that ID exists!");
        }
        Task task = new Task(taskID, name, description);
        taskMap.replace(taskID, task);
    }
}
