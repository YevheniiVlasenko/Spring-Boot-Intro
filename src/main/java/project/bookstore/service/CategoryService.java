package project.bookstore.service;

import project.bookstore.dto.category.CategoryDto;
import project.bookstore.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    CategoryDto getById(Long id);

    CategoryDto save(CategoryDto categoryDto);
    CategoryDto update(Long id, CategoryDto categoryDto);

    void deleteById(Long id);
}
