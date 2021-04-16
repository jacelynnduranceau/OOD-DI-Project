package rowan.ood.dimicroservice.pokemon;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Random;

public class PokemonGenFour extends PokemonGen{
    private final int MIN_ID = 387;
    private final int MAX_ID = 493;
    Random random = new Random();
    private int pokeID;

    public PokemonGenFour(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    public int generatePokeID() {
        pokeID = random.nextInt((MAX_ID - MIN_ID) + 1) + MIN_ID;
        return pokeID;
    }
}