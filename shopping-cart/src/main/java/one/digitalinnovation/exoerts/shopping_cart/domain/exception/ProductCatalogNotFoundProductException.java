package one.digitalinnovation.exoerts.shopping_cart.domain.exception;

public class ProductCatalogNotFoundProductException extends RuntimeException {
    public ProductCatalogNotFoundProductException() {
        super("Produto não econtrado no Catalogo de Produtos!");
    }
    public ProductCatalogNotFoundProductException(String message) {
        super(message);
    }
}
