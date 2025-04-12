### Système de Réservation de Billets - API SOAP

## Description

Ce projet est une API SOAP pour un système de réservation de billets d'événements. Il permet la gestion complète des événements, des billets, des utilisateurs et des réservations via des services web SOAP.

## Fonctionnalités

- **Gestion des utilisateurs** : inscription, connexion, modification du profil
- **Gestion des événements** : création, modification, suppression
- **Gestion des billets** : création, modification, disponibilité
- **Gestion des réservations** : réservation, annulation, modification

## Structure du projet

```plaintext
reservation/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   ├── example/
│   │   │   │   │   ├── Main.java                  # Point d'entrée de l'application
│   │   │   │   │   ├── model/                     # Classes de modèle (entités)
│   │   │   │   │   │   ├── Billet.java
│   │   │   │   │   │   ├── Evenement.java
│   │   │   │   │   │   ├── Reservation.java
│   │   │   │   │   │   ├── Utilisateur.java
│   │   │   │   │   │   └── Promotion.java
│   │   │   │   │   ├── repository/                # Couche d'accès aux données
│   │   │   │   │   │   ├── BilletRepository.java
│   │   │   │   │   │   ├── EvenementRepository.java
│   │   │   │   │   │   ├── ReservationRepository.java
│   │   │   │   │   │   ├── UtilisateurRepository.java
│   │   │   │   │   │   └── PromotionRepository.java
│   │   │   │   │   ├── service/                   # Services SOAP
│   │   │   │   │   │   ├── BilletService.java
│   │   │   │   │   │   ├── BilletServiceImpl.java
│   │   │   │   │   │   ├── EvenementService.java
│   │   │   │   │   │   ├── EvenementServiceImpl.java
│   │   │   │   │   │   ├── ReservationService.java
│   │   │   │   │   │   ├── ReservationServiceImpl.java
│   │   │   │   │   │   ├── UtilisateurService.java
│   │   │   │   │   │   └── UtilisateurServiceImpl.java
│   │   │   │   │   └── util/                      # Classes utilitaires
│   │   │   │   │       └── DatabaseConnection.java
│   │   ├── resources/
│   │   │   └── schema.sql                         # Script de création de la base de données
```

## Technologies utilisées

- **Java 11+** : Langage de programmation principal
- **JAX-WS** : API Java pour les services web SOAP
- **MySQL** : Système de gestion de base de données
- **Maven** : Gestion des dépendances et build
- **JDBC** : Connexion à la base de données


## Prérequis

- JDK 11 ou supérieur
- Maven 3.6 ou supérieur
- MySQL 8.0 ou supérieur


## Installation et configuration

### 1. Cloner le projet

```shellscript
git clone https://github.com/KabiraEttalbi/SOAP-JAX-WS-Implementation.git
cd reservation
```

### 2. Configurer la base de données

1. Créez une base de données MySQL nommée `reservation_billets`
2. Modifiez les informations de connexion dans `src/main/java/com/example/util/DatabaseConnection.java` :


```java
private static final String URL = "jdbc:mysql://localhost:3306/reservation_billets?createDatabaseIfNotExist=true";
private static final String USER = "votre_utilisateur";
private static final String PASSWORD = "votre_mot_de_passe";
```

### 3. Compilation du projet et Généretion des WSDL

Pour générer les fichiers WSDL des services :

```shellscript
mvn clean compile
```
Les fichiers WSDL seront générés dans le répertoire `target/generated-sources/wsdl/`.

## Exécution 

Pour démarrer l'application et publier les services SOAP :

```shellscript
mvn exec:java
```

Les services seront disponibles aux adresses suivantes :

- Service Utilisateur : [http://localhost:8080/utilisateurservice](http://localhost:8080/utilisateurservice)
- Service Événement : [http://localhost:8080/evenementservice](http://localhost:8080/evenementservice)
- Service Billet : [http://localhost:8080/billetservice](http://localhost:8080/billetservice)
- Service Réservation : [http://localhost:8080/reservationservice](http://localhost:8080/reservationservice)


## Test des services

### Avec SoapUI

1. Téléchargez et installez [SoapUI](https://www.soapui.org/downloads/soapui/)
2. Créez un nouveau projet SOAP
3. Ajoutez les WSDL en utilisant les URLs :

1. [http://localhost:8080/utilisateurservice?wsdl](http://localhost:8080/utilisateurservice?wsdl)
2. [http://localhost:8080/evenementservice?wsdl](http://localhost:8080/evenementservice?wsdl)
3. [http://localhost:8080/billetservice?wsdl](http://localhost:8080/billetservice?wsdl)
4. [http://localhost:8080/reservationservice?wsdl](http://localhost:8080/reservationservice?wsdl)



4. Testez les différentes opérations disponibles


## Documentation des API

### Service Utilisateur

| Opération | Description
|-----|-----
| inscrireUtilisateur | Inscription d'un nouvel utilisateur
| connecterUtilisateur | Connexion d'un utilisateur
| modifierUtilisateur | Modification des informations d'un utilisateur
| supprimerUtilisateur | Suppression d'un utilisateur
| getUtilisateurById | Récupération d'un utilisateur par son ID
| getUtilisateurs | Récupération de tous les utilisateurs
| getReservationsUtilisateur | Récupération des réservations d'un utilisateur


### Service Événement

| Opération | Description
|-----|-----
| creerEvenement | Création d'un nouvel événement
| modifierEvenement | Modification d'un événement
| supprimerEvenement | Suppression d'un événement
| getEvenements | Récupération de tous les événements
| getEvenementById | Récupération d'un événement par son ID
| getBilletsByEvenement | Récupération des billets d'un événement
| getNombreReservationsParEvenement | Statistiques sur les réservations


### Service Billet

| Opération | Description
|-----|-----
| getBillets | Récupération de tous les billets
| creerBillet | Création d'un nouveau billet
| modifierBillet | Modification d'un billet
| supprimerBillet | Suppression d'un billet
| getBilletById | Récupération d'un billet par son ID
| creerBilletsEnMasse | Création de plusieurs billets en une fois


### Service Réservation

| Opération | Description
|-----|-----
| reserverBillet | Réservation d'un billet
| annulerReservation | Annulation d'une réservation
| modifierReservation | Modification d'une réservation
| getReservationById | Récupération d'une réservation par son ID
| getAllReservations | Récupération de toutes les réservations


## Modèle de données

### Utilisateur

- id (Long) : Identifiant unique
- nom (String) : Nom de l'utilisateur
- email (String) : Email de l'utilisateur (unique)
- motDePasse (String) : Mot de passe de l'utilisateur

### Événement

- id (Long) : Identifiant unique
- nom (String) : Nom de l'événement
- lieu (String) : Lieu de l'événement
- date (Date) : Date et heure de l'événement
- description (String) : Description de l'événement
- capaciteMax (int) : Capacité maximale de l'événement


### Billet

- id (Long) : Identifiant unique
- evenement (Evenement) : Événement associé
- categorie (String) : Catégorie du billet
- prix (BigDecimal) : Prix du billet
- disponible (boolean) : Disponibilité du billet


### Réservation

- id (Long) : Identifiant unique
- utilisateur (Utilisateur) : Utilisateur qui a fait la réservation
- billet (Billet) : Billet réservé
- dateReservation (Date) : Date de la réservation
- statut (String) : Statut de la réservation (CONFIRMÉ, ANNULÉ, PAYÉ, REMBOURSÉ)

Pour toute question ou suggestion, veuillez ouvrir une issue sur le dépôt GitHub du projet.
