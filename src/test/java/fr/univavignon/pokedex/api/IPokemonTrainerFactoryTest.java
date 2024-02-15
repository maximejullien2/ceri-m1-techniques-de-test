package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

//A voir rajouter des test sur le ipokedex
class IPokemonTrainerFactoryTest {

    IPokemonTrainerFactory iPokemonTrainerFactory;
    IPokedexFactory iPokedexFactory;
    @BeforeEach
    public void setUp(){
        this.iPokemonTrainerFactory = Mockito.mock(IPokemonTrainerFactory.class);
        this.iPokedexFactory = Mockito.mock(IPokedexFactory.class);

        IPokedex ipokedex = Mockito.mock(IPokedex.class);
        when(ipokedex.getPokemons()).thenReturn(new ArrayList<Pokemon>());
        when(ipokedex.size()).thenReturn(0);

        when(this.iPokemonTrainerFactory.createTrainer("Test",Team.MYSTIC,iPokedexFactory)).thenReturn(new PokemonTrainer("Test",Team.MYSTIC,ipokedex));
    }

    @Test
    void createTrainerTest() {
        PokemonTrainer pokemonTrainer = iPokemonTrainerFactory.createTrainer("Test",Team.MYSTIC,iPokedexFactory);
        assertTrue(pokemonTrainer instanceof PokemonTrainer);
        assertEquals("Test",pokemonTrainer.getName());
        assertEquals(Team.MYSTIC,pokemonTrainer.getTeam());
    }
}