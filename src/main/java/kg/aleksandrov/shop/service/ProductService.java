package kg.aleksandrov.shop.service;

import kg.aleksandrov.shop.model.dto.ProductDto;
import kg.aleksandrov.shop.model.enums.ProductType;

import java.util.List;

public interface ProductService {

    List<ProductDto> findAllProductsByType(ProductType type);

    ProductDto getProductById(Long id);
}
