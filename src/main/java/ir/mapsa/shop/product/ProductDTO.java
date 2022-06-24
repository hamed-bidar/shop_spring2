package ir.mapsa.shop.product;

import io.swagger.annotations.ApiModelProperty;
import ir.mapsa.shop.category.CategoryDTO;
import lombok.Data;

@Data

public class ProductDTO {

    @ApiModelProperty(required = false,hidden = true)
    private Long id;

    @ApiModelProperty(required = true,hidden = false)
    private String title;

    @ApiModelProperty(required = true,hidden = false)
    private Long price;


    @ApiModelProperty(required = true,hidden = false)
    private CategoryDTO category;
}
