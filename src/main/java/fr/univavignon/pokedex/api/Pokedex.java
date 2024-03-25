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
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return pokemonList.size();
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemonList.add(pokemon);
        return pokemonList.size()-1;
    }

    /**
     * {@inheritDoc}
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
     * {@inheritDoc}
     */
    @Override
    public List<Pokemon> getPokemons() {
        return pokemonList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> copie = pokemonList;
        copie.sort(order);
        return copie;
    }

    /**{@inheritDoc}*/
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException {
        return iPokemonFactory.createPokemon(index,cp,hp,dust,candy);
    }

    /**{@inheritDoc}*/
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return iPokemonMetadataProvider.getPokemonMetadata(index);
    }
}
