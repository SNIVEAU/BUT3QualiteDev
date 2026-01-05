## Quels sont les principaux domaines métiers de l'application Order flow ?

L'application à deux domaines métiers principaux qui sont le panier d'achat et le traitement des commandes.

## Comment les services sont-ils conçus pour implémenter les domaines métiers ?

Les services sont conçus en suivant les principes de l'architecture orientée domaine (DDD). Chaque domaine métier est encapsulé dans des services dédiés qui sont complètement indépendants. Par exemple le service de panier d'achat va uniquement faire le CRUD du panier et rien d'autre. Cette séparation permet une meilleure maintenabilité car chaque service peut évoluer de façon indépendante.

## Quelles sont les responsabilités des modules :

    apps/store-back : gère le backend du panier d'achat et du traitement des commandes
    apps/store-front: gère le frontend de l'application de commerce en ligne
    libs/kernel: contient les classes et utilitaires communs partagés entre les différents services
    apps/product-registry-domain-service: gère le domaine métier du catalogue produits
    apps/product-registry-read-service: fournit les API de lecture pour le catalogue produits
    libs/bom-platform: contient la gestion des dépendances partagées pour la plateforme
    libs/cqrs-support: fournit des utilitaires pour implémenter le pattern CQRS
    libs/sql: fournit des utilitaires pour interagir avec les bases de données SQL