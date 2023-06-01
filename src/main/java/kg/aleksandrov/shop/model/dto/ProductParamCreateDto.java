package kg.aleksandrov.shop.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductParamCreateDto {

    @Schema(description = "Название параметра")
    private String name;

    @Schema(description = "Значение параметра")
    private String param;
}
