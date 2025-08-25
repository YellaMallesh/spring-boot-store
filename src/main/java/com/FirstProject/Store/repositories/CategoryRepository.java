package com.FirstProject.Store.repositories;

import com.FirstProject.Store.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Byte> {
}