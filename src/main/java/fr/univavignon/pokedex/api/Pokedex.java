package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex{
    private List<Pokemon> pokemonList;
    private IPokemonMetadataProvider iPokemonMetadataProvider;
    private IPokemonFactory iPokemonFactory;

    Pokedex(IPokemonMetadataProvider iPokemonMetadataProvider, IPokemonFactory iPokemonFactory){
        pokemonList = new ArrayList<>();
        this.iPokemonMetadataProvider = iPokemonMetadataProvider;
        this.iPokemonFactory = iPokemonFactory;
    }

    @Override
    public int size() {
        return pokemonList.size();
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemonList.add(pokemon);
        return pokemonList.size()-1;
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        for (int i=0 ; i<pokemonList.size();i++){
            if (pokemonList.get(i).getIndex()==id){
                return pokemonList.get(i);
            }
        }
        throw new PokedexException("Le pokemon n'est pas dans le pokedex");
    }

    @Override
    public List<Pokemon> getPokemons() {
        return pokemonList;
    }

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
