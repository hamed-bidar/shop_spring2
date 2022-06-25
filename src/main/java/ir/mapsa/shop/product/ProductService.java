package ir.mapsa.shop.product;

import ir.mapsa.shop.category.Category;
import ir.mapsa.shop.category.ICategoryService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
@Data

public class ProductService implements IProductService{

    private final ProductRepository repository;
    private final ICategoryService categoryService;



    @Override
    public Product save(Product product) {
        Category category = categoryService.getById(product.getCategory().getId());
        product.setCategory(category);
        return repository.save(product);
    }

    @Override
    public Product update(Product product) {

        repository.findById(product.getId()).orElseThrow();
        return repository.save(product);
    }

    @Override
    public void delete(Long id) {
        repository.findById(id).orElseThrow();

    }

    @Override
    public Product getById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public List<Product> getAll() {
        return (List<Product>) repository.findAll();
    }


}
