## Rapport de conception du projet de programmation orientée objet


Licence d’informatique – 2ème année
Faculté des sciences et techniques de Nantes

# Dice Dungeon

présenté par
- CADIOT Dorian
- LE CAP Nathanaël
- M'BAYE Samba
- MERLET Raphaël
- MORINEAU Ludovic


le 24/10/2023

encadré par

Christophe Lino

## Cahier des charges : 

Le but du projet est de créer un jeu vidéo fonctionnel, jouable dans la console dont le genre se situe entre le jeu de rôle sur table et le roguelike. Il devra si possible avoir une bonne prise en main et donc être agréable. 
Les différentes interactions possibles avec le jeu devront être de pouvoir lancer une partie, via un menu. Ce dernier devra également permettre au joueur de changer la difficulté de sa ou ses prochaines parties. Dans celles-ci, il devra être capable d'explorer un donjon composé de salles contenant différents évenements parmis lequels se trouvent des combats, ainsi qu'un magasin ou marchand. Afin de progresser dans le jeu, le joueur aura l'opportunité de faire plusieurs parties pour obtenir des bonus sur le long terme. Ces derniers combinés aux objets équipables ou non qu'il récupèrera lui permettront d'aller de plus en plus loin. 


## Architecture : 

### Description générale :


- Un Account contient des stats, un inventory.
- Une Game contient des Rooms
- Une Room contient  des Events
- Une Room possède une difficulté
- Un Event est soit un Fight soit un Finding, soit une Escape
- Une Entity est soit un Monster soit un Character
- Une Entity contient des hp, une attackDamage, defense
- Un Monster possède un type
- Un Character possède un name
- Un Item est soit un Consommable soit un Equipable
- Un Consommable possède des stats instantanées et sont à utilisation unique
- Un Equipment possède des stats à long termes 

### Interfaces:

Pour notre projet, nous avons décidé d'interagir avec l'utilisateur via la console. L'interface console devra donc permettre la progression du joueur dans le donjon. On aura donc accès à une représentation graphique de la salle parcourue: cela incluera les combats(monstres et attributs associés), les marchands(produits vendus, possibilité de rachats), les sorties de salles et les coffres et leur contenu. En bas de la console, il y aura les attributs du joueur et les actions possibles sous forme de liste à choix comme par exemple l'accès à l'inventaire ou les actions de combats.

### Aspects spécifiques : 

Parmis les fonctions particulières à programmer, il y en aura une permettant de faire une sauvegarde d'un compte joueur en enregistrant l'avancée dans un fichier texte que l'on pourra importer dans le jeu plus tard pour reprendre notre progression. Il y aura aussi la gestion de l'interface qui sera un peu plus délicate à coder que le reste.




