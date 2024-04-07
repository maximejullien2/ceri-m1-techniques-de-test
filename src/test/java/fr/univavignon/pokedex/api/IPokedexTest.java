package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
class IPokedexTest {

    IPokedex iPokedex;
    Pokemon bulbizarre = new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,0.56);
    Pokemon aquali = new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,1.00);

    @BeforeEach
    public void setUp(){
        List<PokemonMetadata> arrayList = new ArrayList<PokemonMetadata>();
        arrayList.add(new PokemonMetadata(0,"Bulbizarre",126,126,90));
        arrayList.add(new PokemonMetadata(133,"Aquali",186,168,260));
        PokemonMetadataProvider pokemonMetadataProvider = new PokemonMetadataProvider(arrayList);
        iPokedex = new Pokedex(pokemonMetadataProvider,new PokemonFactory(new PokemonMetadataProvider(arrayList)));
    }


    @Test
    void sizeTest() {
        assertEquals(0,iPokedex.size());
        iPokedex.addPokemon(aquali);
        assertEquals(1,iPokedex.size());
        iPokedex.addPokemon(bulbizarre);
        assertEquals(2,iPokedex.size());
        iPokedex.addPokemon(aquali);
        assertEquals(3,iPokedex.size());
    }

    @Test
    void addPokemonTest() {
        assertEquals(0,iPokedex.addPokemon(aquali));
        assertEquals(1,iPokedex.addPokemon(bulbizarre));
    }

    @Test
    void getPokemonTest() throws PokedexException {
        iPokedex.addPokemon(bulbizarre);
        iPokedex.addPokemon(aquali);
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
    void getPokemonsComparatorNameTest(){
        assertEquals(0,iPokedex.getPokemons(PokemonComparators.NAME).size());
        iPokedex.addPokemon(bulbizarre);
        List<Pokemon> nameList = iPokedex.getPokemons(PokemonComparators.NAME);
        assertEquals(0,nameList.get(0).getIndex());
        assertEquals("Bulbizarre",nameList.get(0).getName());
        assertEquals(126,nameList.get(0).getAttack());
        assertEquals(126,nameList.get(0).getDefense());
        assertEquals(90,nameList.get(0).getStamina());
        assertEquals(613,nameList.get(0).getCp());
        assertEquals(64,nameList.get(0).getHp());
        assertEquals(4000,nameList.get(0).getDust());
        assertEquals(4,nameList.get(0).getCandy());
        assertEquals(0.56,nameList.get(0).getIv());

        iPokedex.addPokemon(aquali);
        nameList = iPokedex.getPokemons(PokemonComparators.NAME);
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
    }

    @Test
    void getPokemonsTestComparatorIndexTest(){
        assertEquals(0,iPokedex.getPokemons(PokemonComparators.INDEX).size());
        iPokedex.addPokemon(bulbizarre);
        List<Pokemon> indexList =iPokedex.getPokemons(PokemonComparators.INDEX);
        assertEquals(0,indexList.get(0).getIndex());
        assertEquals("Bulbizarre",indexList.get(0).getName());
        assertEquals(126,indexList.get(0).getAttack());
        assertEquals(126,indexList.get(0).getDefense());
        assertEquals(90,indexList.get(0).getStamina());
        assertEquals(613,indexList.get(0).getCp());
        assertEquals(64,indexList.get(0).getHp());
        assertEquals(4000,indexList.get(0).getDust());
        assertEquals(4,indexList.get(0).getCandy());
        assertEquals(0.56,indexList.get(0).getIv());

        iPokedex.addPokemon(aquali);
        indexList =iPokedex.getPokemons(PokemonComparators.INDEX);
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
    }

    @Test
    void getPokemonsTestComparatorCpTest(){
        assertEquals(0,iPokedex.getPokemons(PokemonComparators.CP).size());
        iPokedex.addPokemon(bulbizarre);
        List<Pokemon> cpList = iPokedex.getPokemons(PokemonComparators.CP);
        assertEquals(0,cpList.get(0).getIndex());
        assertEquals("Bulbizarre",cpList.get(0).getName());
        assertEquals(126,cpList.get(0).getAttack());
        assertEquals(126,cpList.get(0).getDefense());
        assertEquals(90,cpList.get(0).getStamina());
        assertEquals(613,cpList.get(0).getCp());
        assertEquals(64,cpList.get(0).getHp());
        assertEquals(4000,cpList.get(0).getDust());
        assertEquals(4,cpList.get(0).getCandy());
        assertEquals(0.56,cpList.get(0).getIv());

        iPokedex.addPokemon(aquali);
        cpList = iPokedex.getPokemons(PokemonComparators.CP);
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
    @Test
    void getPokemonsTest() {
        assertEquals(0,iPokedex.getPokemons().size());
        iPokedex.addPokemon(bulbizarre);
        List<Pokemon> pokemonList = iPokedex.getPokemons();
        assertEquals(0,pokemonList.get(0).getIndex());
        assertEquals("Bulbizarre",pokemonList.get(0).getName());
        assertEquals(126,pokemonList.get(0).getAttack());
        assertEquals(126,pokemonList.get(0).getDefense());
        assertEquals(90,pokemonList.get(0).getStamina());
        assertEquals(613,pokemonList.get(0).getCp());
        assertEquals(64,pokemonList.get(0).getHp());
        assertEquals(4000,pokemonList.get(0).getDust());
        assertEquals(4,pokemonList.get(0).getCandy());
        assertEquals(0.56,pokemonList.get(0).getIv());
        
        iPokedex.addPokemon(aquali);
        pokemonList = iPokedex.getPokemons();
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
    }


    @Test
    void createPokemonTest() throws PokedexException {
        Pokemon pokemonAquali = this.iPokedex.createPokemon(133,2729,202,5000,4);
        Pokemon pokemonBulbizarre = this.iPokedex.createPokemon(0,613,64,4000,4);
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
        assertThrows(PokedexException.class,()->{this.iPokedex.createPokemon(-1,100,120,130,5);});
        assertThrows(PokedexException.class,()->{this.iPokedex.createPokemon(155,150,90,45,9);});
    }

    @Test
    void getPokemonMetadata()throws PokedexException {
        assertThrows(PokedexException.class,()->{this.iPokedex.getPokemonMetadata(-1);});
        assertThrows(PokedexException.class,()->{this.iPokedex.getPokemonMetadata(155);});
        assertThrows(PokedexException.class,()->{this.iPokedex.getPokemonMetadata(50);});
        PokemonMetadata pokemonMetadataAquali = this.iPokedex.getPokemonMetadata(133);
        PokemonMetadata pokemonMetadataBulbizarre = this.iPokedex.getPokemonMetadata(0);
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