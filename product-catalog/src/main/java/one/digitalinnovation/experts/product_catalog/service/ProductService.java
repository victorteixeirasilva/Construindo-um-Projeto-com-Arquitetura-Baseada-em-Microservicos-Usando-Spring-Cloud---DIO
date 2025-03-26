package one.digitalinnovation.experts.product_catalog.service;

import one.digitalinnovation.experts.product_catalog.domain.dto.request.ProductRequestDTO;
import one.digitalinnovation.experts.product_catalog.domain.entity.Product;
import one.digitalinnovation.experts.product_catalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product create(ProductRequestDTO productRequestDTO) {
        var newProduct = new Product();
        newProduct.setAmount(productRequestDTO.amount());
        newProduct.setName(productRequestDTO.name());
        newProduct.setUnitPrice(productRequestDTO.unitPrice());

        try {
            return repository.save(newProduct);
        } catch (Exception e) {
            throw new RuntimeException("Problema para cadastrar usuário ao banco de Dados");
        }
    }

    public List<Product> getAll() {
        List<Product> products = repository.findAll();

        if (products.isEmpty()) {
            throw new UnsupportedOperationException("Não existe produtos cadastrados!");
        }

        return repository.findAll();
    }

    public Product getById(Long id) {
        return repository.findById(id)
                .orElseThrow(
                        () -> new IllegalArgumentException("Produto não encontrado!"));
    }
}
