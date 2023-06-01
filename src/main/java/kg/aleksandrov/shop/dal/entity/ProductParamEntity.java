package kg.aleksandrov.shop.dal.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_params")
public class ProductParamEntity {

    @Id
    @SequenceGenerator(name = "public.product_params_gen", sequenceName = "public.product_params_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "public.product_params_gen")
    private Long id;

    private String name;

    private String param;

    @Column(name = "product_id")
    private Long productId;

}
