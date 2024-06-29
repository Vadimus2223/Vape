package ru.vsu.vadim.mapper;

import ru.vsu.vadim.model.domain.Product;
import ru.vsu.vadim.model.dto.ProductDto;

public class ProductMapper {

    public static ProductDto mapDomainToDto(Product domain) {
        ProductDto productDto = new ProductDto();
        productDto.setId(domain.getId());
        productDto.setName(domain.getName());
        productDto.setDescription(domain.getDescription());
        productDto.setPrice(domain.getPrice());
        return productDto;
    }

    public static Product mapDtoToDomain(ProductDto dto) {
        Product product = new Product();
        product.setId(dto.getId());
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        return product;
    }
}
