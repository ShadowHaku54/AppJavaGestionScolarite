# AppJavaGestionScolarite

Application Java console de gestion de scolarité, organisée autour de trois rôles :

* **Responsable Pédagogique (RP)**
* **Attaché de classe (AC)**
* **Étudiant (ETU)**

L’application permet de gérer les **années scolaires, classes, modules, professeurs, inscriptions et demandes** des étudiants, ainsi que quelques **statistiques** globales.

---

## Fonctionnalités principales

### Responsable Pédagogique (RP)

* Gestion des **classes** :

  * Ajouter une classe
  * Lister les classes de l’année courante
  * Lister les classes d’une année donnée
  * Afficher les informations d’une classe

* Gestion des **modules et professeurs** :

  * Ajouter un module
  * Lister les modules
  * Ajouter un professeur
  * Lister les professeurs et afficher le détail d’un professeur
  * Associer un ou plusieurs modules à un professeur
  * Affecter un ou plusieurs classes à un professeur
  * Lister les classes d’un professeur
  * Lister les modules d’un professeur
  * Lister les professeurs d’un module

* Gestion des **demandes** :

  * Lister les demandes en attente
  * Filtrer les demandes en attente par type (ANNULATION / SUSPENSION)
  * Traiter une demande (modification de son type)

* **Statistiques** :

  * Effectif global par année
  * Répartition F/H par année
  * Effectif par classe pour une année donnée
  * Répartition F/H par classe
  * Nombre de suspensions / annulations par année

* Gestion des **années scolaires** :

  * Afficher l’année scolaire courante
  * Lister les années scolaires déjà définies
  * Définir une nouvelle année scolaire (et mettre à jour l’année courante)

---

### Attaché de classe (AC)

* **Inscription** d’un étudiant :

  * `INSCRIPTION` ou `REINSCRIPTION`
  * Création de l’étudiant (nom, prénom, email perso, adresse, sexe, mot de passe)
  * Choix de la classe d’affectation

* **Consultation** :

  * Lister les étudiants d’une classe pour l’année courante ou une année donnée
  * Lister les demandes d’un étudiant

* Afficher l’année scolaire courante.

---

### Étudiant (ETU)

* **Soumettre une demande** :

  * Choix de l’inscription concernée
  * Type de demande : ANNULATION / SUSPENSION
  * Saisie du motif

* **Consulter ses demandes** :

  * Liste complète de ses demandes
  * Filtre par statut (EN_ATTENTE / ACCEPTEE / REFUSE)

* Afficher l’année scolaire courante.

---

## Modèle de données (résumé)

Principales entités :

* `Etudiant`, `Professeur`, `AttacheClasse`, `ResponsablePedagogique`
* `Classe` (libellé, niveau, filière, période d’inscription, année scolaire)
* `AnneeScolaire` + `CurrentAnneeScolaire`
* `Inscription` (étudiant, classe, année, type, statut)
* `Demande` (étudiant, inscription, type, statut, motif)
* `Module`, `Dispense` (prof ↔ module), `Affectation` (prof ↔ classe)

Les règles d’unicité (simplifiées) :

* Un étudiant est unique par **email personnel**
* Une classe est unique par **libellé + année scolaire**
* Un module est unique par **nom**
* Une inscription est unique par **(étudiant, année scolaire)**
* Une dispense est unique par **(professeur, module)**
* Une affectation est unique par **(professeur, classe)**

Toutes les données sont stockées en **mémoire** via des services statiques (`ArrayList`).

---

## Architecture

Le code est organisé en 3 couches principales :

* `model` : entités métier et enums
* `service` : services statiques jouant le rôle de repository en mémoire
* `view` : vues console (saisie clavier, menus, affichage des listes)

Les classes suivantes jouent le rôle de “contrôleurs” :

* `Main` : point d’entrée, menu principal de connexion
* `AcApp` : menu Attaché de classe
* `RpApp` : menu Responsable pédagogique
* `EtuApp` : menu Étudiant

---

## Prérequis

* **Java JDK 17+** (ou au minimum une version supportant la syntaxe `switch` avec `->`)
* Un terminal console
* (Optionnel) Un IDE comme **IntelliJ IDEA** ou **Eclipse** pour ouvrir le projet.

---

## Installation

1. Cloner ou télécharger le projet :

   ```bash
   # Exemple si le projet est sur Git
   git clone <URL_DU_DEPOT>
   cd AppJavaGestionScolarite-master
   ```

   Ou bien extraire l’archive et se placer dans le dossier du projet.

2. Aller dans le dossier des sources :

   ```bash
   cd src
   ```

---

## Compilation et exécution (ligne de commande)

Depuis le dossier `src` :

1. **Compiler** toutes les classes :

   ```bash
   javac model/*.java service/*.java view/*.java Main.java AcApp.java EtuApp.java RpApp.java
   ```

2. **Lancer** l’application :

   ```bash
   java Main
   ```

L’application affichera alors le **menu principal** de connexion.

---

## Comptes de test par défaut

Lors du premier lancement, deux comptes sont créés dans le code :

* **Attaché de classe**

  * Nom : `attache`
  * Prénom : `classe`
  * Mot de passe : `pass`
  * Email institutionnel généré automatiquement par la classe `Utilisateur` :
    `classe-attache-1@ism.ac.sn`

* **Responsable pédagogique**

  * Nom : `responsable`
  * Prénom : `pedagogique`
  * Mot de passe : `pass`
  * Email institutionnel généré :
    `pedagogique-responsable-2@ism.rp.sn`

> 💡 Pour se connecter, utiliser l’**email institutionnel** et le **mot de passe** associés.

Les étudiants sont créés lors des inscriptions et reçoivent également un email institutionnel du type :

```text
<premon>-<nom>-<id>@ism.<role>.sn
```

ex. `jean-dupont-3@ism.etu.sn`.

