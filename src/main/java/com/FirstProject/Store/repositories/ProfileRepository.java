package com.FirstProject.Store.repositories;

import com.FirstProject.Store.entities.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
}