package rowan.ood.dimicroservice.pokemon;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Random;

public class PokemonGenSix extends PokemonGen{
    private final int MIN_ID = 650;
    private final int MAX_ID = 721;
    Random random = new Random();
    private int pokeID;

    public PokemonGenSix(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    public int generatePokeID() {
        pokeID = random.nextInt((MAX_ID - MIN_ID) + 1) + MIN_ID;
        return pokeID;
    }
}
