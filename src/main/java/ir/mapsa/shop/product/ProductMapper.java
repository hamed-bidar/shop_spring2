package ir.mapsa.shop.product;

import ir.mapsa.shop.category.CategoryMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "sprin",uses = CategoryMapper.class)

public interface ProductMapper {

    Product toProduct(ProductDTO productDTO);
    ProductDTO toProductDTO(Product product);

    List<Product> toProducts (List<ProductDTO> productDTOS);
    List<ProductDTO> toProductDTOS(List<Product> products);


}
