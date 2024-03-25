package fr.univavignon.pokedex.api;

/**
 * Factory interface for class that aims to create Pokemon instance.
 * 
 * @author fv
 */
public interface IPokemonFactory {

	/**
	 * Creates a pokemon instance computing it IVs.
	 * 
	 * @param index Pokemon index.
	 * @param cp Pokemon CP.
	 * @param hp Pokemon HP.
	 * @param dust Required dust for upgrading pokemon.
	 * @param candy Required candy for upgrading pokemon.
	 * @return Created pokemon instance.
	 * @throws PokedexException If the given <code>index</code> is not valid.
	 */
	Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException;
	
}
