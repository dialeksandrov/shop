package kg.aleksandrov.shop.controller;

import io.swagger.v3.oas.annotations.Operation;
import kg.aleksandrov.shop.model.dto.ProductCreateDto;
import kg.aleksandrov.shop.model.dto.ProductDto;
import kg.aleksandrov.shop.service.AdminProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/products")
@RequiredArgsConstructor
public class ProductAdminController {

    private final AdminProductService adminProductService;

    @Operation(summary = "Добавление продукта, тип продуктов PC, LAPTOP, MONITOR, HDD")
    @PostMapping
    public ResponseEntity<?> saveProduct(@RequestBody ProductCreateDto productDto) {
        adminProductService.saveProduct(productDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Редактирование продукта, тип продуктов PC, LAPTOP, MONITOR, HDD")
    @PutMapping
    public ResponseEntity<?> editProduct(@RequestBody ProductDto productDto) {
        adminProductService.editProduct(productDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
