package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class IPokedexFactoryTest {

    IPokedexFactory iPokedexFactory;
    IPokemonMetadataProvider iPokemonMetadataProvider;
    IPokemonFactory iPokemonFactory;

    @BeforeEach
    public void setUp(){
        ArrayList<PokemonMetadata> arrayList = new ArrayList<>();
        arrayList.add(new PokemonMetadata(0,"Bulbizarre",126,126,90));
        arrayList.add(new PokemonMetadata(133,"Aquali",186,168,260));
        this.iPokemonMetadataProvider = new PokemonMetadataProvider(arrayList);
        this.iPokemonFactory = new PokemonFactory(iPokemonMetadataProvider);
        this.iPokedexFactory = new PokedexFactory();
    }


    @Test
    void createPokedexTest() {
        IPokedex iPokedex = iPokedexFactory.createPokedex(iPokemonMetadataProvider,iPokemonFactory);
        assertInstanceOf(IPokedex.class,iPokedex);
    }
}