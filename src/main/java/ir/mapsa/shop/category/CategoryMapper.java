package ir.mapsa.shop.category;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category toCategory( CategoryDTO categoryDTO);
    CategoryDTO toCategoryDTO(Category category);

    List<Category> toCategories (List<CategoryDTO> categoryDTOs);
    List<CategoryDTO> toCategoryDTOs(List<Category > categories);




}
