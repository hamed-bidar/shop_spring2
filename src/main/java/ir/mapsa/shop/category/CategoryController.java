package ir.mapsa.shop.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Data
@RequestMapping("/Category")
public class CategoryController {
    private final CategoryMapper mapper;
    private final CategoryService service;

    @PostMapping("v1")
    public ResponseEntity<Void> saveNew (@RequestBody CategoryDTO categoryDTO){
        Category category = mapper.toCategory(categoryDTO);
        service.save(category);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("v1/{id}")
    public ResponseEntity<CategoryDTO> getById(@RequestBody Long id){
        Category category=service.getById(id);
        CategoryDTO categoryDTO=mapper.toCategoryDTO(category);
        return ResponseEntity.ok(categoryDTO);
    }

    @GetMapping("v1")
    public ResponseEntity<List<CategoryDTO>> getAll(){
        List<Category> categoryList = service.getAll();
        List<CategoryDTO> categoryDTOList= mapper.toCategoryDTOs(categoryList);
        return ResponseEntity.ok(categoryDTOList);
    }





}
