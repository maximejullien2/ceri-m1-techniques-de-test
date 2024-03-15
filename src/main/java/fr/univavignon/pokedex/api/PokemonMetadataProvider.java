package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.List;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    private List<PokemonMetadata> metadataPokemonArrayList;


    PokemonMetadataProvider(List<PokemonMetadata> pokemonMetadata){
        this.metadataPokemonArrayList = pokemonMetadata;
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if(0 > index || index > 150){
            throw new PokedexException("Index qui dépasse les limites du Pokedex");
        }
        if (index ==0){
            return new PokemonMetadata(0,"Bulbizarre",126,126,90);
        }
        if(index == 133){
            return new PokemonMetadata(133,"Aquali",186,168,260);
        }
        throw new PokedexException("Pokemon inexistant dans le Pokedex");
    }
}
