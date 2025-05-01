package com.exercie.exercies.dao;

import com.exercie.exercies.model.Category;

import java.util.Optional;

public interface CategoryDao {
    Optional<Category> findById(Long id);
}
