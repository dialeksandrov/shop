package kg.aleksandrov.shop.controller;

import kg.aleksandrov.shop.model.dto.ProductCreateDto;
import kg.aleksandrov.shop.model.dto.ProductDto;
import kg.aleksandrov.shop.model.dto.ProductParamCreateDto;
import kg.aleksandrov.shop.model.dto.ProductParamDto;
import kg.aleksandrov.shop.model.enums.ProductType;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductAdminControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;
    private ProductCreateDto createDto;
    private ProductDto productDto;

    @BeforeAll
    public void setup() {
        ProductParamCreateDto paramCreateDto = ProductParamCreateDto.builder()
                .param("size")
                .name("128")
                .build();

        createDto = ProductCreateDto.builder()
                .series("TRE123123")
                .manufacturer("Samsung")
                .amount(BigDecimal.valueOf(100))
                .type(ProductType.HDD)
                .params(Set.of(paramCreateDto))
                .stockCount(10)
                .build();

        ProductParamDto paramDto = ProductParamDto.builder()
                .id(1L)
                .param("size")
                .name("128")
                .productId(1L)
                .build();

        productDto = ProductDto.builder()
                .id(1L)
                .series("TRE123123")
                .manufacturer("Samsung")
                .amount(BigDecimal.valueOf(100))
                .type(ProductType.HDD)
                .params(Set.of(paramDto))
                .stockCount(13)
                .build();
    }

    @Test
    @Order(1)
    @DisplayName("Сохранение продукта")
    void postApiSaveProduct(){
        ResponseEntity<String> response = restTemplate.postForEntity(
                createAdminURLWithPort(),
                new HttpEntity<>(createDto, new HttpHeaders()),
                String.class
        );
        assertNull(response.getBody());
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    @Order(2)
    @DisplayName("Редактирование продукта")
    void putApiEditProduct(){
        ResponseEntity<String> response = restTemplate.exchange(
                createAdminURLWithPort(),
                HttpMethod.PUT,
                new HttpEntity<>(productDto, new HttpHeaders()),
                String.class
        );
        assertNull(response.getBody());
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    @Order(3)
    @DisplayName("Получение продуктов по типу")
    void getApiGetProductsByType(){
        UriComponents uri = UriComponentsBuilder.fromHttpUrl(createURLWithPort())
                .queryParam("type", "HDD")
                .build();
        ResponseEntity<ProductDto[]> response = restTemplate.getForEntity(
                uri.toUriString(),
                ProductDto[].class
        );
        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().length);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    @Order(4)
    @DisplayName("Получение продукта по идентификатору")
    void getApiGetProductById(){
        UriComponents uri = UriComponentsBuilder.fromHttpUrl(createURLWithPort())
                .path("/{id}")
                .buildAndExpand(1);
        ResponseEntity<ProductDto> response = restTemplate.getForEntity(
                uri.toUriString(),
                ProductDto.class
        );
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    private String createURLWithPort() {
        return String.format("http://localhost:%d/api/products", port);
    }

    private String createAdminURLWithPort() {
        return String.format("http://localhost:%d/api/admin/products", port);
    }

}