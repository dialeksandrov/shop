package kg.aleksandrov.shop.mapper;

import kg.aleksandrov.shop.dal.entity.ProductParamEntity;
import kg.aleksandrov.shop.model.dto.ProductParamCreateDto;
import kg.aleksandrov.shop.model.dto.ProductParamDto;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper
public interface ProductParamMapper {

    ProductParamDto toProductParamDto(ProductParamEntity entity);

    ProductParamEntity toProductParamEntity(ProductParamDto dto);

    Set<ProductParamEntity> toProductParamSetEntity(Set<ProductParamCreateDto> dtoList);
}
