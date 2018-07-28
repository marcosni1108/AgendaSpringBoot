package com.springproject.Controller;

import com.springproject.error.CustomErrorType;
import com.springproject.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("contacts")
public class ContactController {

    @Autowired
    public ContactController() {
    }

    @GetMapping
    public ResponseEntity<?> listAll() {
        return new ResponseEntity(Contact.list, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getContactById(@PathVariable("id") Long id) {
        Contact contact = new Contact();
        contact.setId(id);

        int index = Contact.list.indexOf(contact);
        if (index == -1) {
            return new ResponseEntity(new CustomErrorType("Contact not fund"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(Contact.list.get(index), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Contact contact) {
        Contact.list.add(contact);
        return new ResponseEntity(contact, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody Contact contact) {
        Contact.list.remove(contact);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Contact contact) {
        Contact.list.remove(contact);
        Contact.list.add(contact);
        return new ResponseEntity(HttpStatus.OK);
    }
}
