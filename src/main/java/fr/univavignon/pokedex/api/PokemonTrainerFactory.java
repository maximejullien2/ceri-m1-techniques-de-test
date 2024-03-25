package fr.univavignon.pokedex.api;

/**
 * Factory class , implement IPokemonTrainerFactory ,
 * Create PokemonTrainer instance.
 *
 * @author Maxime Jullien
 */
public class PokemonTrainerFactory implements IPokemonTrainerFactory{

    /**
     * Provide PokemonMetadata
     */
    private IPokemonMetadataProvider iPokemonMetadataProvider;

    /**
     * Factory to create Pokemon
     */
    private IPokemonFactory iPokemonFactory;

    /**
     * Default constructor
     * @param iPokemonMetadataProvider IPokemonMetadata we need to create PokemonTrainer
     * @param iPokemonFactory IPokemonFactory we need to create PokemonTrainer
     */
    PokemonTrainerFactory(IPokemonMetadataProvider iPokemonMetadataProvider,IPokemonFactory iPokemonFactory){
        this.iPokemonFactory = iPokemonFactory;
        this.iPokemonMetadataProvider = iPokemonMetadataProvider;
    }

    /**
     * Creates and returns a PokemonTrainer instance.
     *
     * @param name Name of the created trainer.
     * @param team Team of the created trainer.
     * @param pokedexFactory Factory to use for creating associated pokedex instance.
     * @return Created trainer instance.
     */
    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        return new PokemonTrainer(name,team,pokedexFactory.createPokedex(this.iPokemonMetadataProvider,this.iPokemonFactory));
    }
}
