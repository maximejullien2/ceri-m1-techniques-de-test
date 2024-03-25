package fr.univavignon.pokedex.api;

import java.util.List;

/**
 * PokemonMetadtaatProvider class , implement IPokemonMetadataProvider
 *
 * @author Maxime Jullien
 */
public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    /**
     * List PokemonMetadata
     */
    private List<PokemonMetadata> metadataPokemonArrayList;

    /**
     *Default contructor
     *
     * @param pokemonMetadata List all PokemonMetadata we need
     */
    PokemonMetadataProvider(List<PokemonMetadata> pokemonMetadata){
        this.metadataPokemonArrayList = pokemonMetadata;
    }

    /**
     * {@inheritDoc}*/
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if(0 > index || index > 150){
            throw new PokedexException("Index qui dépasse les limites du Pokedex");
        }
        for(int i=0 ; i<metadataPokemonArrayList.size();i++){
            if(metadataPokemonArrayList.get(i).getIndex()==index){
                return metadataPokemonArrayList.get(i);
            }
        }
        throw new PokedexException("Pokemon inexistant dans le Pokedex");
    }
}
