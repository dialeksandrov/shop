package kg.aleksandrov.shop.dal.entity;

import jakarta.persistence.*;
import kg.aleksandrov.shop.model.enums.ProductType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @SequenceGenerator(name = "public.products_gen", sequenceName = "public.products_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "public.products_gen")
    private Long id;

    private String series;

    private String manufacturer;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private ProductType type;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "stock_count")
    private int stockCount;

    @JoinColumn(name = "product_id")
    @OneToMany(cascade = CascadeType.ALL)
    private Set<ProductParamEntity> params;

}
