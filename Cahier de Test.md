Tests Unitaires

OK : effectif
KO : non effectif

Connexion : 

| N°     | Action                                                       |Attendu                           |Résultat|
| ------ | ------------------------------------------------------------ |----------------------------------|--------|
|   1    |Aller sur le site et cliquer sur le bouton “Connexion”        |Ouverture de la page de connexion |   OK   |
|   2    |Entrer login invalide                                         |Message d’erreur                  |   OK   |
|   3    |Entrer un login sans compte actif                             |Message d’erreur                  |   OK   |
|   4    |Entrer login actif sans mdp                                   |Message d’erreur                  |   OK   |
|   5    |Entrer login et mdp valide                                    |Connexion à l’application         |   OK   |
 
 
 
 Déconnexion : 
 
 
| N°     | Action                                                       |Attendu                           |Résultat|
| ------ | ------------------------------------------------------------ |----------------------------------|--------|
|   1    |Cliquer sur le bouton “Déconnexion”                           |Retour sur la page de connexion   |   OK   |


Inscription :

| N°     | Action                                                       |Attendu                                                |      Résultat     |
| ------ | ------------------------------------------------------------ |-------------------------------------------------------|-------------------|
|   1    |Aller sur le site et cliquer sur le bouton “Inscription”      |Ouverture de la page d’inscription                     |   OK              |
|   2    |Entrer adresse mail invalide                                  |Message d’erreur                                       |   OK              |
|   3    |Ne pas renseigner un des champs obligatoires                  |Message d’erreur                                       |   OK              |
|   4    |Entrer une adresse mail active                                |Message d’erreur                                       |   OK              |
|   5    |Confirmation erronée du mdp                                   |Message d’erreur                                       |   OK              |
|   6    |Entrer tous les champs correctement                           |Inscription à l’application et + connexion automatique | partiellement OK  |


Créer un évènement :

| N°     | Action                                                       |Attendu                              |      Résultat       |
| ------ | ------------------------------------------------------------ |-------------------------------------|---------------------|
|   1    |Renseigner une nature de l’évènement                          |Nature de l’évènement                |   OK                |
|   2    |Définir un créneau horaire                                    |Créneau défini                       |   KO                |
|   3    |Ajouter les membres                                           |Membres ajoutés à l'évènement        |Partiellement   OK   |
|   4    |Validation de la création                                     |Mail d’invitation envoyé aux membres |   OK                |



Supprimer un membre suite à son refus de participation à l’évènement :

| N°     | Action                                                       |Attendu                           |Résultat|
| ------ | ------------------------------------------------------------ |----------------------------------|--------|
|   1    |Consulter réponse à l’invitation                              |Invitation refusée                |   KO   |
|   2    |Retirer le membre de la liste des membres de l’évènement      |Membre grisé dans la liste        |   KO   |
|   3    |Cliquer sur valider                                           |membre supprimé                   |   KO   |
