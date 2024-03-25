package fr.univavignon.pokedex.api;

/**
 * Factory class , implement IPokedexFactory,
 * Create Pokdedex instance.
 *
 * @author Maxime Jullien
 */
public class PokedexFactory implements IPokedexFactory{

    /**
     * Default constructor.
     */
    PokedexFactory(){

    }
    /**{@inheritDoc}*/
    @Override
    public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        return new Pokedex(metadataProvider,pokemonFactory);
    }
}
