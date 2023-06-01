package kg.aleksandrov.shop.dal.repository;

import kg.aleksandrov.shop.dal.entity.ProductEntity;
import kg.aleksandrov.shop.model.enums.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findAllByType(ProductType type);
}
