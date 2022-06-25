package ir.mapsa.shop.category;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class CategoryService implements ICategoryService {
    private final CategoryRepository repository;

    @Override
    public Category save(Category category) {
        return repository.save(category);
    }

    @Override
    public Category update(Category category) {
        repository.findById(category.getId()).orElseThrow();
        return repository.save(category);
    }

    @Override
    public void delete(Long id) {
        repository.findById(id).orElseThrow();
        repository.deleteById(id);
    }

    @Override
    public Category getById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public List<Category> getAll() {
        return (List<Category>) repository.findAll();
    }

    @Override
    public Page<Category> getAllPages(int page, int size) {

        Pageable firstPage = PageRequest.of(page, size);

        return repository.findAll(firstPage);
    }

}
