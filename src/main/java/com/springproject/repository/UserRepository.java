package com.springproject.repository;

import com.springproject.model.ContactUser;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<ContactUser, Long> {
    ContactUser findByUsername(String username);
}
