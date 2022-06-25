package ir.mapsa.shop.category;

import org.springframework.data.domain.Page;

import java.util.List;

public interface ICategoryService <T> {

    Category save(Category category);
    Category update (Category category);
    void delete (Long id);
    Category getById(Long id);
    List<Category> getAll();
    Page<Category> getAllPages (int page, int size);
}
