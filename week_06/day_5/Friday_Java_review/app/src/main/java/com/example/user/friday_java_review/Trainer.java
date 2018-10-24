package com.example.user.friday_java_review;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by user on 08/09/2017.
 */

public class Trainer {
    private String name;
    private ArrayList<Pokemon> pokemonOnHand; // Tells Java that pokemonOnHand is an ArrayList of pokemon.
    private HashMap<String, ArrayList<Pokemon>> storedPokemon; // Tells Java that storedPokemon is a HashMap with Strings for keys, and ArrayLists of pokemon for values.

    public Trainer(String name){
        this.name = name;
        this.pokemonOnHand = new ArrayList<>(); // Sets pokemonOnHand to be an empty ArrayList.
        this.storedPokemon = new HashMap<>(); // Sets storedPokemon to be an empty HashMap.
    }

    public String getName(){
        return this.name;
    }

    public ArrayList<Pokemon> getPokemonOnHand(){
        return this.pokemonOnHand;
    }

    public void catchPokemon(Pokemon pokemon){
        this.pokemonOnHand.add(pokemon); // Adds a passed in pokemon to the end of the pokemonOnHand ArrayList.
        // Ruby @pokemonOnHand.push(pokemon)
    }

    public Pokemon getFirstPokemon(){
        return this.pokemonOnHand.get(0); // Returns the pokemon at the start of the pokemonOnHand ArrayList.
        // Ruby return @pokemonOnHand[0]
    }

    public void releasePokemon(int index){
        this.pokemonOnHand.remove(index); // Removes a pokemon at a passed in index from the pokemonOnHand ArrayList.
        // Ruby @pokemonOnHand.splice(index, 1)
    }

    public void releaseByName(String nameToRelease) {
        for(int i = this.pokemonOnHand.size() - 1; i >= 0; i--) { // Loops backwards through the pokemonOnHand ArrayList starting at the end.
            String currentPokemonName = this.pokemonOnHand.get(i).getName(); // Gets the name of the pokemon which is currently being looked at.

            if(currentPokemonName.equals(nameToRelease)) { // Checks if the name of the current pokemon is the same as the name we want to remove by.
                this.pokemonOnHand.remove(i); // If they are the same, removes the pokemon at the current index.
            }
        }

        // General way to write the "C style" for loop.
        // for (initial value of i; condition for looping; something that happens after every time it loops){ ...code }
    }

    public void filterOutByName(String nameToFilterOut) {
        ArrayList<Pokemon> filteredPokemonOnHand = new ArrayList<>(); // Creates an empty ArrayList.

        for (Pokemon pokemon: this.pokemonOnHand) { // Loops through the pokemon in the pokemonOnHand ArrayList.
            if (!pokemon.getName().equals(nameToFilterOut)) { // Check if the name of the current pokemon is NOT equal to the one we want to filter out.
                filteredPokemonOnHand.add(pokemon); // If it does not equal the name we want to filter out by, it adds the pokemon to the filteredPokemonOnHand ArrayList.
            }                                       // This means that when the loop is done, we will end up with an ArrayList with all the pokemonOnHand except the ones with the name that we pass in.
        }

//        Equivalent to above, but in a "C style" for loops:
//        for (int index = 0; index < this.pokemonOnHand.size(); index++) {
//            Pokemon pokemon = this.pokemonOnHand.get(index);
//
//            if (!pokemon.getName().equals(nameToFilterOut)) {
//                filteredPokemonOnHand.add(pokemon);
//            }
//        }

        this.pokemonOnHand = filteredPokemonOnHand; // Sets the pokemonOnHand ArrayList to be the same as the filteredPokemonOnHand ArrayList.
    }

    public void storePokemon(String environment, Pokemon pokemon) {
        ArrayList<Pokemon> collection = this.storedPokemon.get(environment); // Gets the value of from the StoredPokemon HashMap under the key of the passed in String, environment, and tells Java that it is an ArrayList of pokemon.

        if (collection == null) { // Checks if the value of under the key environment is null (doesn't exist).
            collection = new ArrayList<>(); // If it doesn't exist, it makes it an empty ArrayList of pokemon.
            storedPokemon.put(environment, collection); // Sets the value under the key environment to an empty ArrayList.
        }

        collection.add(pokemon); // Adds the passed in pokemon to the ArrayList under the key environment.
    }

    public ArrayList<Pokemon> getStoredPokemon(String environment) {
        ArrayList<Pokemon> pokemonInEnvironment = this.storedPokemon.get(environment); // Gets the ArrayList of pokemon under the key environment from the storedPokemon HashMap.
        ArrayList<Pokemon> pokemonToReturn = new ArrayList<>(pokemonInEnvironment); // Creates a copy of that ArrayList and stores it in the variable pokemonToReturn. This is so that when people get the ArrayList, they cannot modify the original in the HashMap.
        return pokemonToReturn; // Returns the copy of the ArrayList.
    }

}




















