package com.codeup.springblog.repositories;


import com.codeup.springblog.Controllers.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findCategoryById(long id);
}
