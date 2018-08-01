package com.springproject.repository;

import com.springproject.model.Contact;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContactRepository extends CrudRepository<Contact, Long> {
    List<Contact> findByNameIgnoreCaseContaining(String name);
}
