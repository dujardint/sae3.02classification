# Fiche 1

Système:  Classificator
Cas d'utilisation:  Importer des données
Acteur principal:  Utilisateur
Préconditions:  .....
Garantie en cas de succès:  Le données sont ajouter dans l'application.
Garantie minimale:  Les données sont chargé si et seulement si le fichier CSV est valide.

 Scénario nominal: 

1. L'utilisateur sélectionne la fonctionnalité "Importer les données d'un CSV"
2. Le système affiche un formulaire contenant un champs "Choisir le fichier CSV"
3. L'utilisateur renseigne le fichier CSV qu'il souhaite
4. Le système vérifie la validité du CSV, importe les données et affiche un nuage de points vide.

 Scénario alternatifs: 

Etape 4 --> si le fichier CSV n'est pas valides, alors:
* 4A: Le système informe a l'utilisateur que le fichier est invalide
* 4B: On retourne à l'étape 2 du scénario nominal

# ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

# Fiche 2

Système:  Classificator
Cas d'utilisation:  Choisir/changer les options
Acteur principal:  L'utilisateur
Préconditions:  Les données doivent être chargé
Garantie en cas de succès:  apporte les modifications selon les critères choisis.

Scénario nominal: 
  
1) L'utilisateur choisit de changer les options(k / abscisse / ordonnée)
2) Le système affiche un formulaire contenant les champs k / abscisse / ordonnée
3) L'utilisateur choisis les valeurs parmis celles proposées.
4) Le système re-calcule les données et le nuage de points avec les nouvelles options et l'affiche.

# ------------------------------------------------------------------------------------------------

# Fiche 3

Système:  Classificator
Cas d'utilisation:  Ajouter un élément directement aux données
Acteur principal:  Utilisateur
Acteur secondaire:  Système
Préconditions:  Le csv est chargé et valide
Garantie en cas de succès: l'élement apparait avec les autres
Garantie minimale:  Changer les nuage de point si et seulement si les nouvelles données ajoutées sont valides.

Scénario nominal: 

1. L'Utilisateur choisis la fonction "Ajouter une nouvelle donnée"
2. Le système affiche un formulaire contenant les champs nécessaires.
3. L'Utilisateur renseigne les informations et valide.
4. Le système demande une confirmation pour eviter les erreurs.
5. L'utilisateur valide.
6. Le système ajoute l'élement re-calcule et affiche le modele.

Scénario alternatifs: 
A:  L'utilisateur ne valide pas
* 5B : L'utilisateur ne confirme pas la création du nouvel élément
* 5B: Le système renvoit à l'étape 2 avec les champs déja remplis.

# ------------------------------------------------------------------------------------------------

# Fiche 4

Système:  Classificator
Cas d'utilisation:  Consulter les données
Acteur principal:  Utilisateur
Préconditions:  Le nuage de point est affiché
Garantie en cas de succès:  Pouvoir consulter les données de chaque éléments

Scénario nominal: 

1. L'utilisateur séléctionne un des points
2. Le système affiche toutes les données correspondantes a ce point.
