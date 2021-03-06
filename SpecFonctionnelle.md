**Spécifications fonctionnelles**
======

#### Cadrage du projet

L’application Let’s Plan s’inscrit dans un contexte d’organisation d'événements par ses utilisateurs qu’ils soient professionnels ou particuliers. Il s’agit dans notre application de proposer une solution qui soit efficace et simple d’utilisation de manière à ce que la navigation de nos utilisateurs soit la plus agréable possible.

## Fonctionnalités

Quand un utilisateur arrive sur le site, il a 2 boutons : un bouton pour se connecter, et un pour s’inscrire. 
Pour se connecter, un utilisateur doit remplir un formulaire, avec 2 champs : son username et son mot de passe.

Dans tous les formulaires, les alertes préviennent de l’utilisateur de l’erreur. 

Pour s’inscrire, un utilisateur doit également remplir un formulaire avec plusieurs champs : un username, un mot de passe, la confirmation du mot de passe, un mail valide, un nom et un prénom. 
> Tous ces champs doivent être remplis. Le mot de passe et la confirmation du mot de passe doivent être identique, sinon une alerte est lancé. Le mail entré est contrôlé par une expression régulière. S’il n’est pas valide, une alerte est lancé. 

Ensuite, quand un utilisateur se connecte, il peut cliquer sur le bouton Événement. L’utilisateur doit remplir un formulaire : un libelle, la nature, une date (format AAAA-MM-JJ), une durée (un chiffre), le libellé du lieu, le numéro de rue, le nom de la rue, le nom et département de la ville, ainsi que le moyen de transport. Finalement, les logins des invités doivent être remplis(Jacques,Jean,le.minhtri230999@gmail.com). 
Si un invité n’a pas de compte, alors le mail de la personne peut être saisie, afin qu’un mail lui soit envoyé lui demandant de s’inscrire et de répondre à l'événement. Enfin, les invités qui ont un compte reçoivent un mail leur prévenant de l’invitation. 
> Les champs départements et numéros doivent être des numéros, sinon une alerte est lancé.


De plus, après qu’un utilisateur soit connecté, la liste de tous les événements dont il est invité est affiché. S’il clique sur un événement, un récapitulatif est affiché, avec tout les invité et leurs décisions. Enfin, l’utilisateur connecté peut changer sa décision, c’est à dire s’il vient ou pas à l'événement. Sa décision est mise à jour directement.  

#### Dictionnaire de données

| Nom                        | Description                            | Format                            | Commentaire             |
| -------------------------- | -------------------------------------- | --------------------------------- | ----------------------- |
|id                          | Id de l’utilisateur                    | Long                              | Généré automatiquement  |
|username                    | Username de l’utilisateur              | String                            |                         |
|nom                         | Nom de l’utilisateur                   | String                            |                         |
|prénom                      | Prénom de l’utilisateur                | String                            |                         |
|mail                        | Mail de l’utilisateur                  | String                            |                         |
|password                    | Mot de passe de l’utilisateur          | String                            |                         |
| -------------------------- | -------------------------------------- | --------------------------------- | ----------------------- |
|id                          | Id de l’evenement                      | Long                              | Généré automatiquement  |
|libelle                     | Libelle  de l’evenement                | String                            |                         |
|type                        | Type de l’evenement                    | String                            |                         |
|date                        | Date de l’evenement                    | Date                              |                         |
|duree                       | Duree de l’evenement                   | int                               |                         |
|transport                   | Moyen de transport de l’evenement      | String                            |                         |
| -------------------------- | -------------------------------------- | --------------------------------- | ----------------------- |
|id                          | Id du lieu                             | Long                              | Généré automatiquement  |
|libelle                     | Libelle du lieu                        | String                            |                         |
|numRue                      | Numéro de la rue                       | int                               |                         |
|rue                         | Nom de la rue                          | String                            |                         |
|ville                       | Nom de la ville                        | int                               |                         |
|departement                 | Département du lieu                    | int                               |                         |

Modèle de données
https://imgur.com/QB1olbE

Diagramme de cas d'utilisation
https://imgur.com/a/NMIEAtu


USER STORY

LOT 1 :
> En tant qu’utilisateur de l’application
> - Je veux pouvoir me connecter et me déconnecter de l’application
> - Afin de préserver ma vie privée
> - Vérifier disponibilitées d’un groupe

> En tant qu’utilisateur de l’application
> - Je veux vérifier les disponibilitées d’un groupe
> - Afin d’organiser une sortie entre amis
> - Choisir la durée estimée de l’évènement

> En tant qu’utilisateur de l’application
> - Je veux choisir la durée estimée de l’évènement
> - Afin de pouvoir me synchroniser avec mes amis
> - Ajouter des amis à son événement

> En tant qu’utilisateur de l’application
> - Je veux ajouter des amis à mon évènement
> - Afin d’organiser une sortie à plusieurs
> - Mettre un type à l'événement

> En tant qu’utilisateur de l’application
> - Je veux mettre un type à un évènement
> - Afin d’en informer la nature pour le groupe d’amis
> - Moyen de transport

> En tant qu’utilisateur de l’application
> - Je veux obtenir des informations sur la manière de me rendre sur le lieu de
ma sortie
> - Afin de me rendre plus facilement sur le lieu du rendez-vous et de pouvoir
choisir le moyen de transport le plus adapté

LOT 2 :

> En tant qu’utilisateur de l’application
> - Je veux pouvoir renseigner les heures d’arrivée et de départ
> - Afin de trouver un horaire qui convient au mieux
> - Changement de l’apparence en fonction de l'événement (thème
prédéfini)

> En tant qu’utilisateur de l’application
> - Je veux pouvoir changer le thème de l’application
> - Afin que ce soit plus beau
> En tant qu’utilisateur de l’application
> - Je veux que l’application envoie des mails automatiquement
> - Afin de faire un récapitulatif et rappeler la veille de l’évènement
> - Partenariats avec bars et restaurants avec réservation prise en
compte

> En tant qu’utilisateur de l’application
> - Je veux pouvoir réserver dans des restaurants et bar grâce à des
partenariats
> - Afin d’avoir de mettre en avant les partenaires de l’application
> - Mettre le lieu sur une carte

> En tant qu’utilisateur de l’application
> - Je veux pouvoir mettre le lieu de rencontre sur une carte
> - Afin d’avoir une meilleur vision de sa localisation
> - Mettre un lien qui renvoie vers l’itinéraire Google Maps

> En tant qu’utilisateur de l’application
> - Je veux pouvoir mettre un lien qui renvoie vers l’itinéraire Google Maps
> - Afin de pouvoir voir toutes les informations sur le trajet
> - Possibilité de proposer une nouvelle horaire

> En tant qu’utilisateur de l’application
> - Je veux proposer une nouvelle horaire
> - Afin de décaler le rdv
LOT 3 :
> En tant qu’utilisateur de l’application
> - Je veux pouvoir me connecter grâce à Facebook et Google
> - Afin que ce soit plus rapide
