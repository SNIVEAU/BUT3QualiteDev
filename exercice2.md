    ### Quelle est la différence entre les tests unitaires et les tests d'intégration ?

        le test unitaire teste le code seul, le test d’intégration teste la collaboration entre les morceaux.

    ### Est-il pertinent de systématiquement couvrir 100% de la base de code par des tests ? Expliquer votre réponse.

        Il n'est pas forcément pertinant de couvrir 100% de l'application. il est plus pertinent de se concentrer sur les parties critiques de l'application et d'assurer une bonne couverture des tests pour ces parties. Couvrir tout le code prend du temps et ne va pas forcément améliorer la qualité de celui-ci

    ### Quels avantages apporte une architecture en couches d'oignon dans la couverture des tests ? Expliquer votre réponse en prenant pour exemple ce que vous avez pu observer sur l'écriture des tests de la tâche 3.
        L'architecture en couche d'oignon permet de séparer les différentes responsabilités de l'application. Cela facilite l'écriture des tests car chaque couche peut être testée indépendamment.


    ### Expliquer la nomenclature des packages infra, application, jpa, web, client, model.

infra : tout ce qui touche à l’extérieur (base de données, fichiers, email…).

application : la logique métier, ce qui orchestre les opérations.

jpa : code spécifique à JPA/Hibernate pour accéder à la base.

web : controllers ou API exposées aux utilisateurs ou aux clients.

client : connexion à des services externes (paiement, envoi…).

model : les classes qui représentent les données, que ce soit le domaine ou des DTO
