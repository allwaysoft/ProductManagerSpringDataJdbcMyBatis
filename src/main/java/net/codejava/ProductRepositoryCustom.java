package net.codejava;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductRepositoryCustom {

    public Page<Product> findAllByContaining(String keyword, Pageable page);

}
