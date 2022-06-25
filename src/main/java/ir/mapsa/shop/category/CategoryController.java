package ir.mapsa.shop.category;

import ir.mapsa.shop.util.PaginationDTO;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Category")
public class CategoryController {
    private final CategoryMapper mapper;
    private final CategoryService service;

    @PostMapping("/v1")
    public ResponseEntity<Void> saveNew (@RequestBody CategoryDTO categoryDTO){
        Category category = mapper.toCategory(categoryDTO);
        service.save(category);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/v1/{id}")
    public ResponseEntity<CategoryDTO> getById(@PathVariable Long id){
        Category category=service.getById(id);
        CategoryDTO categoryDTO=mapper.toCategoryDTO(category);
        return ResponseEntity.ok(categoryDTO);
    }

    @GetMapping("/v1")
    public ResponseEntity<List<CategoryDTO>> getAll(){
        List<Category> categoryList = service.getAll();
        List<CategoryDTO> categoryDTOList= mapper.toCategoryDTOs(categoryList);
        return ResponseEntity.ok(categoryDTOList);
    }

    @GetMapping("/v1/{page}/{size}")
    public ResponseEntity<PaginationDTO> getAllPages(@PathVariable (name = "page") int page,
                                                     @PathVariable (name = "size") int size ){
        Page<Category> categoryPage = service.getAllPages(page, size);

        int totalPage = categoryPage.getTotalPages();
        Long totalElements = categoryPage.getTotalElements();

        List<Category> categoryList=categoryPage.getContent();
        List<CategoryDTO> categoryDTOList = mapper.toCategoryDTOs(categoryList);

        PaginationDTO<CategoryDTO> categoryDTOPaginationDTO= new PaginationDTO<>(totalElements,totalPage,categoryDTOList);
        return ResponseEntity.ok(categoryDTOPaginationDTO);

    }


}
