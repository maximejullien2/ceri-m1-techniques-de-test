package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class IPokemonMetadataProviderTest {

    IPokemonMetadataProvider iPokemonMetadataProvider;
    @BeforeEach
    public void setUp() throws PokedexException {
        this.iPokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        when(iPokemonMetadataProvider.getPokemonMetadata(anyInt())).thenAnswer(
                new Answer() {
                    public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                        int arg = invocationOnMock.getArgument(0);
                        if(arg < 0 || arg > 150){
                            throw new PokedexException("Index "+Integer.toString(arg)+" is not valid");
                        }
                        else{
                            if(arg==0){
                                return new PokemonMetadata(0,"Bulbizarre",126,126,90);
                            }
                            else if (arg==133){
                                return new PokemonMetadata(133,"Aquali",186,168,260);
                            }
                            return null;
                        }
                    }
                }
        );
    }

    @Test
    void getPokemonMetadata() throws PokedexException {

        assertThrows(PokedexException.class,()->{this.iPokemonMetadataProvider.getPokemonMetadata(-1);});
        assertThrows(PokedexException.class,()->{this.iPokemonMetadataProvider.getPokemonMetadata(155);});
        PokemonMetadata pokemonMetadataAquali = iPokemonMetadataProvider.getPokemonMetadata(133);
        PokemonMetadata pokemonMetadataBulbizarre = iPokemonMetadataProvider.getPokemonMetadata(0);
        assertInstanceOf(PokemonMetadata.class,pokemonMetadataAquali);
        assertInstanceOf(PokemonMetadata.class,pokemonMetadataBulbizarre);
        assertEquals(0,pokemonMetadataBulbizarre.getIndex());
        assertEquals(133,pokemonMetadataAquali.getIndex());
        assertEquals("Bulbizarre",pokemonMetadataBulbizarre.getName());
        assertEquals("Aquali",pokemonMetadataAquali.getName());
        assertEquals(126,pokemonMetadataBulbizarre.getAttack());
        assertEquals(186,pokemonMetadataAquali.getAttack());
        assertEquals(126,pokemonMetadataBulbizarre.getDefense());
        assertEquals(168,pokemonMetadataAquali.getDefense());
        assertEquals(90,pokemonMetadataBulbizarre.getStamina());
        assertEquals(260,pokemonMetadataAquali.getStamina());
    }
}