package ch.csbe.productstore.Category;

import ch.csbe.productstore.Category.dto.CategoryDetailDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("""
        SELECT c FROM Category c
        WHERE c.id = :id
        AND c.active = 1
        """)
    Optional<Category> getCategoryById(@Param("id") long categoryId);
}
