package com.example.project_one;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages a group of appointments.
 */
public class AppointmentService {
    private final Map<String, Appointment> appointmentMap = new HashMap<>();

    /**
     * Finds an appointment in the appointment service.
     */
    public Appointment lookup(String appointmentId) {
        return appointmentMap.get(appointmentId);
    }

    /**
     * Adds a new unique appointment to the appointment service.
     */
    public void addAppointment(Appointment appointment) {
        String id = appointment.getAppointmentId();
        if (appointmentMap.get(id) != null) {
            throw new IllegalArgumentException("Appointment with that ID already exists!");
        }
        appointmentMap.put(id, appointment);
    }

    /**
     * Removes an appointment from the appointment service.
     */
    public void deleteAppointment(String appointmentId) {
        if (appointmentMap.get(appointmentId) == null) {
            throw new IllegalArgumentException("No appointment with that ID exists!");
        }
        appointmentMap.remove(appointmentId);
    }
}
