package rowan.ood.dimicroservice.primetester;

/**
 * @author Dr. Baliga
 *
 * Implementation of prime testing using BigInteger's implementation of
 * the Miller-Rabin test. Tested numbers are persisted in a H2 database
 *
 */

import eu.iamgio.pokedex.pokemon.Pokemon;
import rowan.ood.dimicroservice.microservice.PrimeTester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.math.BigInteger;

@Component
public class PrimeTesterImpl implements PrimeTester {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PrimeTesterImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        jdbcTemplate.execute("DROP TABLE primetests IF EXISTS");
        jdbcTemplate.execute(
                "CREATE TABLE primetests(" +
                        "id SERIAL, " +
                        "number VARCHAR(255), " +
                        "answer INT)"
        );
    }

    public boolean isPrime(String p) {

        final int Certainty = 30;
        String querystr = String.format("SELECT answer FROM primetests WHERE number = '%s'", p);

        // First check if the provided string is in the database
        try {
            Integer answer = jdbcTemplate.queryForObject(querystr, Integer.class);
            return answer == 0 ? false : true;
        } catch (Exception e) {
            // Not found in the db, so run the Miller Rabin test and store the result in the db
            boolean answer = (new BigInteger(p)).isProbablePrime(Certainty);
            querystr = String.format("INSERT into primetests (number,answer) VALUES ('%s',%d)", p, answer ? 1 : 0);
            jdbcTemplate.execute(querystr);
            return answer;
        }
    }

    public String isPokemon(String p) {
        Pokemon pokemon = Pokemon.fromId(Integer.valueOf(p));
        return pokemon.getName();
    }



}