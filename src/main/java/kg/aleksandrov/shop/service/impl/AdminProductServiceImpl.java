package kg.aleksandrov.shop.service.impl;

import kg.aleksandrov.shop.dal.repository.ProductRepository;
import kg.aleksandrov.shop.mapper.ProductMapper;
import kg.aleksandrov.shop.model.dto.ProductCreateDto;
import kg.aleksandrov.shop.model.dto.ProductDto;
import kg.aleksandrov.shop.service.AdminProductService;
import kg.aleksandrov.shop.util.ExceptionUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AdminProductServiceImpl implements AdminProductService {

    private final ProductRepository productRepository;

    @Override
    @Transactional
    public void saveProduct(ProductCreateDto dto) {
        var entity = ProductMapper.PRODUCT_MAPPER.toProductEntity(dto);
        productRepository.save(entity);
    }

    @Override
    public void editProduct(ProductDto dto) {
        var product = productRepository.findById(dto.getId())
                .orElseThrow(() -> ExceptionUtils.productNotFoundException(dto.getId()));
        product = ProductMapper.PRODUCT_MAPPER.toProductEntity(dto);
        productRepository.save(product);
    }

}
