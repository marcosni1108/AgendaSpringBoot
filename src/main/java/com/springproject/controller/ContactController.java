package com.springproject.controller;

import com.springproject.error.CustomErrorType;
import com.springproject.model.Contact;
import com.springproject.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> listAll() {
        return new ResponseEntity(dao.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getContactById(@PathVariable("id") Long id) {
        Contact contact = dao.findOne(id);
        if (contact == null) {
            return new ResponseEntity(new CustomErrorType("Contact not fund"), HttpStatus.NOT_FOUND);
        }
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
    public ResponseEntity<?> delete(@PathVariable Long id) {
        dao.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Contact contact) {
        dao.save(contact);
        return new ResponseEntity(HttpStatus.OK);
    }
}
