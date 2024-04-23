package com.example.project_one;

/**
 * Manages a single contact individual.
 */
public class Contact {
    /**
     * A unique identifier for the contact.
     */
    private final String contactID;
    /**
     * Contact's first name.
     */
    private String firstName;
    /**
     * Contact's last name.
     */
    private String lastName;
    /**
     * Contact's phone number.
     */
    private String phone;
    /**
     * Contact's address.
     */
    private String address;

    /**
     * Creates a new contact.
     *
     * @param contactID The unique ID for the contact.
     * @param firstName The first name for the contact.
     * @param lastName  The last name for the contact.
     * @param phone     The phone number for the contact.
     * @param address   The address for the contact.
     */
    public Contact(String contactID, String firstName, String lastName, String phone, String address) {
        if (contactID == null || contactID.length() > 10) {
            throw new IllegalArgumentException("Contact ID of 10 or less characters is required.");
        }
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name of 10 or less characters is required.");
        }
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last Name of 10 or less characters is required.");
        }
        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException("Phone of 10 characters is required.");
        }
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Contact ID of 30 or less characters is required.");
        }

        this.contactID = contactID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    /**
     * Get the unique ID string for a contact.
     */
    public String getContactID() {
        return contactID;
    }

    /**
     * Get the first name for a contact.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Updates the first name for a contact.
     */
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name of 10 or less characters is required.");
        }
        this.firstName = firstName;
    }

    /**
     * Get the last name for a contact.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Updates the last name for a contact.
     */
    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last Name of 10 or less characters is required.");
        }
        this.lastName = lastName;
    }

    /**
     * Get the phone number for a contact.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Updates the phone number for a contact.
     */
    public void setPhone(String phone) {
        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException("Phone of 10 characters is required.");
        }
        this.phone = phone;
    }

    /**
     * Get the adress for a contact.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Updates the address for a contact.
     */
    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Contact ID of 30 or less characters is required.");
        }
        this.address = address;
    }
}
