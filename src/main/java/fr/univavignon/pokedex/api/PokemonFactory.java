package fr.univavignon.pokedex.api;

/**
 * Factory class , implement IPokemonFactory,
 * Create Pokemon instance.
 */
public class PokemonFactory implements IPokemonFactory{

    /**
     * Provide PokemonMetadata in PokemonFactory
     */
    private IPokemonMetadataProvider pokemonMetadataProvider;

    /**
     * Default constructor
     * @param pokemonMetadataProvider Provide PokemonMetadata into factory
     */
    PokemonFactory(IPokemonMetadataProvider pokemonMetadataProvider){
        this.pokemonMetadataProvider = pokemonMetadataProvider;
    }

    /**
     * {@inheritDoc}*/
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
