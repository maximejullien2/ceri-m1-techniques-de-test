package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory{

    private IPokemonMetadataProvider pokemonMetadataProvider;

    PokemonFactory(IPokemonMetadataProvider pokemonMetadataProvider){
        this.pokemonMetadataProvider = pokemonMetadataProvider;
    }

    //Les pokémons créer sont de niveaux 1 . Leur IV sera donc de 0.
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException {
        try{
            PokemonMetadata pokemonMetadata = pokemonMetadataProvider.getPokemonMetadata(index);
            return new Pokemon(index,pokemonMetadata.getName(), pokemonMetadata.getAttack(), pokemonMetadata.getDefense(), pokemonMetadata.getStamina(), cp,hp,dust,candy,0);
        } catch (PokedexException e) {
            throw e;
        }
    }
}
