package com.springproject.controller;

import com.springproject.error.ResourceNotFoundException;
import com.springproject.model.Contact;
import com.springproject.repository.ContactRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("contacts")
@Api(value = "Contact", description = "Contact API")
public class ContactController {

    private final ContactRepository dao;

    @Autowired
    public ContactController(ContactRepository dao) {
        this.dao = dao;
    }

    @ApiOperation(value = "Find all contacts")
    @GetMapping
    public ResponseEntity<?> listAll() {
        return new ResponseEntity(dao.findAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Find contact by id")
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getContactById(@PathVariable("id") Long id) {
        verifyIfContactExists(id);
        Contact contact = dao.findOne(id);
        return new ResponseEntity(contact, HttpStatus.OK);
    }

    @ApiOperation(value = "Find contact by name")
    @GetMapping(path = "/findByName/{name}")
    public ResponseEntity<?> findByName(@PathVariable("name") String name) {
        return new ResponseEntity(dao.findByNameIgnoreCaseContaining(name), HttpStatus.OK);
    }

    @ApiOperation(value = "Save contact")
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Contact contact) {
        return new ResponseEntity(dao.save(contact), HttpStatus.OK);
    }

    @ApiOperation(value = "Delete contact by id")
    @DeleteMapping(path = "/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        verifyIfContactExists(id);
        dao.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @ApiOperation(value = "Update contact")
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
