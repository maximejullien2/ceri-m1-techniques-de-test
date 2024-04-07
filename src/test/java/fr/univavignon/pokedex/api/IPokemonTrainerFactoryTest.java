package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class IPokemonTrainerFactoryTest {

    IPokemonTrainerFactory iPokemonTrainerFactory;
    IPokedexFactory iPokedexFactory;
    @BeforeEach
    public void setUp(){
        List<PokemonMetadata> arrayList = new ArrayList<PokemonMetadata>();
        arrayList.add(new PokemonMetadata(0,"Bulbizarre",126,126,90));
        arrayList.add(new PokemonMetadata(133,"Aquali",186,168,260));
        IPokemonMetadataProvider iPokemonMetadataProvider = new PokemonMetadataProvider(arrayList);
        IPokemonFactory iPokemonFactory = new PokemonFactory(iPokemonMetadataProvider);
        this.iPokemonTrainerFactory = new PokemonTrainerFactory(iPokemonMetadataProvider,iPokemonFactory);
        this.iPokedexFactory = new PokedexFactory();
        }

    @Test
    void createTrainerTest() {
        PokemonTrainer pokemonTrainer = iPokemonTrainerFactory.createTrainer("Test",Team.MYSTIC,iPokedexFactory);
        assertInstanceOf(PokemonTrainer.class,pokemonTrainer);
        assertEquals("Test",pokemonTrainer.getName());
        assertEquals(Team.MYSTIC,pokemonTrainer.getTeam());
        assertEquals(0,pokemonTrainer.getPokedex().size());
    }
}