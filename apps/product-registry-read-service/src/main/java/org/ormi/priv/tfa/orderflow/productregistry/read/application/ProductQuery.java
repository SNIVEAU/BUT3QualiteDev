package org.ormi.priv.tfa.orderflow.productregistry.read.application;

import org.ormi.priv.tfa.orderflow.kernel.product.ProductId;

/**
 * Interface scellée représentant les requêtes de lecture sur les produits.
 * <p>
 * Permet de définir différents types de requêtes pour obtenir ou lister les produits.
 * </p>
 */

public sealed interface ProductQuery {
    public record GetProductByIdQuery(ProductId productId) implements ProductQuery {
    }

    public record ListProductQuery(int page, int size) implements ProductQuery {
    }

    public record ListProductBySkuIdPatternQuery(String skuIdPattern, int page, int size) implements ProductQuery {
    }
}
