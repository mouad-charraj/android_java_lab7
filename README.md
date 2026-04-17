# Android Java Lab 7

## Description
Ce projet est le septième laboratoire pratique du module de développement mobile Android. Il s'agit d'une application simple permettant d’afficher une liste de stars dans une interface moderne avec RecyclerView. L’application utilise un écran de démarrage, une barre de recherche, un système de partage et une fenêtre popup pour modifier la note d’un élément. Ce laboratoire permet de comprendre l’utilisation des composants Android modernes, la gestion d’une liste dynamique et l’organisation d’une application selon une architecture claire.

## Screenshot
<img width="400" height="882" alt="lab7" src="https://github.com/user-attachments/assets/04e266cd-5873-40c6-bfc8-793945c36942" />


## Fonctionnalités
L'application propose une interface interactive avec les éléments suivants :

* Écran de Démarrage Animé : Une animation d’accueil fluide s’affiche au lancement à travers un SplashScreen, offrant une transition élégante vers l’écran principal.
* Liste Verticale des Stars : Une liste verticale de stars est présentée à l’aide d’un RecyclerView, chaque élément affichant une image circulaire et une note moyenne.
* Recherche Instantanée : Un filtrage des noms est disponible via la barre de recherche SearchView, permettant de retrouver rapidement un acteur ou une actrice.
* Menu de Partage : Un menu de partage intégré dans la Toolbar permet de partager l’application sur différentes plateformes comme Gmail ou WhatsApp.
* Modification de la Note : Au clic sur un élément de la liste, un popup personnalisé s’affiche et permet de modifier la note d’un acteur ou d’une actrice en temps réel.
* Mise à Jour Dynamique : Une mise à jour de la liste est effectuée après chaque modification grâce à la méthode notifyItemChanged().
* Architecture Organisée : Le projet adopte une architecture propre et réutilisable basée sur le modèle MVC, avec des couches bien séparées comme DAO, Service et Adapter.
* Maîtrise des Composants Android : Le projet illustre l’utilisation de composants Android modernes, la gestion du cycle de vie et l’interaction entre la logique métier et l’interface graphique.

## Technologies Utilisées
- Java
- Android Studio
- XML
- RecyclerView
- SearchView
- Gradle

## Installation et Test
```bash
git clone https://github.com/mouad-charraj/android_java_lab7.git
