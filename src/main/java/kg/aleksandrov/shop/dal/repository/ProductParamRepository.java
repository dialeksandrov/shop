package kg.aleksandrov.shop.dal.repository;

import kg.aleksandrov.shop.dal.entity.ProductParamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductParamRepository extends JpaRepository<ProductParamEntity, Long> {
}
