# Fiche 1

Système:  Classificator  
Cas d'utilisation:  **Importer des données**  
Acteur principal:  Utilisateur  
Préconditions:  .....  
Garantie en cas de succès:  Les données sont ajoutées dans l'application.  
Garantie minimale:  Les données sont chargées si et seulement si le fichier CSV est valide.

 Scénario nominal: 

1. L'utilisateur sélectionne la fonctionnalité "Importer les données d'un CSV".
2. Le système affiche un formulaire contenant un champ "Choisir le fichier CSV".
3. L'utilisateur renseigne le fichier CSV qu'il souhaite.
4. Le système vérifie la validité du CSV, importe les données et affiche un nuage de points vide.

 Scénario alternatifs: 

Etape 4 --> si le fichier CSV n'est pas valide, alors:
* 4A: Le système informe à l'utilisateur que le fichier est invalide.
* 4B: On retourne à l'étape 2 du scénario nominal


# Fiche 2

Système:  Classificator  
Cas d'utilisation:  **Choisir/changer les options**  
Acteur principal:  L'utilisateur  
Acteur secondaire:  Système 
Préconditions:  Les données doivent être chargées.  
Garantie en cas de succès:  Apporte les modifications selon les critères choisis.

Scénario nominal: 
  
1) L'utilisateur choisit les options de tri (k / abscisse / ordonnée).
2) Le système affiche un formulaire contenant les champs k / abscisse / ordonnée.
3) L'utilisateur choisis les valeurs parmis celles proposées.
4) Le système re-calcule les données et le nuage de points avec les nouvelles options et l'affiche.


# Fiche 3

Système:  Classificator  
Cas d'utilisation:  **Ajouter un élément directement aux données**  
Acteur principal:  Utilisateur   
Préconditions:  Le fichier de données est chargé et valide  
Garantie en cas de succès: l'élement apparait avec les autres.  
Garantie minimale:  L'élément est ajouté au nuage de points si et seulement si les nouvelles données ajoutées sont valides.  

Scénario nominal: 

1. L'Utilisateur choisis la fonction "Ajouter une nouvelle donnée"
2. Le système affiche un formulaire contenant les champs nécessaires.
3. L'Utilisateur renseigne les informations et valide.
4. Le système demande une confirmation pour éviter les erreurs.
5. L'utilisateur valide.
6. Le système ajoute l'élement, re-calcule et affiche le modèle.

Scénario alternatifs:  
A:  L'utilisateur ne valide pas
* 5A : L'utilisateur ne confirme pas la création du nouvel élément
* 5A: Le système renvoit à l'étape 2 avec les champs déja remplis.


# Fiche 4

Système:  Classificator  
Cas d'utilisation:  **Afficher les caractéristiques d'un point**  
Acteur principal:  Utilisateur  
Préconditions:  Le nuage de point est affiché  
Garantie en cas de succès:  Pouvoir consulter les données de chaque élément.  

Scénario nominal: 

1. L'utilisateur séléctionne un des points
2. Le système affiche toutes les données correspondantes à ce point.



# Fiche 5

Système:  Classificator  
Cas d'utilisation:  **Consulter les données en nuage de point**  
Acteur principal:  Utilisateur  
Préconditions:  Les données sont triés et les options choisis.  
Garantie en cas de succès:  Pouvoir avoir une vue d'ensemble des differents elements.

Scénario nominal: 

1. L'utilisateur va dans la partie "Consultation des données".
1. Le système affiche les données en nuage de points.
2. L'utilisateur peut consulter les données.


# Fiche 6

Système:  Classificator  
Cas d'utilisation:  **Trier les données**  
Acteur principal:  Le systeme  
Préconditions:  Le fichier de données est chargé et valide, les options sont choisis.  
Garantie en cas de succès:  Les données sont triés.  

Scénario nominal: 

1. Le système fait un tri selon les données et les options.


# Fiche 7

Système:  Classificator  
Cas d'utilisation:  **Trouver les élements les plus proche**  
Acteur principal:  Utilisateur  
Préconditions:  Les données sont triés  
Garantie en cas de succès:  Avoir les éléments les plus proches.  

Scénario nominal: 

1. Le système trouve via l'algorithme les k éléments les plus proches (k fournit pas l'utilisateur).