package com.example.project_one;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceTest {
    @Test
    void findsExistingContact() {
        ContactService contactService = new ContactService();
        String id = "Test";
        Contact contact = new Contact(id, "Test", "Test", "1234567890", "Test");
        contactService.addContact(contact);
        assertNotNull(contactService.lookupContact(id));
    }

    @Test
    void findsNonExistingContact() {
        ContactService contactService = new ContactService();
        assertNull(contactService.lookupContact("Test"));
    }

    @Test
    void addsValidContacts() {
        ContactService contactService = new ContactService();
        String id1 = "Test1";
        String id2 = "Test2";
        Contact contact1 = new Contact(id1, "Test", "Test", "1234567890", "Test");
        Contact contact2 = new Contact(id2, "Test", "Test", "1234567890", "Test");
        contactService.addContact(contact1);
        contactService.addContact(contact2);
        assertNotNull(contactService.lookupContact(id1));
        assertNotNull(contactService.lookupContact(id2));
    }

    @Test
    void addContactRequiresUniqueID() {
        ContactService contactService = new ContactService();
        String sameID = "Test";
        Contact contact1 = new Contact(sameID, "Test", "Test", "1234567890", "Test");
        Contact contact2 = new Contact(sameID, "Test", "Test", "1234567890", "Test");
        contactService.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> contactService.addContact(contact2));
    }

    @Test
    void deletesValidContact() {
        ContactService contactService = new ContactService();
        String id = "Test";
        Contact contact = new Contact(id, "Test", "Test", "1234567890", "Test");
        contactService.addContact(contact);
        contactService.deleteContact(id);
        assertNull(contactService.lookupContact(id));
    }

    @Test
    void deleteContactRequiresExistingID() {
        ContactService contactService = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> contactService.deleteContact("Test"));
    }

    @Test
    void updatesValidContact() {
        ContactService contactService = new ContactService();
        String id = "Test";
        String firstName = "Test";
        Contact contact = new Contact(id, firstName, "Test", "1234567890", "Test");
        contactService.addContact(contact);
        assertEquals(contactService.lookupContact(id).getFirstName(), firstName);

        String newFirstName = "New Test";
        contactService.updateContact(id, newFirstName, contact.getLastName(), contact.getPhone(), contact.getAddress());
        assertEquals(contactService.lookupContact(id).getFirstName(), newFirstName);
    }

    @Test
    void updateContactRequiresExistingID() {
        ContactService contactService = new ContactService();
        assertThrows(IllegalArgumentException.class, () ->
                contactService.updateContact("Test", "New Test", "New Test", "1234567890", "Test"));
    }
}