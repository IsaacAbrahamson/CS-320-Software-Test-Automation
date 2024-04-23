package com.example.project_one;

/**
 * Manages a single task.
 */
public class Task {
    /**
     * A unique identifier for the task.
     */
    private final String taskID;
    private String name;
    private String description;

    /**
     * Creates a new task.
     *
     * @param taskID      The unique ID for the task.
     * @param name        The name of the task.
     * @param description The description for the task.
     */
    public Task(String taskID, String name, String description) {
        if (taskID == null || taskID.length() > 10) {
            throw new IllegalArgumentException("Task ID of 10 or less characters is required.");
        }
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Name of 20 or less characters is required.");
        }
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description of 50 or less characters is required.");
        }

        this.taskID = taskID;
        this.name = name;
        this.description = description;
    }

    /**
     * Get the unique ID string for a task.
     */
    public String getTaskID() {
        return taskID;
    }

    /**
     * Get the name for a task
     */
    public String getName() {
        return name;
    }

    /**
     * Updates the name for a task.
     */
    public void setName(String name) {
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("First name of 10 or less characters is required.");
        }
        this.name = name;
    }

    /**
     * Get the description for a task
     */
    public String getDescription() {
        return description;
    }

    /**
     * Updates the description for a task.
     */
    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description of 20 or less characters is required.");
        }
        this.description = description;
    }
}
