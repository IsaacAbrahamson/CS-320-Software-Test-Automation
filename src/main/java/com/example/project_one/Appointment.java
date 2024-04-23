package com.example.project_one;

import java.util.Date;

/**
 * Manages an appointment in the app.
 */
public class Appointment {
    /**
     * A unique identifier for the appointment.
     */
    private final String appointmentId;
    /**
     * The future date for the appointment.
     */
    private Date appointmentDate;
    /**
     * Description of the appointment.
     */
    private String description;

    /**
     * Creates a new appointment.
     *
     * @param appointmentId   The unique id for the appointment.
     * @param appointmentDate The future date for the appointment.
     * @param description     A description of the appointment.
     */
    public Appointment(String appointmentId, Date appointmentDate, String description) {
        if (appointmentId == null || appointmentId.length() > 10) {
            throw new IllegalArgumentException("Appointment ID of 10 or less characters is required.");
        }
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Appointment date in the future is required.");
        }
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description of 50 or less characters is required.");
        }

        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    /**
     * Get the unique ID string for an appointment.
     */
    public String getAppointmentId() {
        return appointmentId;
    }

    /**
     * Get the date for an appointment.
     */
    public Date getAppointmentDate() {
        return appointmentDate;
    }

    /**
     * Updates the appointment date.
     */
    public void setAppointmentDate(Date appointmentDate) {
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Appointment date in the future is required.");
        }
        this.appointmentDate = appointmentDate;
    }

    /**
     * Get the description for an appointment.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Updates the description.
     */
    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description of 50 or less characters is required.");
        }
        this.description = description;
    }
}
