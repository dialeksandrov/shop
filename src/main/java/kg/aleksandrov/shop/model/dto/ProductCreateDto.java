package kg.aleksandrov.shop.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import kg.aleksandrov.shop.model.enums.ProductType;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
@Builder
public class ProductCreateDto {

    @Schema(description = "Серия продукта")
    private String series;

    @Schema(description = "Производитель")
    private String manufacturer;

    @Positive(message = "Стоимость не может быть отрицательной")
    @NotNull(message = "Заполните поле стоимость")
    @Schema(description = "Стоимость")
    private BigDecimal amount;

    @NotNull(message = "Выберите тип продукта")
    @Schema(description = "Тип продукта")
    private ProductType type;

    @Schema(description = "Список параметров продукта")
    private Set<ProductParamCreateDto> params;

    @Schema(description = "Количство на складе")
    private int stockCount;

}
