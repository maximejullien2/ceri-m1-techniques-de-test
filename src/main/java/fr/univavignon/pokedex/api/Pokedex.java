package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Pokedex class , implementation of IPokedex
 *
 * @author Maxime Jullien
 */
public class Pokedex implements IPokedex{
    /**
     * List pokemon in Pokedex
     */
    private List<Pokemon> pokemonList;

    /**
     * Provide PokemonMetadata in Pokedex
     */
    private IPokemonMetadataProvider iPokemonMetadataProvider;

    /**
     * Provide creation of Pokemon in Pokedex
     */
    private IPokemonFactory iPokemonFactory;

    /**
     * Default constructor
     * @param iPokemonMetadataProvider PokemonMetadataProvider for the Pokedex
     * @param iPokemonFactory PokemonFactory to create Pokemon for the Pokedex
     */
    Pokedex(IPokemonMetadataProvider iPokemonMetadataProvider, IPokemonFactory iPokemonFactory){
        pokemonList = new ArrayList<Pokemon>();
        this.iPokemonMetadataProvider = iPokemonMetadataProvider;
        this.iPokemonFactory = iPokemonFactory;
    }

    /**
     * Returns the number of pokemon this pokedex contains.
     *
     * @return Number of pokemon in this pokedex.
     */
    @Override
    public int size() {
        return pokemonList.size();
    }


    /**
     * Adds the given <tt>pokemon</tt> to this pokedex and returns
     * it unique index.
     *
     * @param pokemon Pokemon to add to this pokedex.
     * @return Index of this pokemon relative to this pokedex.
     */
    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemonList.add(pokemon);
        return pokemonList.size()-1;
    }

    /**
     * Locates the pokemon identified by the given <tt>id</tt>.
     *
     * @param id Unique pokedex relative identifier.
     * @return Pokemon denoted by the given identifier.
     * @throws PokedexException If the given <tt>index</tt> is not valid.
     */
    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        for (int i=0 ; i<pokemonList.size();i++){
            if (pokemonList.get(i).getIndex()==id){
                return pokemonList.get(i);
            }
        }
        throw new PokedexException("Le pokemon n'est pas dans le pokedex");
    }

    /**
     * Returns an unmodifiable list of all pokemons this pokedex contains.
     *
     * @return Unmodifiable list of all pokemons.
     */
    @Override
    public List<Pokemon> getPokemons() {
        return pokemonList;
    }

    /**
     * Returns an unmodifiable list of all pokemons this pokedex contains.
     * The list view will be sorted using the given <tt>order</tt>.
     *
     * @param order Comparator instance used for sorting the created view.
     * @return Sorted unmodifiable list of all pokemons.
     */
    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> copie = pokemonList;
        copie.sort(order);
        return copie;
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException {
        return iPokemonFactory.createPokemon(index,cp,hp,dust,candy);
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return iPokemonMetadataProvider.getPokemonMetadata(index);
    }
}
