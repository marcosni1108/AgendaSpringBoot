package com.springproject.repository;

import com.springproject.model.ContatcUser;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<ContatcUser, Long> {
    ContatcUser findByUsername(String username);
}
