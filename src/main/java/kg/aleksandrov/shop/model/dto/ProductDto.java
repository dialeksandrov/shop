package kg.aleksandrov.shop.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import kg.aleksandrov.shop.model.enums.ProductType;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
@Builder
public class ProductDto {

    @Schema(description = "Идентификатор продукта")
    private Long id;

    @Schema(description = "Серия продукта")
    private String series;

    @Schema(description = "Производитель")
    private String manufacturer;

    @Schema(description = "Стоимость")
    private BigDecimal amount;

    @Schema(description = "Тип продукта")
    private ProductType type;

    @Schema(description = "Список параметров продукта")
    private Set<ProductParamDto> params;

    @Schema(description = "Количство на складе")
    private int stockCount;

}
