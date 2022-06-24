package ir.mapsa.shop.category;

import java.util.List;

public interface ICategoryService <T> {

    Category save(Category category);
    Category update (Category category);
    void delete (Long id);
    Category getById(Long id);
    List<Category> getAll();
}
