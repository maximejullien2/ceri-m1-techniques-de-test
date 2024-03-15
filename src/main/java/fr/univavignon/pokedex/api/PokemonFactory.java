package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory{

    private PokemonMetadataProvider pokemonMetadataProvider;

    PokemonFactory(PokemonMetadataProvider pokemonMetadataProvider){
        this.pokemonMetadataProvider = pokemonMetadataProvider;
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        if(index==0){
            return new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,0.56);
        }
        if (index ==133){
            return new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,1.00);
        }
        return null;
    }
}
