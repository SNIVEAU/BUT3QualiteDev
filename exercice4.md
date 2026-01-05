# Réponses aux questions tache 1

**1. Rôle de l'interface Projector dans le système de gestion des événements :**  
L'interface Projector définit le contrat pour projeter des événements du domaine sur une vue matérialisée. Elle permet d'appliquer un événement à un état courant (optionnel) et de retourner le nouvel état projeté, facilitant la synchronisation entre l'état métier et la vue de lecture.

**2. Rôle du type S dans l'interface Projector :**  
Le type générique S représente le type de la vue projetée (l'état cible). Il permet à l'interface d'être réutilisable pour différents types de vues, selon le domaine métier.


**4. Intérêt d'utiliser une interface Projector plutôt qu'une classe concrète :**  
Utiliser une interface permet de séparer le contrat de projection de son implémentation. Cela favorise l'extensibilité, le test unitaire, l'injection de dépendances et la substitution d'implémentations selon le contexte métier.

**5. Rôle de la classe ProjectionResult dans l'interface Projector :**  
ProjectionResult encapsule le résultat d'une projection, incluant le nouvel état projeté ou une erreur. Elle permet de gérer les cas de succès et d'échec de manière fonctionnelle sans déclencher d'exceptions.

**6. Monade et gestion d'erreur :**  
Une Monade par exemple Try ou optional permet de chaîner des opérations tout en gérant les erreurs sans exceptions. Elle rend le code plus lisible, évite la propagation d'exceptions, et facilite la composition des traitements. Les avantages concrets sont la robustesse, la clarté et la facilité de test.


# Réponses aux questions tache 2

**1. Expliquer le rôle de l'interface OutboxRepository dans le système de gestion des événements.**

L'interface OutboxRepository permet de manipuler les messages stockés dans la table Outbox. Elle offre des méthodes pour enregistrer, récupérer et supprimer les événements qui doivent être publiés, assurant ainsi la persistance fiable des messages avant leur envoi.

**2. Expliquer comment l'Outbox Pattern permet de garantir la livraison des événements dans un système distribué.**

L'outbox pattern va enregistrer l'évènement dans une table outbox dans la même transaction que les modifications de l'état de l'application. Un processus séparé lit ensuite les messages de la table outbox et tente de les renvoyer en cas d'échec le message reste dans la table outbox pour une nouvelle tentative ultérieure. Cela garantit que les messages ne sont pas perdus même en cas de panne.

**3. En analysant le code existant, décrire le fonctionnement de l'Outbox Pattern concrètement dans le contexte de l'application. Créez un diagramme pour illustrer le flux des événements. Créez un diagramme de séquence pour montrer le séquencement des interactions entre les différents composants. Précisez les intéractions transactionnelles.**

Lors d'une commande le service modifie le produit puis le sauvegarde ainsi que l'évènement dans la table outbox dans une même transaction. Ultérieurement un service de publication lit les évènements dans la table outbox et les publie


**4. Expliquer comment l'Outbox Pattern peut être utilisé pour gérer les erreurs de livraison des événements dans cette base de code. Référez-vous ici au schéma de données dans les fichiers XML liquibase et aux implémentations concrètes.**

L'Outbox Pattern gère les erreurs de livraison en conservant les messages non livrés dans la table outbox. Si une tentative de publication échoue, le message reste dans la table pour une nouvelle tentative ultérieure. Le schéma de données inclut des champs pour suivre l'état de chaque message (par exemple, "en attente", "échec", "livré"), permettant au système de réessayer la livraison des messages échoués sans perte de données.



# Réponses aux questions tache 3

**1. Expliquer le rôle du journal d'événements dans le système de gestion des événements.**

Le journal d'événements (Event Log) stocke tous les événements produits par les différents produits il permet de conserver un historique des changements d'état et de reconstruire l'état actuel du système en rejouant les événements.

**2. Pourquoi l'interface EventLogRepository ne comporte-t-elle qu'une seule méthode append ? Pourquoi n'y a-t-il pas de méthode pour récupérer les événements ou les supprimer ?**

Le log d'événements est conçu pour être append-only, ce qui signifie que les événements sont uniquement ajoutés la modification et la suppression sont fait à d'autres niveaux du système. Cela garantit l'intégrité et la traçabilité des événements.

**3. En tirant vos conclusions de votre réponse à la question 2 et de l'analyse de l'application (Objets liés à l'event log, schéma de base de données), déterminez les implications de cette conception sur la gestion des événements dans l'application et quelles pourraient être les autres usages du journal d'événements.**

Cette conception garantit que tous les événements sont conservés de manière immuable, ce qui facilite l'audit et le débogage. Le journal d'événements peut également être utilisé pour la reconstruction de l'état du système, la synchronisation entre services, et l'analyse des tendances ou comportements utilisateur.

# Réponses aux questions tache 4

**1. Identifier et expliquer les principales limites de l'architecture CQRS dans le contexte de l'application.**

L'architecture CQRS peut introduire une complexité accrue en séparant les modèles de lecture et d'écriture, ce qui peut compliquer la maintenance et le développement. De plus, la synchronisation entre les deux modèles peut entraîner des problèmes de cohérence des données, surtout dans des environnements distribués. en plus l'asynchronie rend le débogage beaucoup plus difficile 

**2. Quelles limites intrinsèques à CQRS sont déjà compensées par la mise en œuvre actuelle de l'application ?**

L'application utilise des patterns comme l'Outbox Pattern pour garantir la livraison fiable des événements, ce qui aide à atténuer les problèmes de cohérence entre les modèles de lecture et d'écriture. De plus, l'utilisation de projections permet de maintenir des vues de lecture optimisées, réduisant ainsi la complexité pour les opérations de lecture.

**3. Quelles autres limites pourraient être introduites par cette mise en œuvre ?**

Une meilleur gestion des évènements pourrait être fait dans l'outbox pattern pour éviter des messages qui boucle indéfiniment en cas d'erreur persistante. 

**4. Que se passerait-il dans le cas d'une projection multiple (un évènement donnant lieu à plusieurs actions conjointes mais de nature différente) ?**

Dans le cas d'une projection multiple, un événement unique pourrait déclencher plusieurs mises à jour dans différentes vues de lecture. Cela pourrait compliquer la gestion des transactions et la cohérence des données, car chaque projection pourrait avoir des exigences différentes en termes de traitement et de délai.