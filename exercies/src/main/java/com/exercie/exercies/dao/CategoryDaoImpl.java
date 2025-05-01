package com.exercie.exercies.dao;

import com.exercie.exercies.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.Optional;

public class CategoryDaoImpl implements CategoryDao{
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public CategoryDaoImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Optional<Category> findById(Long id) {

        return Optional.empty();

    }
}
