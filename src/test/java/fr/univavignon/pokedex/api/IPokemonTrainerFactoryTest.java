package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class IPokemonTrainerFactoryTest {

    IPokemonTrainerFactory iPokemonTrainerFactory;
    IPokedexFactory iPokedexFactory;
    Pokemon bulbizarre = new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,0.56);
    List<Pokemon> pokemonList = new ArrayList<Pokemon>();
    @BeforeEach
    public void setUp(){
        this.iPokemonTrainerFactory = Mockito.mock(IPokemonTrainerFactory.class);
        this.iPokedexFactory = Mockito.mock(IPokedexFactory.class);

        IPokedex ipokedex = Mockito.mock(IPokedex.class);
        when(ipokedex.getPokemons()).thenReturn(pokemonList);
        when(ipokedex.size()).thenReturn(pokemonList.size());
        when(ipokedex.addPokemon(bulbizarre)).thenReturn(pokemonList.size()-1);
        when(this.iPokemonTrainerFactory.createTrainer("Test",Team.MYSTIC,iPokedexFactory)).thenReturn(new PokemonTrainer("Test",Team.MYSTIC,ipokedex));
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