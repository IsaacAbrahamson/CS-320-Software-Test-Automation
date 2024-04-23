package com.example.project_one;

import java.util.HashMap;
import java.util.Map;

/**
 * A manager for a group of contacts in memory without need for database service.
 */
public class ContactService {
    private final Map<String, Contact> contactMap = new HashMap<>();

    /**
     * Finds a contact in the contact service.
     */
    public Contact lookupContact(String contactID) {
        return contactMap.get(contactID);
    }

    /**
     * Adds a new unique contact to the contact service.
     */
    public void addContact(Contact contact) {
        String id = contact.getContactID();
        if (contactMap.get(id) != null) {
            throw new IllegalArgumentException("Contact with that ID already exists!");
        }
        contactMap.put(id, contact);
    }

    /**
     * Removes a contact from the contact service.
     */
    public void deleteContact(String contactID) {
        if (contactMap.get(contactID) == null) {
            throw new IllegalArgumentException("No contact with that ID exists!");
        }
        contactMap.remove(contactID);
    }

    /**
     * Updates a contact in the contact service.
     */
    public void updateContact(String contactID, String firstName, String lastName, String phone, String address) {
        if (contactMap.get(contactID) == null) {
            throw new IllegalArgumentException("No contact with that ID exists!");
        }
        Contact contact = new Contact(contactID, firstName, lastName, phone, address);
        contactMap.replace(contactID, contact);
    }
}
