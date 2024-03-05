package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class IPokedexFactoryTest {

    IPokedexFactory iPokedexFactory;
    IPokemonMetadataProvider iPokemonMetadataProvider;
    IPokemonFactory iPokemonFactory;

    @BeforeEach
    public void setUp(){
        this.iPokedexFactory = Mockito.mock(IPokedexFactory.class);
        this.iPokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        this.iPokemonFactory = Mockito.mock(IPokemonFactory.class);
        when(this.iPokedexFactory.createPokedex(this.iPokemonMetadataProvider,this.iPokemonFactory)).thenReturn(Mockito.mock(IPokedex.class));
    }


    @Test
    void createPokedexTest() {
        IPokedex iPokedex = this.iPokedexFactory.createPokedex(this.iPokemonMetadataProvider,this.iPokemonFactory);
        assertInstanceOf(IPokedex.class,iPokedex);
    }
}