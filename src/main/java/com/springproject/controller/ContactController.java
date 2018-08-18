package com.springproject.controller;

import com.springproject.error.ResourceNotFoundException;
import com.springproject.model.Contact;
import com.springproject.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("contacts")
public class ContactController {

    private final ContactRepository dao;

    @Autowired
    public ContactController(ContactRepository dao) {
        this.dao = dao;
    }

    @GetMapping
    public ResponseEntity<?> listAll(Pageable pageable) {
        return new ResponseEntity(dao.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getContactById(@PathVariable("id") Long id) {
        verifyIfContactExists(id);
        Contact contact = dao.findOne(id);
        return new ResponseEntity(contact, HttpStatus.OK);
    }

    @GetMapping(path = "/findByName/{name}")
    public ResponseEntity<?> findByName(@PathVariable("name") String name) {
        return new ResponseEntity(dao.findByNameIgnoreCaseContaining(name), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Contact contact) {
        return new ResponseEntity(dao.save(contact), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        verifyIfContactExists(id);
        dao.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Contact contact) {
        verifyIfContactExists(contact.getId());
        dao.save(contact);
        return new ResponseEntity(HttpStatus.OK);
    }

    private void verifyIfContactExists(Long id) {
        if (dao.findOne(id) == null) {
            throw new ResourceNotFoundException("Contact not found by ID:" + id);
        }
    }
}
