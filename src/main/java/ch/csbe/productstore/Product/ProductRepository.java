package ch.csbe.productstore.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("""
        SELECT p FROM Product p
        WHERE p.id = :id
                
        AND p.active = 1
        """)
    Optional<Product> getProductById(@Param("id") long productId);

    @Query("""
        SELECT p FROM Product p
        LEFT JOIN p.category c
        WHERE c.id = :id
        AND p.active = 1
        """)
    List<Product> getProductByCategoryId(@Param("id") long categoryId);

}