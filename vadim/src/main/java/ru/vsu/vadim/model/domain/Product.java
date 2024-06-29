package ru.vsu.vadim.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@SequenceGenerator(name = Product.ID_SEQ, sequenceName = Product.ID_SEQ, allocationSize = 1)
public class Product {

    public static final String ID_SEQ = "product_id_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = ID_SEQ)
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
}
