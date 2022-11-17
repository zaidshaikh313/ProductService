package com.algoDomain.repositories;

import com.algoDomain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CategoryRepo extends JpaRepository<Category,Long> {


    @Query(value = "select * from Category where cat_name=?",nativeQuery = true)
    Optional<Category> findByCat_Name(String name);
}
