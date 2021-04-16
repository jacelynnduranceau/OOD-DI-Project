package rowan.ood.dimicroservice.pokemon;

import java.util.Random;

public class PokemonGenFive extends PokemonGen{
    private final int MIN_ID = 494;
    private final int MAX_ID = 649;
    Random random = new Random();
    private int pokeID;

    public PokemonGenFive() {
        super();
    }

    public int generatePokeID() {
        pokeID = random.nextInt((MAX_ID - MIN_ID) + 1) + MIN_ID;
        return pokeID;
    }
}
