package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

//A finir
class IPokedexTest {

    IPokedex iPokedex;
    Pokemon bulbizarre = new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,0.56);
    Pokemon aquali = new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,1.00);

    @BeforeEach
    public void setUp() throws PokedexException {
        iPokedex = Mockito.mock(IPokedex.class);
        when(iPokedex.size()).thenReturn(0);
        when(iPokedex.addPokemon(bulbizarre)).thenReturn(0);
        when(iPokedex.addPokemon(aquali)).thenReturn(133);
        when(iPokedex.getPokemon(anyInt())).thenAnswer(
                new Answer() {
                    public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                        int arg = invocationOnMock.getArgument(0);
                        if(arg < 0 || arg > 150){
                            throw new PokedexException("Index "+Integer.toString(arg)+" is not valid");
                        }
                        else{
                            if(arg==0){
                                return bulbizarre;
                            }
                            else if (arg==133){
                                return aquali;
                            }
                            return null;
                        }
                    }
                }
        );
        List<Pokemon> pokemonList = new ArrayList<>();
        pokemonList.add(bulbizarre);
        pokemonList.add(aquali);
        when(iPokedex.getPokemons()).thenReturn(pokemonList);

        List<Pokemon> nameList = new ArrayList<Pokemon>();
        nameList.add(aquali);
        nameList.add(bulbizarre);
        when(iPokedex.getPokemons(PokemonComparators.NAME)).thenReturn(nameList);

        List<Pokemon> indexList = new ArrayList<Pokemon>();
        indexList.add(bulbizarre);
        indexList.add(aquali);
        when(iPokedex.getPokemons(PokemonComparators.INDEX)).thenReturn(indexList);

        List<Pokemon> cpList = new ArrayList<Pokemon>();
        cpList.add(bulbizarre);
        cpList.add(aquali);
        when(iPokedex.getPokemons(PokemonComparators.CP)).thenReturn(cpList);

    }


    @Test
    void sizeTest() {
        assertEquals(0,iPokedex.size());
    }

    @Test
    void addPokemonTest() {
        assertEquals(133,iPokedex.addPokemon(aquali));
        assertEquals(0,iPokedex.addPokemon(bulbizarre));
    }

    @Test
    void getPokemonTest() throws PokedexException {
        assertEquals(0,iPokedex.getPokemon(0).getIndex());
        assertEquals(133,iPokedex.getPokemon(133).getIndex());
        assertEquals("Bulbizarre",iPokedex.getPokemon(0).getName());
        assertEquals("Aquali",iPokedex.getPokemon(133).getName());
        assertEquals(126,iPokedex.getPokemon(0).getAttack());
        assertEquals(186,iPokedex.getPokemon(133).getAttack());
        assertEquals(126,iPokedex.getPokemon(0).getDefense());
        assertEquals(168,iPokedex.getPokemon(133).getDefense());
        assertEquals(90,iPokedex.getPokemon(0).getStamina());
        assertEquals(260,iPokedex.getPokemon(133).getStamina());
        assertEquals(613,iPokedex.getPokemon(0).getCp());
        assertEquals(2729,iPokedex.getPokemon(133).getCp());
        assertEquals(64,iPokedex.getPokemon(0).getHp());
        assertEquals(202,iPokedex.getPokemon(133).getHp());
        assertEquals(4000,iPokedex.getPokemon(0).getDust());
        assertEquals(5000,iPokedex.getPokemon(133).getDust());
        assertEquals(4,iPokedex.getPokemon(0).getCandy());
        assertEquals(4,iPokedex.getPokemon(133).getCandy());
        assertEquals(0.56,iPokedex.getPokemon(0).getIv());
        assertEquals(1.00,iPokedex.getPokemon(133).getIv());
        assertThrows(PokedexException.class,()->{this.iPokedex.getPokemon(-1);});
        assertThrows(PokedexException.class,()->{this.iPokedex.getPokemon(155);});
    }

    @Test
    void getPokemonsTest() {
        List<Pokemon> pokemonList = iPokedex.getPokemons();
        assertEquals(0,pokemonList.get(0).getIndex());
        assertEquals(133,pokemonList.get(1).getIndex());
        assertEquals("Bulbizarre",pokemonList.get(0).getName());
        assertEquals("Aquali",pokemonList.get(1).getName());
        assertEquals(126,pokemonList.get(0).getAttack());
        assertEquals(186,pokemonList.get(1).getAttack());
        assertEquals(126,pokemonList.get(0).getDefense());
        assertEquals(168,pokemonList.get(1).getDefense());
        assertEquals(90,pokemonList.get(0).getStamina());
        assertEquals(260,pokemonList.get(1).getStamina());
        assertEquals(613,pokemonList.get(0).getCp());
        assertEquals(2729,pokemonList.get(1).getCp());
        assertEquals(64,pokemonList.get(0).getHp());
        assertEquals(202,pokemonList.get(1).getHp());
        assertEquals(4000,pokemonList.get(0).getDust());
        assertEquals(5000,pokemonList.get(1).getDust());
        assertEquals(4,pokemonList.get(0).getCandy());
        assertEquals(4,pokemonList.get(1).getCandy());
        assertEquals(0.56,pokemonList.get(0).getIv());
        assertEquals(1.00,pokemonList.get(1).getIv());

        List<Pokemon> nameList = iPokedex.getPokemons(PokemonComparators.NAME);
        assertEquals(0,nameList.get(1).getIndex());
        assertEquals(133,nameList.get(0).getIndex());
        assertEquals("Bulbizarre",nameList.get(1).getName());
        assertEquals("Aquali",nameList.get(0).getName());
        assertEquals(126,nameList.get(1).getAttack());
        assertEquals(186,nameList.get(0).getAttack());
        assertEquals(126,nameList.get(1).getDefense());
        assertEquals(168,nameList.get(0).getDefense());
        assertEquals(90,nameList.get(1).getStamina());
        assertEquals(260,nameList.get(0).getStamina());
        assertEquals(613,nameList.get(1).getCp());
        assertEquals(2729,nameList.get(0).getCp());
        assertEquals(64,nameList.get(1).getHp());
        assertEquals(202,nameList.get(0).getHp());
        assertEquals(4000,nameList.get(1).getDust());
        assertEquals(5000,nameList.get(0).getDust());
        assertEquals(4,nameList.get(1).getCandy());
        assertEquals(4,nameList.get(0).getCandy());
        assertEquals(0.56,nameList.get(1).getIv());
        assertEquals(1.00,nameList.get(0).getIv());

        List<Pokemon> indexList =iPokedex.getPokemons(PokemonComparators.INDEX);
        assertEquals(0,indexList.get(0).getIndex());
        assertEquals(133,indexList.get(1).getIndex());
        assertEquals("Bulbizarre",indexList.get(0).getName());
        assertEquals("Aquali",indexList.get(1).getName());
        assertEquals(126,indexList.get(0).getAttack());
        assertEquals(186,indexList.get(1).getAttack());
        assertEquals(126,indexList.get(0).getDefense());
        assertEquals(168,indexList.get(1).getDefense());
        assertEquals(90,indexList.get(0).getStamina());
        assertEquals(260,indexList.get(1).getStamina());
        assertEquals(613,indexList.get(0).getCp());
        assertEquals(2729,indexList.get(1).getCp());
        assertEquals(64,indexList.get(0).getHp());
        assertEquals(202,indexList.get(1).getHp());
        assertEquals(4000,indexList.get(0).getDust());
        assertEquals(5000,indexList.get(1).getDust());
        assertEquals(4,indexList.get(0).getCandy());
        assertEquals(4,indexList.get(1).getCandy());
        assertEquals(0.56,indexList.get(0).getIv());
        assertEquals(1.00,indexList.get(1).getIv());

        List<Pokemon> cpList = iPokedex.getPokemons(PokemonComparators.CP);
        assertEquals(0,cpList.get(0).getIndex());
        assertEquals(133,cpList.get(1).getIndex());
        assertEquals("Bulbizarre",cpList.get(0).getName());
        assertEquals("Aquali",cpList.get(1).getName());
        assertEquals(126,cpList.get(0).getAttack());
        assertEquals(186,cpList.get(1).getAttack());
        assertEquals(126,cpList.get(0).getDefense());
        assertEquals(168,cpList.get(1).getDefense());
        assertEquals(90,cpList.get(0).getStamina());
        assertEquals(260,cpList.get(1).getStamina());
        assertEquals(613,cpList.get(0).getCp());
        assertEquals(2729,cpList.get(1).getCp());
        assertEquals(64,cpList.get(0).getHp());
        assertEquals(202,cpList.get(1).getHp());
        assertEquals(4000,cpList.get(0).getDust());
        assertEquals(5000,cpList.get(1).getDust());
        assertEquals(4,cpList.get(0).getCandy());
        assertEquals(4,cpList.get(1).getCandy());
        assertEquals(0.56,cpList.get(0).getIv());
        assertEquals(1.00,cpList.get(1).getIv());

    }

}