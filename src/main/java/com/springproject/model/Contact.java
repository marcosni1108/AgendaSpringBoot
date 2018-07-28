package com.springproject.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static java.util.Arrays.asList;

@Data
public class Contact {
    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
    private String city;
    private String state;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date birthday;
    public static List<Contact> list;

    static {
        contactRepository();
    }

    public Contact() {
    }

    public Contact(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    private static void contactRepository(){
        list = new ArrayList(asList(new Contact(1L,"Marcos"), new Contact(2L,"Maria")));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(id, contact.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
