package com.FirstProject.Store.repositories;

import com.FirstProject.Store.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}