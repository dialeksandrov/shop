package kg.aleksandrov.shop.service.impl;

import kg.aleksandrov.shop.dal.repository.ProductRepository;
import kg.aleksandrov.shop.mapper.ProductMapper;
import kg.aleksandrov.shop.model.dto.ProductDto;
import kg.aleksandrov.shop.model.enums.ProductType;
import kg.aleksandrov.shop.service.ProductService;
import kg.aleksandrov.shop.util.ExceptionUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ProductDto> findAllProductsByType(ProductType type) {
        return productRepository.findAllByType(type)
                .stream()
                .map(ProductMapper.PRODUCT_MAPPER::toProductDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ProductDto getProductById(Long id) {
        var product = productRepository.findById(id)
                .orElseThrow(() -> ExceptionUtils.productNotFoundException(id));
        return ProductMapper.PRODUCT_MAPPER.toProductDto(product);
    }
}
