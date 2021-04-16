package rowan.ood.dimicroservice.pokemon;

import rowan.ood.dimicroservice.microservice.Pokemon;

import java.util.Random;

public class PokemonGenThree extends PokemonGen{
    private final int MIN_ID = 252;
    private final int MAX_ID = 386;
    Random random = new Random();
    private int pokeID;

    public PokemonGenThree() {
        super();
    }

    public int generatePokeID() {
        pokeID = random.nextInt((MAX_ID - MIN_ID) + 1) + MIN_ID;
        return pokeID;
    }
}
