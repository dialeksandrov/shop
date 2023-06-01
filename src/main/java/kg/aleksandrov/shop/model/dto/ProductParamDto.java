package kg.aleksandrov.shop.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductParamDto {

    @Schema(description = "Идентификатор параметра продукта")
    private Long id;

    @Schema(description = "Название параметра")
    private String name;

    @Schema(description = "Значение параметра")
    private String param;

    @Schema(description = "Идентификатор продукта(не редактируется)")
    @NotNull(message = "Идентификатор продукта не может быть пустым")
    private Long productId;

}
