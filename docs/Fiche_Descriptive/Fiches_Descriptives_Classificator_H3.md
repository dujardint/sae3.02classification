# Fiche 1

Système:  Classificator  
Cas d'utilisation:  **Importer des données**  
Acteur principal:  Utilisateur  
Préconditions:  .....  
Garanties en cas de succès:  les données sont ajoutées dans l'application.  
Garantie minimale:  les données sont chargées si et seulement si le fichier CSV est valide.

 Scénario nominal: 

1. l'utilisateur sélectionne la fonctionnalité "Importer les données d'un CSV".
2. Le système affiche un formulaire contenant un champ "Choisir le fichier CSV".
3. L'utilisateur renseigne le fichier CSV qu'il souhaite.
4. Le système vérifie la validité du CSV, importe les données et affiche un nuage de points vide.

 Scénario alternatifs: 

A) Etape 4 --> si le fichier CSV n'est pas valide, alors:
* 4A: Le système informe à l'utilisateur que le fichier est invalide.
* 5A: On retourne à l'étape 2 du scénario nominal

B) Etape 4 --> si le fichier CSV n'est pas trouvé
* 4B: Le système informe à l'utilisateur que le fichier csv n'est pas trouvé
* 5B: On retourne à l'étape 2 du scénario nominal

C) Etape 4 --> si le fichier CSV est déjà chargé
* 4C: Le système informe à l'utilisateur que le fichier csv est déjà chargé
* 5C: On retourne à l'étape 2 du scénario nominal

# Fiche 2

Système:  Classificator  
Cas d'utilisation:  **Choisir/changer les options**  
Acteur principal:  L'utilisateur  
Préconditions:  les données doivent être chargées.  
Garantie en cas de succès:  apporte les modifications selon les critères choisis.

Scénario nominal: 
  
1) l'utilisateur choisit les options de tri abscisse / ordonnée).
2) Le système affiche un formulaire contenant les champs abscisse / ordonnée.
3) L'utilisateur choisit les valeurs parmi celles proposées.
4) Le système recalcule les données et le nuage de points avec les nouvelles options.


# Fiche 3

Système:  Classificator  
Cas d'utilisation:  **Saisir une nouvelle donnée**  
Acteur principal:  Utilisateur   
Préconditions:  le fichier de données est chargé et valide  
Garanti en cas de succès: l'Élément apparaît avec les autres.  
Garantie minimale:  L'élément est ajouté au nuage de points si et seulement si les nouvelles données ajoutées sont valides. 

Scénario nominal: 

1. L'utilisateur choisit la fonction "Ajouter une nouvelle donnée"
2. Le système affiche un formulaire contenant les champs nécessaires.
3. L'utilisateur renseigne les informations et valide.
4. Le système demande une confirmation pour éviter les erreurs.
5. L'utilisateur valide.
6. Le système ajoute l'Élément, recalcule et affiche le modèle.

Scénario alternatif:  
A:  L'utilisateur ne valide pas
* 5A : L'utilisateur ne confirme pas la création du nouvel élément
* 6A: Le système renvoit a l'étape 2 avec les champs déjà remplis.


# Fiche 4

Système:  Classificator  
Cas d'utilisation:  **Consulter les caractéristiques d'un point**  
Acteur principal:  Utilisateur  
Préconditions:  le nuage de point est affiché  
Garantie en cas de succès:  pouvoir consulter les données de chaque élément.  

Scénario nominal: 

1. l'utilisateur sélectionne un des points
2. Le système affiche toutes les données correspondantes à ce point.



# Fiche 5

Système:  Classificator  
Cas d'utilisation:  **Consulter les données en nuage de point**  
Acteur principal:  Utilisateur  
Préconditions:  les données sont chargées et valides  
Garantie en cas de succès:  Pouvoir avoir une vue d'ensemble des différents éléments.

Scénario nominal: 

1. l'utilisateur va dans la partie "Consultation des données".
1. Le système affiche les données en nuage de points.
2. L'utilisateur peut consulter les données.


# Fiche 6

Système:  Classificator  
Cas d'utilisation:  **Classifier les données**  
Acteur principal:  Le système 
Acteur secondaire: L'Utilisateur
Préconditions:  Le fichier de données est chargé et valide, les options sont choisis.  
Garantie en cas de succès:  Les données sont classifiées.  

Scénario nominal: 

1) L'utilisateur choisit l'option "Classifier les données".
2) Le système affiche un formulaire contenant le champ " k ".
3) L'utilisateur choisit une valeur parmi celles proposées.
4) Le système trouve via l'algorithme les k éléments les plus proches et effectue une classification.


 # Fiche 7

Système:  Classificator  
Cas d'utilisation:  **Accéder au calcul de la robustesse**  
Acteur principal:  Utilisateur 
Préconditions:  le fichier de données est chargé et valide, les données sont classifiées.  
Garanti en cas de succès:  L'utilisateur a connaissance de la robustesse.  

Scénario nominal:

 1) l'utilisateur choisit l'option "Calculer la robustesse".
 2) Le système calcule la robustesse.