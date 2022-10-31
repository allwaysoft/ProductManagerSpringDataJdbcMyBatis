package net.codejava;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class ProductRepositoryImpl implements ProductRepositoryCustom {

    @Autowired
    private ProductMapper productMapper;

//    public ProductRepositoryImpl(ProductMapper productMapper) {
//        this.productMapper = productMapper;
//    }
    @Override
    public Page<Product> findAllByContaining(String keyword, Pageable page) {

//        int count = jdbcTemplate.queryForObject("SELECT count(* ) FROM product WHERE CONCAT(id, ' ', name, ' ' , brand, ' ' , madein, ' ' , price) LIKE CONCAT('%',?,'%') ", Integer.class, keyword);
        int count = productMapper.listAllSortPageContainingCount(keyword);
        Sort.Order order = !page.getSort().isEmpty() ? page.getSort().toList().get(0) : Sort.Order.by("ID");

//        List<Product> products = jdbcTemplate.query("SELECT * FROM product WHERE CONCAT(id, ' ', name, ' ' , brand, ' ' , madein, ' ' , price) LIKE CONCAT('%',?,'%') ORDER BY " + order.getProperty() + " "
//                + order.getDirection().name() + " LIMIT " + page.getPageSize() + " OFFSET " + page.getOffset(),
//                (rs, rowNum) -> mapUserResult(rs), keyword
//        );
        List<Product> products = productMapper.listAllSortPageContaining(keyword, order.getProperty(), order.getDirection().name(), page.getPageSize(), page.getOffset());
        return new PageImpl<Product>(products, page, count);
    }

}
