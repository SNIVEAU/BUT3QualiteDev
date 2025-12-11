# Réponses aux questions

**1. Rôle de l'interface Projector dans le système de gestion des événements :**  
L'interface `Projector` définit le contrat pour projeter des événements du domaine sur une vue matérialisée. Elle permet d'appliquer un événement à un état courant (optionnel) et de retourner le nouvel état projeté, facilitant la synchronisation entre l'état métier et la vue de lecture.

**2. Rôle du type S dans l'interface Projector :**  
Le type générique `S` représente le type de la vue projetée (l'état cible). Il permet à l'interface d'être réutilisable pour différents types de vues, selon le domaine métier.

**3. Compléter la Javadoc de l'interface Projector en ajoutant la description de S :**  
S : Type de la vue projetée, généralement un objet métier ou une vue matérialisée sur laquelle les événements sont appliqués.

**4. Intérêt d'utiliser une interface Projector plutôt qu'une classe concrète :**  
Utiliser une interface permet de séparer le contrat de projection de son implémentation. Cela favorise l'extensibilité, le test unitaire, l'injection de dépendances et la substitution d'implémentations selon le contexte métier.

**5. Rôle de la classe ProjectionResult dans l'interface Projector :**  
`ProjectionResult` encapsule le résultat d'une projection, incluant le nouvel état projeté ou une erreur. Elle permet de gérer les cas de succès et d'échec de manière fonctionnelle, sans exceptions.

**6. Monade et gestion d'erreur :**  
Une Monade (comme `Optional`, `Try`, ou `ProjectionResult`) permet de chaîner des opérations tout en gérant les erreurs sans exceptions. Elle rend le code plus lisible, évite la propagation d'exceptions, et facilite la composition des traitements. Les avantages concrets sont la robustesse, la clarté et la facilité de test.

---

Tâche 1 : Questions sur la base de code

    Expliquer le rôle de l'interface Projector dans le système de gestion des événements.

    

    Expliquer le rôle du type S dans l'interface Projector.

    Compléter la Javadoc de l'interface Projector en ajoutant la description de S.

    Quel est l'intérêt de passer par une interface Projector plutôt que d'utiliser une classe concrète ?

    Quel est le rôle de la classe ProjectionResult dans l'interface Projector ?

TIP

Chercher à quoi correspond le terme Monade sur le web.

    Expliquer en quoi l'usage de la Monade est intéressant par rapport à la méthode de gestion d'erreur traditionnelle en Java et détailler les avantages concrets.