package rowan.ood.dimicroservice.pokemon;

import rowan.ood.dimicroservice.microservice.Pokemon;

import java.util.Random;

public class PokemonGenTwo extends PokemonGen{
    private final int MIN_ID = 152;
    private final int MAX_ID = 251;
    Random random = new Random();
    private int pokeID;

    public PokemonGenTwo() {
        super();
    }

    public int generatePokeID() {
        pokeID = random.nextInt((MAX_ID - MIN_ID) + 1) + MIN_ID;
        return pokeID;
    }
}
