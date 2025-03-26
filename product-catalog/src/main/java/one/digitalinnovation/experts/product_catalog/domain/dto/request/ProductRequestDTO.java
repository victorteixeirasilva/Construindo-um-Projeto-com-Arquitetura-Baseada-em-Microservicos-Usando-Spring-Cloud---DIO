package one.digitalinnovation.experts.product_catalog.domain.dto.request;

public record ProductRequestDTO(
        String name,
        Integer amount,
        double unitPrice
) {
}
