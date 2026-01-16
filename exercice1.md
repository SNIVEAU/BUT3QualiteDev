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



## Quels sont les concepts principaux utilisés dans l'application Order flow ?

L’application Order flow stocke ses données dans une base relationnelle via JPA et conserve un journal d’événements pour assurer la traçabilité des modifications. Les transactions sont gérées par JPA/Hibernate, ce qui garantit la cohérence des opérations. Les événements métiers sont représentés par des objets spécifiques et enregistrés pour permettre la mise à jour des vues et le suivi des actions. Les erreurs sont traitées à l’aide d’objets de résultat qui distinguent les erreurs. Enfin, les échanges entre services se font principalement par requêtes rest et via des événements asynchrones.

## Comment les concepts principaux sont-ils implémentés dans les différents modules ?

Les modules du dossier apps regroupent les services métiers comme la gestion du panier ou du catalogue. Les modules du dossier libs apportent des outils techniques, notamment pour le CQRS, le kernel et la gestion des dépendances. Les commandes servent à modifier l’état des agrégats, tandis que les requêtes permettent de lire des vues projetées à partir du journal d’événements. La persistance repose sur JPA/Hibernate et l’exposition des API se fait avec Quarkus.

## Que fait la bibliothèque libs/cqrs-support ? Comment est-elle utilisée dans les autres modules (relation entre métier et structure du code) ?

Cette bibliothèque propose toutes les abstractions nécessaires au modèle CQRS, comme les événements, les commandes et les projections. Elle fournit aussi des solutions génériques pour le stockage des événements et garantit la fiabilité des états grâce à des objets de résultat. Les modules métiers s’appuient sur elle pour appliquer le CQRS et gérer les événements.

## Que fait la bibliothèque libs/cqrs-support ? Comment est-elle utilisée dans les autres modules (relation entre métier et structure du code) ?

La bibliothèque bom-platform centralise la gestion des versions des dépendances pour l’ensemble des modules du projet, ce qui assure la cohérence et la compatibilité des librairies utilisées.

## Comment l'implémentation actuelle du CQRS et du Kernel assure-t-elle la fiabilité des états internes de l'application ?

La séparation stricte entre lecture et écriture apportée par CQRS limite les effets de bord et facilite la validation des règles métiers. Les projections peuvent être rejouées à partir du journal d’événements pour reconstruire l’état. Le kernel regroupe les règles métiers et la gestion des agrégats, tandis que l’historique des événements permet d’auditer toutes les actions. Enfin, les transactions JPA assurent l’intégrité des modifications apportées aux données.

