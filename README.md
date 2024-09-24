# Évaluation E1 BrawlStar

## Objectifs

 Dans le cadre d'une application réaliste en Java, vous prouvez votre maîtrise des différents sujets du module 320.

 Objectifs spécifiques:

- Comprendre l'utilité et les fonctionnalités de l'application présentée.
- Comprendre et respecter l'architecture MVC.
- Implémenter en utilisant les principes POO (interface, héritage, ...)
- Compléter le code manquant en se basant sur les schémas UML et la Javadoc fournis.
- Résoudre des problématiques de tri et d'indexation grâce aux structures de données dynamiques.
- Documenter certaines parties du code avec la Javadoc.
- Tester l'application avec des tests unitaires.

## Durée

- **210'** (La demi-journée) 

## Fonctionnalités de l'application

L'application "BrawlStar Database" est une application demandée par un groupe de joueurs passionnés pour améliorer leur utilisation des différents brawler dans le jeu mobile Brawl Stars.

Le jeu BrawlStar est un jeu mobile joueur contre joueur ou équipe contre équipe dans lequel le joueur incarne un "Brawler" (Personnage dans le jeu) pour combattre les autres personnages. Des événements sont aussi organisés dans le jeu et des statistiques par événements pour chaque brawler sont tenues, tels que le taux de victoire du brawler et le taux d'utilisation de ce brawler.


<img src="ressourcesDonnee/application.png" width="800">

Pour commencer à utiliser l'application, il faut cliquer sur le bouton "Importer" qui permettra à l'application de lire les fichiers JSON contenant les différentes informations du jeu. Cette action active le bouton `Indexer`.

Quand l'utilisateur clique sur le bouton `Indexer`, les données sont traitées pour être préparées à répondre rapidement aux 5 questions liées aux différents boutons sur la zone de droite. C'est aussi à ce moment que la liste déroulante du "Rapido4" est remplie avec toutes les raretés des brawlers.

### 0) Nombre d'éléments de jeu qui ont été importés et indexés 
Doit donner le nombre d'éléments de jeu qui ont été importé et indexé.
```console
95
```
### 1) Lister tous les brawlers
Doit produire la liste de tous les brawlers qui ont été importés dans l'application. Cette liste est triée par rareté (id de la rareté) puis par le nom du brawler
```console
Shelly (C) 
Barley (R) 
Brock (R) 
Bull (R) 
Colt (R) 
El Primo (R) 
Nita (R) 
Poco (R) 
Rosa (R) 
8-Bit (S) 
Carl (S) 
.
.
.
Leon (L) 
Meg (L) 
Sandy (L) 
Spike (L) 
Surge (L) 
```
### 2) Lister toutes les classes
Chaque brawler est défini par une classe. Il faut lister toutes les classes présentes sans doublons, par ordre alphabétique.
```console
Artillery
Assassin
Controller
Damage Dealer
Marksman
Support
Tank
```
### 3) Lister tous les events
Des évènements sont aussi importés dans l'application. Il faut les lister dans l'ordre chronologique de la date de départ de l'événement.
```console
Daily Trophy Modes début le : 	02/06/2024 (16:00)
Daily Trophy Modes début le : 	02/06/2024 (16:00)
Daily Showdown début le : 	    02/06/2024 (22:00)
Daily Showdown début le : 	    02/06/2024 (22:00)
Daily Brawl Ball début le : 	03/06/2024 (04:00)
Daily Gem Grab début le : 	    03/06/2024 (10:00)
Daily Special Mode début le : 	03/06/2024 (10:00)
Daily Basket Brawl début le : 	03/06/2024 (10:00)
Daily Trophy Modes début le : 	03/06/2024 (16:00)
Daily Trophy Modes début le : 	03/06/2024 (16:00)
Daily Showdown début le : 	    03/06/2024 (22:00)
Daily Showdown début le : 	    03/06/2024 (22:00)
Daily Brawl Ball début le : 	04/06/2024 (04:00)
Daily Special Mode début le : 	04/06/2024 (10:00)
Daily Gem Grab début le : 	    04/06/2024 (10:00)
```

### 4) Lister les brawlers en fonction de la rareté
Il faut produire la liste des brawlers, mais uniquement ceux de la rareté sélectionnée dans la liste déroulante, dans l'ordre alphabétique.

Sortie de la console si la rareté `Legendary` est sélectionnée:
```console
Amber (L) 
Chester (L) 
Cordelius (L) 
Crow (L) 
Draco (L) 
Kit (L) 
Leon (L) 
Meg (L) 
Sandy (L) 
Spike (L) 
Surge (L) 
```

### 5) Nombre d'évènements par mode de jeu
Chaque évènment a un mode de jeu, il faut donc retourner le nombre d'évènement par mode de jeu, dans l'ordre du plus petit nombre au plus grand uniquement.
```console
1 événement(s) pour le mode : Heist
1 événement(s) pour le mode : Hot Zone
1 événement(s) pour le mode : Knockout
1 événement(s) pour le mode : Wipeout
2 événement(s) pour le mode : Duo Showdown
2 événement(s) pour le mode : Gem Grab
2 événement(s) pour le mode : Knockout 5v5
2 événement(s) pour le mode : Solo Showdown
3 événement(s) pour le mode : Brawl Ball
```

## Organisation de votre travail

Vous devez en premier lieu bien comprendre le contexte de l'application et les fonctionnalités. 

Ensuite, à l'aide de la documentation ci-dessous, du code et de la Javadoc fournis, **vous identifiez quelle partie du code vous devez produire afin d'offrir à l'utilisateur toutes ces fonctionnalités**

Le choix de l'ordre dans lequel vous effectuerez votre travail fait partie de vos compétences. Cependant, afin vous aider, nous vous fournissons une proposition chronologique du travail à effectuer, à la fin de ce document.

N'oubliez pas les points concernant la Javadoc et les tests à la fin de ce document.

Essayez néanmoins d'obtenir rapidement une application compilable, afin de pouvoir ensuite travailler pas à pas.

Toute la partie qui concerne directement l'affichage (view.fxml et view.java) est déjà réalisée et ne doit pas être modifiée.

## Architecture du projet (packages)

Pour savoir où créer les classes du projet, voici une vue d'ensemble des packages du projet Java et de leur contenu :

```mermaid
classDiagram
namespace app {
    class Application
}
namespace ctrl {
    class Controller
    class IControllerForView{ <<interface>> }
}

namespace views {
    class View
    class IViewForController{ <<interface>> }
}
namespace models {
    class Brawler
    class ElementDeJeu
    class Evenement
    class Rarete
    class Statistique
  
}
namespace services {

    class ServiceDate
    class ServiceImportation
    class ServiceIndexation
}
```

## Vue d'ensemble UML des classes du projet - le pattern MVC

```mermaid
classDiagram

    class Application {
        +main(String[] args)$ void
    }

    class Controller {
        -view : IViewForController
        -serviceImportation : ServiceImportation
        -serviceIndexation : ServiceIndexation
        -elementsDeJeu : List < ElementDeJeu >

        +Controller()
        +start() void
        +importation() void
        +indexer() void
        +onRapido0Click() void
        +onRapido1Click() void
        +onRapido2Click() void
        +onRapido3Click() void
        +getRapido4List() List< Rarete >
        +onRapido4Click(Rarete rarete) void
        +onRapido5Click() void

    }

    note for View "Note: cette classe est fournie et ne dois pas être modifiée.
        aucun detail n'est montré ici"

    class View {
      
    }

    class IControllerForView {
        <<interface>>
        start() void
        importation() void
        indexer() void
        onRapido1Click() void
        onRapido2Click() void
        onRapido3Click() void
        getRapido4List() List< Rarete >
        onRapido4Click(Rarete rarete) void
        onRapido5Click() void
    }

    class IViewForController {
        <<interface>>
        start() void
        afficheRapport(String message)
    }

    View ..|> Initializable : "implements"
    
    Controller o--> "1" IViewForController : view
    View o--> "1" IControllerForView : controller
    View ..|> IViewForController : "implements"
    Controller ..|> IControllerForView : "implements"

    Application ..> Controller : "utilise"
```

## Détail des classes du projet


### Service des date

Vous devez compléter les méthodes du service ci-dessous à l'aide du chapitre Javadoc ci-dessous.

```mermaid
classDiagram

    class ServiceDate  {
        - simpleDateFormat : SimpleDateFormat
        + ServiceDate()
        + formaterDate(Date date) String
    }

```

Ce service est utilisé par la classe "Evenement" pour afficher la date de départ correctement.


### Service d'importation

Ce service est fourni et vous n'avez aucune modification à y apporter.

```mermaid
classDiagram



    class ServiceImportation   {
        
        + ServiceImportation()
        + importerBrawlers() List < Brawler >
        + importerEvenements() List < Evenement >
    }


```

### Service d'indexation

Vous devez compléter les méthodes du service ci-dessous à l'aide de la Javadoc fournie.

```mermaid
classDiagram


    class ServiceIndexation    {
        +ServiceIndexation()
        +avantIndexation() void
        +indexation(List < ElementDeJeu > elements) void
        +apresIndexation() void 
        +rapido0_NombreElements() : int
        +rapido1_ListeBrawlers() List < Brawler >
        +rapido2_ListeDesClasses() List < String >
        +rapido3_TousLesEvenements() List < Evenement >
        +getRapido4List_RareteDuBrawler() List < Rarete >
        +rapido4_brawlerParRarete(String nomDeLaRarete) List < Brawler >
        +rapido5_NombreEvenementParModeDeJeu() List < String >
    }

```


### Les models

Voici le diagramme des classes des différentes classes présentes dans le package models.
Pour ce qui est de l'implémentation des différentes méthodes, veuillez vous référer à la Javadoc.

```mermaid
classDiagram


    class Brawler {
        -rarete : Rarete
        -classe : String

        +Brawler(int id, String nom, Rarete rarete, String classe)
        +getRarete() Rarete
        +getClasse() String
        +compareTo(Brawler brawler) int
        +toString() String
    }

    class ElementDeJeu {
        -id : int 
        -nom :String

        +ElementDeJeu(int id, String nom)
        +getId() int
        +getNom() String
    }

    class Evenement{
        -dateDebut : Date
        -dateFin : Date
        -serviceDate : ServiceDate
        -statistiques : ArrayList < Statistique >
        -modeDeJeu : String

        +Evenement(int id, String nom, Date dateDebut, Date dateFin, ArrayList < Statistique > statistiques, String modeDeJeu, ServiceDate serviceDate)
        +getDateDebut() Date
        +getDateFin() Date
        +getStatistiques() ArrayList < Statistique >
        +getModeDeJeu() String
        +compareTo(Evenement evenement) int
        +toString() String
    }

    class Rarete {
        +Rarete(int id, String nom)
        +compareTo(Rarete rarete) int
        +toString() String
    }

    class Statistique {
        -brawlerId : int
        -pourcentDeVictoire : double
        -pourcentDUtilisation : double

        +Statistique(int brawlerId, double pourcentDeVictoire, double pourcentDUtilisation)
        +getBrawlerId() int
        +getPourcentDeVictoire() : double
        +getPourcentDUtilisation() : double
    }

    class Comparable{
        <<Interface>>
    }

    Brawler --|> ElementDeJeu
    Evenement --|> ElementDeJeu
    Rarete --|> ElementDeJeu
    Evenement o--> Statistique : 1..N

    Brawler ..|> Comparable
    Evenement ..|> Comparable
    Rarete ..|> Comparable

```


### Détail de la classe `Application`

Voici les indications manquantes qui vous permettront de terminer l'implémentation de cette classe :

#### Méthode `main()`

```mermaid
sequenceDiagram
    create participant Controller
    main()->>Controller: <<creation>>
    main()->>+Controller: start()
    Controller-->>-main(): 
```

### Détail de la classe `Controller`

#### Constructeur
```mermaid
sequenceDiagram

    create participant View
    Controller->>View: new View(this)

    create participant ServiceImportation
    Controller->>ServiceImportation: new ServiceImportation()

    create participant ServiceIndexation
    Controller->>ServiceIndexation: new ServiceIndexation()

    create participant List
    Controller->>List: new List < ElementDeJeu >
```

#### Méthode `start()`

```mermaid
sequenceDiagram
    start()->>+view: start()
    view-->>-start(): 

```

#### Méthode `importation()`

```mermaid
sequenceDiagram
    importation()->>+elementsDeJeu:clear()
    elementsDeJeu-->-importation():void
    importation()->>+serviceImportation:importerBrawlers()
    serviceImportation-->>-importation():brawlers
    importation()->>+elementsDeJeu:addAll(brawlers)
    importation()->>+serviceImportation:importerEvenements()
    serviceImportation-->>-importation():evenements
    importation()->>+elementsDeJeu:addAll(evenements)

```

#### Méthode `indexer()`
```mermaid
sequenceDiagram
    indexer()->>+serviceIndexation:avantIndexation()
    serviceIndexation-->>-indexer(): 

    indexer()->>+serviceIndexation:indexation(elementsDeJeu)
    serviceIndexation-->>-indexer(): 

    indexer()->>+serviceIndexation:apresIndexation()
    serviceIndexation-->>-indexer(): 
```

#### Méthode `onRapido1Click()`
```mermaid
sequenceDiagram
    onRapido1Click()->>+serviceIndexation:rapido1_ListeBrawlers()
    serviceIndexation-->>-onRapido1Click(): brawlers

    onRapido1Click()->>onRapido1Click():String rapport = "";

    loop brawler in brawlers
        onRapido1Click()->>onRapido1Click():rapport += brawler + "\n"
    end

    onRapido1Click()->>+view:afficheRapport(rapport)
```

#### Méthode `onRapido2Click()`
```mermaid
sequenceDiagram
    onRapido2Click()->>+serviceIndexation:rapido2_ListeDesClasses()
    serviceIndexation-->>-onRapido2Click(): classes

    onRapido2Click()->>onRapido2Click():String rapport = "";

    loop classe in classes
        onRapido2Click()->>onRapido2Click():rapport += classe + "\n"
    end

    onRapido2Click()->>+view:afficheRapport(rapport)
```

#### Méthode `onRapido3Click()`
```mermaid
sequenceDiagram
    onRapido3Click()->>+serviceIndexation:rapido3_TousLesEvenements()
    serviceIndexation-->>-onRapido3Click(): evenements

    onRapido3Click()->>onRapido3Click():String rapport = "";

    loop evenement in evenements
        onRapido3Click()->>onRapido3Click():rapport += evenement + "\n"
    end

    onRapido3Click()->>+view:afficheRapport(rapport)
```

#### Méthode `getRapido4List()`
```mermaid
sequenceDiagram
    getRapido4List()->>+serviceIndexation:getRapido4List_RareteDuBrawler()
    serviceIndexation-->>-getRapido4List(): raretes

```

#### Méthode `onRapido4Click(Rarete rarete)`
```mermaid
sequenceDiagram
    onRapido4Click(Rarete rarete)->>+serviceIndexation:rapido4_brawlerParRarete(rarete.getNom())
    serviceIndexation-->>-onRapido4Click(Rarete rarete): brawlerDeLaRarete

    onRapido4Click(Rarete rarete)->>onRapido4Click(Rarete rarete):String rapport = "";

    loop brawlerDeLaRarete in brawlersDeLaRarete
        onRapido4Click(Rarete rarete)->>onRapido4Click(Rarete rarete):rapport += brawlerDeLaRarete + "\n"
    end

    onRapido4Click(Rarete rarete)->>+view:afficheRapport(rapport)
```

#### Méthode `onRapido5Click()`
```mermaid
sequenceDiagram
    onRapido5Click()->>+serviceIndexation:rapido5_NombreEvenementParModeDeJeu()
    serviceIndexation-->>-onRapido5Click(): eventsParMode

    onRapido5Click()->>onRapido5Click():String eventParModeString = "";

    loop eventParMode in eventsParMode
        onRapido5Click()->>onRapido5Click():eventParModeString += eventParMode + "\n"
    end

    onRapido5Click()->>+view:afficheRapport(eventParModeString)
```

## Javadoc

Le service `ServiceDate` possède une méthode `formaterDate` en plus de son constructeur.

Vous devez transformer le cahier des charges ci-dessous en Javadoc.

Voici le cahier des charge de cette méthode : 

Le constructeur doit initialiser les attributs de la classe. Et le pattern du formatage doit y être défini.

Le formatage de la date doit être fait comme ceci :
Le jour et le mois séparés par un "/" et sur 2 caractères. L'année qui est sur 4 caractères est aussi séparée du jour et du mois par un "/". Il faut mettre les heures et les minutes sur 2 caractères et ils sont séparés par ":". L'heure et la date sont entre parenthèses.

La méthode `formaterDate` doit recevoir une `Date` en paramètres. Si celle-ci est null alors la méthode doit retourner une chaîne de characters vide; sinon, elle retourne la date formatée.

- Vous re-générez ensuite la Javadoc pour le projet complet.

## Tests unitaires

  -  Sur la base de votre Javadoc écrite selon le paragraphe précédent, vous codez la méthode  `formaterDate`.

   - Ensuite vous mettez en place un test unitaire, avec tous les pas de test nécessaires selon la théorie vue durant le module.
   - Vous exécutez ensuite ces tests unitaires et corrigez, si besoin, votre code en fonction des résultats des tests.
  

# Proposition chronologique des tâches à effectuer

Ceci est une proposition parmi d'autres solutions possibles.

-	Les classes du package models
-	Classe Controller
-	Classe Application pour coder la méthode main()
-	Les services, en terminant par le service d'indexation
-	Javadoc
-	Tests unitaires


# Critères d'évaluation

| Note | Explications |
| :----: | :---- |
| **1** | **`Pas rendu / tricherie`** |
| **2** | **`Loin d'être suffisant`**<br>Le travail rendu met en évidence de **nombreuses et profondes lacunes**. |
| **3** | **`Insuffisant`**<br>Le travail rendu met en évidence des **difficultés/lacunes qu'il faut encore résoudre** pour atteindre le minimum syndical. |
| **4** | **`Suffisant`**<br>Le travail rendu démontre que le **minimum requis est atteint** (compréhension et capacité de mise en œuvre correcte).<br>Le travail rendu démontre également qu'il subsiste un **manque d'aisance** et que **plusieurs petites et moins petites erreurs ont été commises**. |
| **5** | **`Bien`**<br>Le **travail rendu est bon** tant au niveau de la compréhension que capacité de mise en œuvre correcte.<br>**Trop de petites et moins petites erreurs ont cependant été commises**. |
| **6** | **`Très bien`**<br>Le **travail rendu est excellent** et de grande qualité tant au niveau de la compréhension que capacité de mise en œuvre correcte.<br>**BRAVO !!!** |