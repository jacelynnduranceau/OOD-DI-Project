package rowan.ood.dimicroservice.pokemon;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Random;

/**
 * @author Jacelynn Duranceau
 * @author Joseph Frost
 * @author Swanora Campbell
 * @author Marc Colin
 *
 * Class for Pokemon generation 4. Creates random pokemon id's within a range that
 * matches to this pokemon generation so that the proper pokemon can be created
 * upon DI.
 *
 */
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
