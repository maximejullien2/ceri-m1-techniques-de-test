package fr.univavignon.pokedex.api;

public class PokemonTrainerFactory implements IPokemonTrainerFactory{

    private IPokemonMetadataProvider iPokemonMetadataProvider;
    private IPokemonFactory iPokemonFactory;

    PokemonTrainerFactory(IPokemonMetadataProvider iPokemonMetadataProvider,IPokemonFactory iPokemonFactory){
        this.iPokemonFactory = iPokemonFactory;
        this.iPokemonMetadataProvider = iPokemonMetadataProvider;
    }

    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        return new PokemonTrainer(name,team,pokedexFactory.createPokedex(this.iPokemonMetadataProvider,this.iPokemonFactory));
    }
}
