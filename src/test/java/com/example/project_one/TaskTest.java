package com.example.project_one;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    Task task = new Task("TestTask", "Test Task", "This is a test task.");

    @Test
    void createsValidTask() {
        assertDoesNotThrow(() -> new Task("TestTask", "Test Task", "This is a test task."));
        assertDoesNotThrow(() -> task.getTaskID());
    }

    @Test
    void taskIDIsNotNull() {
        assertThrows(IllegalArgumentException.class, () -> new Task(null, "Test", "Test"));
    }

    @Test
    void taskIDIsTenOrLess() {
        assertThrows(IllegalArgumentException.class, () -> new Task(
                "IHAVEMORETHANTENCHARACTERS", "Test", "Test"));
    }

    @Test
    void mutateValidName() {
        assertDoesNotThrow(() -> task.getName());
        assertDoesNotThrow(() -> task.setName("Test"));
    }

    @Test
    void nameIsNotNull() {
        assertThrows(IllegalArgumentException.class, () -> new Task("Test", null, "Test"));
        assertThrows(IllegalArgumentException.class, () -> task.setName(null));
    }

    @Test
    void nameIsTwentyOrLess() {
        assertThrows(IllegalArgumentException.class, () -> new Task(
                "Test", "IHAVEMORETHANTWENTYCHARACTERS", "Test"));
        assertThrows(IllegalArgumentException.class, () -> task.setName("IHAVEMORETHANTWENTYCHARACTERS"));
    }

    @Test
    void mutateValidDescription() {
        assertDoesNotThrow(() -> task.getDescription());
        assertDoesNotThrow(() -> task.setDescription("Test"));
    }

    @Test
    void descriptionIsNotNull() {
        assertThrows(IllegalArgumentException.class, () -> new Task("Test", "Test", null));
        assertThrows(IllegalArgumentException.class, () -> task.setDescription(null));
    }

    @Test
    void descriptionIsFiftyOrLess() {
        assertThrows(IllegalArgumentException.class, () -> new Task(
                "Test", "Test", "IHAVEMORETHANFIFTYCHARACTERSIHAVEMORETHANFIFTYCHARACTERS"));
        assertThrows(IllegalArgumentException.class, () ->
                task.setName("IHAVEMORETHANFIFTYCHARACTERSIHAVEMORETHANFIFTYCHARACTERS"));
    }
}