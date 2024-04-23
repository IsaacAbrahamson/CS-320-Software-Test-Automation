package com.example.project_one;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentTest {
    // TODO: Update Appointment to support LocalDate instead of Date
    LocalDate futureLocalDate = LocalDate.now().plusDays(3);
    LocalDate pastLocalDate = LocalDate.now().minusDays(3);
    Date futureDate = Date.from(futureLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    Date pastDate = Date.from(pastLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    Appointment appointment = new Appointment("apt1", futureDate, "Test date");

    @Test
    void createsValidAppointment() {
        assertDoesNotThrow(() -> new Appointment("apt1", futureDate, "Test date"));
        assertDoesNotThrow(() -> appointment.getAppointmentId());
    }

    @Test
    void appointmentIDIsNotNull() {
        assertThrows(IllegalArgumentException.class, () -> new Appointment(
                null, futureDate, "Test date"));
    }

    @Test
    void appointmentIDIsTenOrLess() {
        assertThrows(IllegalArgumentException.class, () -> new Appointment(
                "IHAVEMORETHANTENCHARACTERS", futureDate, "Test date"));
    }

    @Test
    void mutateValidDate() {
        assertDoesNotThrow(() -> appointment.getAppointmentDate());
        assertDoesNotThrow(() -> appointment.setAppointmentDate(futureDate));
    }

    @Test
    void dateIsNotNull() {
        assertThrows(IllegalArgumentException.class, () -> new Appointment(
                "apt1", null, "test"));
        assertThrows(IllegalArgumentException.class, () -> appointment.setAppointmentDate(null));
    }

    @Test
    void dateIsInFuture() {
        assertThrows(IllegalArgumentException.class, () -> new Appointment(
                "apt1", pastDate, "test"));
        assertThrows(IllegalArgumentException.class, () -> appointment.setAppointmentDate(pastDate));
    }

    @Test
    void mutateValidDescription() {
        assertDoesNotThrow(() -> appointment.getDescription());
        assertDoesNotThrow(() -> appointment.setDescription("Test"));
    }

    @Test
    void descriptionIsNotNull() {
        assertThrows(IllegalArgumentException.class, () -> new Appointment(
                "apt1", futureDate, null));
        assertThrows(IllegalArgumentException.class, () -> appointment.setDescription(null));
    }

    @Test
    void descriptionIsFiftyOrLess() {
        assertThrows(IllegalArgumentException.class, () -> new Appointment(
                "apt1", futureDate,
                "IHAVEMORETHANTHIRTYCHARACTERSIHAVEMORETHANTHIRTYCHARACTERS"));
        assertThrows(IllegalArgumentException.class, () ->
                appointment.setDescription("IHAVEMORETHANTHIRTYCHARACTERSIHAVEMORETHANTHIRTYCHARACTERS"));
    }
}