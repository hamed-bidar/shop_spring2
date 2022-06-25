package ir.mapsa.shop.product;

import ir.mapsa.shop.category.Category;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IProductService {


    Product save(Product product);
    Product update(Product product);
    void  delete(Long id);
    Product getById(Long id);
    List<Product> getAll();


}
