package kg.aleksandrov.shop.controller;

import io.swagger.v3.oas.annotations.Operation;
import kg.aleksandrov.shop.model.dto.ProductDto;
import kg.aleksandrov.shop.model.enums.ProductType;
import kg.aleksandrov.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @Operation(summary = "Получение списка продуктов по типу продукта")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductDto>> getProductsByType(@RequestParam(name = "type") ProductType type) {
        var products = productService.findAllProductsByType(type);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @Operation(summary = "Получение продукта по идентификатору")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDto> getProductById(@PathVariable(name = "id") Long id) {
        var product = productService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
