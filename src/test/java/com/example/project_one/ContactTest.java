package com.example.project_one;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ContactTest {
    Contact contact = new Contact("TContact", "Test", "Contact", "1234567890", "Test Address");

    @Test
    void createsValidContact() {
        assertDoesNotThrow(() -> new Contact("TContact", "Test", "Contact", "1234567890", "Test Address"));
        assertDoesNotThrow(() -> contact.getContactID());
    }

    @Test
    void contactIDIsNotNull() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(
                null, "Test", "Contact", "1234567890", "Test Address"));
    }

    @Test
    void contactIDIsTenOrLess() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(
                "IHAVEMORETHANTENCHARACTERS", "Test", "Contact", "1234567890", "Test Address"));
    }

    @Test
    void mutateValidFirstName() {
        assertDoesNotThrow(() -> contact.getFirstName());
        assertDoesNotThrow(() -> contact.setFirstName("Test"));
    }

    @Test
    void firstNameIsNotNull() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(
                "TContact", null, "Contact", "1234567890", "Test Address"));
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
    }

    @Test
    void firstNameIsTenOrLess() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(
                "TContact", "IHAVEMORETHANTENCHARACTERS", "Contact", "1234567890", "Test Address"));
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("IHAVEMORETHANTENCHARACTERS"));
    }

    @Test
    void mutateValidLastName() {
        assertDoesNotThrow(() -> contact.getLastName());
        assertDoesNotThrow(() -> contact.setLastName("Test"));
    }

    @Test
    void lastNameIsNotNull() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(
                "TContact", null, "Contact", "1234567890", "Test Address"));
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null));
    }

    @Test
    void lastNameIsTenOrLess() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(
                "TContact", "Test", "IHAVEMORETHANTENCHARACTERS", "1234567890", "Test Address"));
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName("IHAVEMORETHANTENCHARACTERS"));
    }

    @Test
    void mutateValidPhone() {
        assertDoesNotThrow(() -> contact.getPhone());
        assertDoesNotThrow(() -> contact.setPhone("1234567890"));
    }

    @Test
    void phoneIsNotNull() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(
                "TContact", "Test", "Contact", null, "Test Address"));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone(null));
    }

    @Test
    void phoneIsExactlyTen() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(
                "TContact", "Test", "Contact", "123", "Test Address"));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("123"));
        assertThrows(IllegalArgumentException.class, () -> new Contact(
                "TContact", "Test", "Contact", "1234567890000", "Test Address"));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("1234567890000"));
    }

    @Test
    void mutateValidAddress() {
        assertDoesNotThrow(() -> contact.getAddress());
        assertDoesNotThrow(() -> contact.setAddress("Test"));
    }

    @Test
    void addressIsNotNull() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(
                "TContact", null, "Contact", "1234567890", "Test Address"));
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null));
    }

    @Test
    void addressIsThirtyOrLess() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(
                "TContact", "Test", "Contact", "1234567890", "IHAVEMORETHANTHIRTYCHARACTERSIHAVEMORETHANTHIRTYCHARACTERS"));
        assertThrows(IllegalArgumentException.class, () ->
                contact.setAddress("IHAVEMORETHANTHIRTYCHARACTERSIHAVEMORETHANTHIRTYCHARACTERS"));
    }
}