package ir.mapsa.shop.util;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data

public class PaginationDTO<T> {

    private Long totalElements;
    private Integer totalPage;
    private List<T> data;

}
