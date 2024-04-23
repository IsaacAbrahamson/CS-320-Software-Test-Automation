package com.example.project_one;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentServiceTest {
    @Test
    void findsExistingAppointment() {
        AppointmentService aptService = new AppointmentService();
        String id = "Test";
        Appointment appointment = new Appointment(id, new Date(), "Test");
        aptService.addAppointment(appointment);
        assertNotNull(aptService.lookup(id));
    }

    @Test
    void findsNonExistingAppointment() {
        AppointmentService aptService = new AppointmentService();
        assertNull(aptService.lookup("Test"));
    }

    @Test
    void addsValidAppointments() {
        AppointmentService aptService = new AppointmentService();
        String id1 = "Test1";
        String id2 = "Test2";
        Appointment appointment1 = new Appointment(id1, new Date(), "Test");
        Appointment appointment2 = new Appointment(id2, new Date(), "Test");
        aptService.addAppointment(appointment1);
        aptService.addAppointment(appointment2);
        assertNotNull(aptService.lookup(id1));
        assertNotNull(aptService.lookup(id2));
    }

    @Test
    void addAppointmentRequiresUniqueID() {
        AppointmentService aptService = new AppointmentService();
        String sameID = "Test";
        Appointment appointment1 = new Appointment(sameID, new Date(), "Test");
        Appointment appointment2 = new Appointment(sameID, new Date(), "Test");
        aptService.addAppointment(appointment1);
        assertThrows(IllegalArgumentException.class, () -> aptService.addAppointment(appointment2));
    }

    @Test
    void deletesValidAppointment() {
        AppointmentService aptService = new AppointmentService();
        String id = "Test";
        Appointment appointment = new Appointment(id, new Date(), "Test");
        aptService.addAppointment(appointment);
        aptService.deleteAppointment(id);
        assertNull(aptService.lookup(id));
    }

    @Test
    void deleteContactRequiresExistingID() {
        AppointmentService aptService = new AppointmentService();
        assertThrows(IllegalArgumentException.class, () -> aptService.deleteAppointment("Test"));
    }
}