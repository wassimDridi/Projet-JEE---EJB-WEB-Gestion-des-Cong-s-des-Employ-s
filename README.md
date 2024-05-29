# Projet JEE - Gestion des Congés des Employés

## Description du Projet

Ce projet vise à concevoir et développer une application web Java Enterprise Edition (JEE) utilisant la technologie EJB pour gérer les congés des employés dans une entreprise.

## Fonctionnalités de l'Application

### Utilisateurs

Chaque utilisateur de l’application possède les attributs suivants :
- **id** : Identificateur unique (généré automatiquement)
- **code** : Chaîne de caractères unique
- **nom** : Chaîne de caractères (max = 50)
- **prenom** : Chaîne de caractères (max = 50)
- **dateEmbauchement** : Date d’embauchement dans l’entreprise
- **login** : Chaîne de caractères (max = 50)
- **password** : Chaîne de caractères (min = 6, max = 10)
- **type** : Chaîne de caractères, valeurs possibles : EMPLOYE ou ADMIN

### Congés

Un employé peut avoir plusieurs congés par année avec un maximum de 30 jours par an. Les règles de gestion des congés sont les suivantes :
- Un congé ne peut être pris qu’après une année d’embauche.
- La validation par un administrateur est requise pour chaque congé.
- Les congés peuvent être annulés ou arrêtés par un administrateur.

Un congé est défini par :
- **id** : Identificateur unique (généré automatiquement)
- **description** : Chaîne de caractères
- **date de début**
- **date de fin**
- **date de rupture** (éventuellement)
- **etat** : Valeurs possibles : SOLLICITE, VALIDE, REFUSE, ANNULE, EN_COURS, ARRETE, FINI

### Fonctionnalités Employé

- Consulter l’historique de ses congés (avec un état affiché par couleur)
- Filtrer la liste des congés par état ou par année
- Demander un nouveau congé
- Consulter le nombre de jours de congé restants
- Annuler les congés dont l’état est « SOLLICITE »

### Fonctionnalités Administrateur

- Consulter la liste de tous les congés de tous les employés (avec état affiché par couleur, tri par date de début décroissante)
- Filtrer la liste des congés par employé, état ou année
- Valider ou refuser un congé dont l’état est « SOLLICITE »
- Refuser un congé déjà « VALIDE »
- Arrêter un congé en cours en indiquant la date de rupture

### Règles du Système

- Au démarrage, les congés « VALIDE » deviennent « EN_COURS » si la date de début est atteinte.
- Au démarrage, les congés « EN_COURS » deviennent « FINI » si la date de fin est dépassée.
- Un utilisateur doit s’authentifier pour accéder à son profil (la procédure d’inscription est supposée déjà réalisée et les utilisateurs insérés dans la base de données).

## Travail à Réaliser

Le projet doit être réalisé en équipes de trois, avec les activités réparties comme suit :

### Activité 1 : Authentification
- Vue 1 : Fiche d’authentification
- Vue 2 : Page d’accueil de chaque utilisateur

### Activité 2 : Fonctionnalités Employé
- Vue 3 : Fiche d’ajout d’un nouveau congé
- Vue 4 : Consultation des congés (avec filtres)

### Activité 3 : Fonctionnalités Administrateur
- Vue 5 : Consultation des congés (avec filtres et actions de changement d’état)
- Vue 6 : Fiche d’arrêt de congé en spécifiant la date de rupture

## Livrables
- Code source du projet
- Captures d’écran des interfaces graphiques réalisées
- Vidéo de démonstration

## Structure du Projet

### Backend
- Technologies : JEE, EJB
- Fonctionnalités : Gestion des utilisateurs et des congés, authentification, règles de gestion des congés

### Frontend
- Interfaces : Pages web pour l’authentification, la gestion des congés par les employés et les administrateurs

### Base de Données
- Modèle : Tables pour les utilisateurs et les congés, relations et contraintes nécessaires

## Installation et Déploiement

1. Cloner le dépôt du projet
2. Configurer la base de données (importer les tables)
3. Déployer l'application sur un serveur JEE
4. Accéder à l'application via le navigateur

---
