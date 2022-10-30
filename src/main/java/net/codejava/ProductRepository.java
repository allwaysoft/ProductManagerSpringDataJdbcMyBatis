package net.codejava;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductRepository extends PagingAndSortingRepository<Product, Long>, ProductRepositoryCustom {

    Page<Product> findAllByNameContaining(String name, Pageable pageable);
}
