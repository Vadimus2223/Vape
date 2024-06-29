package ru.vsu.vadim.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.vsu.vadim.dao.ProductRepository;
import ru.vsu.vadim.mapper.ProductMapper;
import ru.vsu.vadim.model.domain.Product;
import ru.vsu.vadim.model.dto.ProductDto;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public Page<ProductDto> getProductPage(Pageable pageable) {
        return repository.findAll(pageable)
                .map(ProductMapper::mapDomainToDto);
    }

    public ProductDto createProduct(ProductDto dto) {
        Product product = ProductMapper.mapDtoToDomain(dto);
        product.setId(null);
        Product save = repository.save(product);
        return ProductMapper.mapDomainToDto(save);
    }

    public ProductDto getProductById(Long id) {
        return repository.findById(id)
                .map(ProductMapper::mapDomainToDto)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public ProductDto updateProduct(Long id, ProductDto productDto) {
        if (repository.existsById(id)) {
            Product product = ProductMapper.mapDtoToDomain(productDto);
            product.setId(id);
            Product save = repository.save(product);
            return ProductMapper.mapDomainToDto(save);
        } else {
            throw new RuntimeException("Product not found");
        }
    }

    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }
}
