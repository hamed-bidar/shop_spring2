package ir.mapsa.shop.category;

import ir.mapsa.shop.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepository extends PagingAndSortingRepository<Category,Long> {
    Page<Category> findAll(Pageable pageable);
}
