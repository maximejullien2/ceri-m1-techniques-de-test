package fr.univavignon.pokedex.api;

/**
 * Factory class , implement IPokedexFactory,
 * Create Pokdedex instance.
 *
 * @author Maxime Jullien
 */
public class PokedexFactory implements IPokedexFactory{

    /**
     * Creates a new pokedex instance using the given
     * <tt>metadataProvider</tt> and <tt>pokemonFactory</tt>.
     *
     * @param metadataProvider Metadata provider the created pokedex will use.
     * @param pokemonFactory Pokemon factory the created pokedex will use.
     * @return Created pokedex instance.
     */
    @Override
    public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        return new Pokedex(metadataProvider,pokemonFactory);
    }
}
