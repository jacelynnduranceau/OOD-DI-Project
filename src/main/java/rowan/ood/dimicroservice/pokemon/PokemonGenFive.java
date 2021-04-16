package rowan.ood.dimicroservice.pokemon;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Random;

public class PokemonGenFive extends PokemonGen{
    private final int MIN_ID = 494;
    private final int MAX_ID = 649;
    Random random = new Random();
    private int pokeID;

    public PokemonGenFive(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    public int generatePokeID() {
        pokeID = random.nextInt((MAX_ID - MIN_ID) + 1) + MIN_ID;
        return pokeID;
    }
}
