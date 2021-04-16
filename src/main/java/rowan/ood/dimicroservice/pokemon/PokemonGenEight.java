package rowan.ood.dimicroservice.pokemon;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Random;

public class PokemonGenEight extends PokemonGen{
    private final int MIN_ID = 810;
    private final int MAX_ID = 898;
    Random random = new Random();
    private int pokeID;

    public PokemonGenEight(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    public int generatePokeID() {
        pokeID = random.nextInt((MAX_ID - MIN_ID) + 1) + MIN_ID;
        return pokeID;
    }

}