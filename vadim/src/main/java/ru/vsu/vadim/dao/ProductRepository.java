package ru.vsu.vadim.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vsu.vadim.model.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}