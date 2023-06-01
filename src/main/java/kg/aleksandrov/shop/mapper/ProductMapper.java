package kg.aleksandrov.shop.mapper;

import kg.aleksandrov.shop.dal.entity.ProductEntity;
import kg.aleksandrov.shop.model.dto.ProductCreateDto;
import kg.aleksandrov.shop.model.dto.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = ProductParamMapper.class)
public interface ProductMapper {

    ProductMapper PRODUCT_MAPPER = Mappers.getMapper(ProductMapper.class);

    ProductDto toProductDto(ProductEntity entity);

    ProductEntity toProductEntity(ProductCreateDto dto);

    ProductEntity toProductEntity(ProductDto dto);
}
