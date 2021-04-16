package rowan.ood.dimicroservice.pokemon;

import java.util.Random;

public class PokemonGenSeven extends PokemonGen{
    private final int MIN_ID = 722;
    private final int MAX_ID = 809;
    Random random = new Random();
    private int pokeID;

    public PokemonGenSeven() {
        super();
    }

    public int generatePokeID() {
        pokeID = random.nextInt((MAX_ID - MIN_ID) + 1) + MIN_ID;
        return pokeID;
    }
}
