package ir.mapsa.shop.category;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CategoryDTO {

    @ApiModelProperty(required = false,hidden = true)
    private Long id;

    @NotNull
    @NotBlank
    @ApiModelProperty(required = true,hidden = false)
    private String title;

}
