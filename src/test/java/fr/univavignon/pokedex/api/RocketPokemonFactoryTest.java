package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RocketPokemonFactoryTest {
    IPokemonFactory iPokemonFactory;
    @BeforeEach
    public void setUp(){
        this.iPokemonFactory = new RocketPokemonFactory();
    }

    @Test
    void createPokemonTest() throws PokedexException {
        Pokemon pokemonAquali = iPokemonFactory.createPokemon(133,2729,202,5000,4);
        Pokemon pokemonBulbizarre = iPokemonFactory.createPokemon(0,613,64,4000,4);
        assertInstanceOf(Pokemon.class,pokemonAquali);
        assertInstanceOf(Pokemon.class,pokemonBulbizarre);
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
        assertEquals(0,pokemonBulbizarre.getIv());
        assertEquals(0,pokemonAquali.getIv());
        assertThrows(PokedexException.class,()->{iPokemonFactory.createPokemon(-1,100,120,130,5);});
        assertThrows(PokedexException.class,()->{iPokemonFactory.createPokemon(155,150,90,45,9);});
    }
}
