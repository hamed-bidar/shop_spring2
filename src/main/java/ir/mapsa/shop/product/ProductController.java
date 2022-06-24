package ir.mapsa.shop.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Data
@RequestMapping("/product")
public class ProductController {

    private final ProductMapper mapper;
    private  final IProductService service;

    @PostMapping("v1")
    public ResponseEntity<Void> saveNew (@RequestBody ProductDTO productDTO){
        Product product  = mapper.toProduct(productDTO);
        service.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("v1/{id}")
    public ResponseEntity<ProductDTO> getById(@RequestBody Long id){
        Product product=service.getById(id);
        ProductDTO productDTO=mapper.toProductDTO(product);
        return ResponseEntity.ok(productDTO);
    }

    @GetMapping("v1")
    public ResponseEntity<List<ProductDTO>> getAll(){
        List<Product> productList = service.getAll();
        List<ProductDTO> productDTOS= mapper.toProductDTOS(productList);
        return ResponseEntity.ok(productDTOS);
    }

}
