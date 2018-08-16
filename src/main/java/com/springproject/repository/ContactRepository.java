package com.springproject.repository;

import com.springproject.model.Contact;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ContactRepository extends PagingAndSortingRepository<Contact, Long> {
    List<Contact> findByNameIgnoreCaseContaining(String name);
}
