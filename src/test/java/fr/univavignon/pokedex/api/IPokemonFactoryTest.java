package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class IPokemonFactoryTest {

    IPokemonFactory iPokemonFactory;
    @BeforeEach
    public void setUp(){
        this.iPokemonFactory = Mockito.mock(IPokemonFactory.class);
        when(iPokemonFactory.createPokemon(0,613,64,4000,4)).thenReturn(new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,0.56));
        when(iPokemonFactory.createPokemon(133,2729,202,5000,4)).thenReturn(new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,1.00));
    }

    @Test
    void createPokemonTest() {
        Pokemon pokemonAquali = iPokemonFactory.createPokemon(133,2729,202,5000,4);
        Pokemon pokemonBulbizarre = iPokemonFactory.createPokemon(0,613,64,4000,4);
        assertTrue(pokemonAquali instanceof Pokemon);
        assertTrue(pokemonBulbizarre instanceof Pokemon);
        assertEquals(0,pokemonBulbizarre.getIndex());
        assertEquals(133,pokemonAquali.getIndex());
        assertEquals("Bulbizarre",pokemonBulbizarre.getName());
        assertEquals("Aquali",pokemonAquali.getName());
        assertEquals(126,pokemonBulbizarre.getAttack());
        assertEquals(186,pokemonAquali.getAttack());
        assertEquals(126,pokemonBulbizarre.getDefense());
        assertEquals(168,pokemonAquali.getDefense());
        assertEquals(90,pokemonBulbizarre.getStamina());
        assertEquals(260,pokemonAquali.getStamina());
        assertEquals(613,pokemonBulbizarre.getCp());
        assertEquals(2729,pokemonAquali.getCp());
        assertEquals(64,pokemonBulbizarre.getHp());
        assertEquals(202,pokemonAquali.getHp());
        assertEquals(4000,pokemonBulbizarre.getDust());
        assertEquals(5000,pokemonAquali.getDust());
        assertEquals(4,pokemonBulbizarre.getCandy());
        assertEquals(4,pokemonAquali.getCandy());
        assertEquals(0.56,pokemonBulbizarre.getIv());
        assertEquals(1.00,pokemonAquali.getIv());
    }
}