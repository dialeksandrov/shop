package kg.aleksandrov.shop.service;

import kg.aleksandrov.shop.model.dto.ProductCreateDto;
import kg.aleksandrov.shop.model.dto.ProductDto;

public interface AdminProductService {

    void saveProduct(ProductCreateDto dto);

    void editProduct(ProductDto dto);
}
