package com.example.store.product;

import com.example.store.order.Order;
import com.example.store.order.OrderRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepository {
    private final EntityManager em;
    private final OrderRepository orderRepository;



    public Product findById(int id) {
        Product product = em.find(Product.class, id);
        return product;
    }

    public List<Product> findAll() {
        Query query =
                em.createQuery("select p from Product p order by p.id desc", Product.class);
        return query.getResultList();
    }
}
