
public class Pokedex extends AbstractPokemon implements PokemonInterface{
	public void pokemonInfo(Pokemon pokemon) {
		System.out.println("Name: " + pokemon.getName() + ", Health: " + pokemon.getHealth() + ", Type: " + pokemon.getType());
//		return pokemon.getName() + pokemon.getHealth() + pokemon.getType();
	}
}
