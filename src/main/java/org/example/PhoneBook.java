package org.example;


import java.util.*;

public class PhoneBook {
    private final Map<String, List<String>> contacts;

    public PhoneBook() {
        contacts = new HashMap<>();
    }

    public void add(String lastName, String phoneNumber) {
        List<String> phones = contacts.get(lastName);
        if (phones == null) {
            phones = new ArrayList<>();
            contacts.put(lastName, phones);
        }
        phones.add(phoneNumber);
    }

    public List<String> get(String lastName) {
        return contacts.getOrDefault(lastName, Collections.emptyList());
    }
}
