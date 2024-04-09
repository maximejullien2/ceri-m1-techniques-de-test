# UCE Génie Logiciel Avancé : Techniques de tests [![CircleCI](https://circleci.com/gh/maximejullien2/ceri-m1-techniques-de-test.svg?style=svg)](https://circleci.com/gh/maximejullien2/ceri-m1-techniques-de-test) [![codecov](https://codecov.io/gh/maximejullien2/ceri-m1-techniques-de-test/graph/badge.svg?token=TR544XN3QS)](https://codecov.io/gh/maximejullien2/ceri-m1-techniques-de-test) <p><img src="./checkstyle-result.svg"/></p>
# Maxime Jullien Groupe M1 IA-Cla

# Choix pour la création des classes qui implémentent les interfaces
Pour la classe Pokedex : 
- Il y aura une list de type List qui contiendra une list de Pokemon . Cette list nous servira à obtenir les pokemon par un comparator.
- Nous aurons aussi un IPokemonMetadataProvider et IPokemonFactory pour la création des Pokemon.

Pour la classe PokemonFactory : 
- Il y aura une variable un IPokemonMetadataProvider lors de la creation de cette classe qui permettera de créer un Pokemon.
- La fonction va utiliser le IPokemonMetadataProvider pour créer le Pokemon , s'y il n'existe pas il renverra une erreur.
- On mettera son IV toujours à 0 lorsqu'on crée un Pokémon.

Pour la classe PokemonMetadataProvider : 
- Il y aura une variable une List de PokemonMetadata qui contiendra les PokemonMetadata de tous les pokemons.
- La fonction retournera le PokemonMetadata qui correspondra à l'index du Pokemon dans les Metadata .S'y il dépasse les bornes (0 et 155) ou qu'ils n'existent pas alors on renvoie une exception.

Pour la classe PokemonTrainerFactory :
- Il y aura une variable IPokemonMetadataProvider et une variable IPokemonFactory pour le constructeur .
- La fonction retournera une nouvelle instance de PokemonTrainer avec comme données les variable données dans le constructeur.

# Ce que regarde checkstyle 
Pour le moment, checkstyle regarde : 
- Regarde s'y il existe des fichiers Javadoc dans le package.
- Regarde lors des imports , s'y il y a des import *.
- Regarde si les noms des variables respectent un pattern .
- Regarde s'y il y a des espaces vides dans les fichiers.


# Raison pour le badge de checkstyle 
Le badge est générée par le plugin com.github.bordertech.buildtools [lien github](https://github.com/BorderTech/badger).
Pour le moment, j'envoie le badge avec le commit , je n'ai pas réussi à récupérer un artifact (juste un seul artifact sans récupérer les autres mais aussi sans savoir le numéro du job éxécutée). depuis CircleCi.


# Rapport du TP6
A la suite de mes tests , je peux en conclure : 
- Ils ont utilisé des noms de Pokemon différents mais aussi comme ils écrivent les Pokémons.Desfois c'est tout en majuscule ou que c'est mal écrit .
- Ils ne renvoient pas d'exception lorsque l'on créait un Pokémon qui dépasse la limite de 155 ou qui a un index négatif .
- S'il n'a pas le pokemon dans sa liste , il ne renvoie pas d'exception disant qu'il ne l'a pas , il renvoie le premier pokemon de la liste .
- Les données d'attack,defense et stamina sont générée aléatoirement(on peut essayer de créer plusieur fois le pokemon et s'y on ne retrouve pas le mème , alors cela va renvoyer une erreur).L'IV est à 1 alors que l'on a mis à 0 .
- Si on lui donne des pokemons avec un index négatif , il renvoie des données de statistique fixe mais ne renvoie pas d'esception .