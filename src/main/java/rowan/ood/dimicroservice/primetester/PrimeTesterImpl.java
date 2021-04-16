package rowan.ood.dimicroservice.primetester;

/**
 * @author Dr. Baliga
 *
 * Implementation of prime testing using BigInteger's implementation of
 * the Miller-Rabin test. Tested numbers are persisted in a H2 database
 *
 */

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import rowan.ood.dimicroservice.microservice.PrimeTester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.math.BigInteger;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

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




    public String getPokemonName(int pokeID) {

        String pokemon = "";

        try {
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("http://pokeapi.co/api/v2/pokemon/" + pokeID)
                    .get()
                    .build();

            Response response = client.newCall(request).execute();

            ResponseBody responseBody = response.body();
            String json = responseBody.string();
            JsonObject pokeInfoJson = new JsonParser().parse(json).getAsJsonObject();
            JsonElement pokeName = pokeInfoJson.get("name"); //JsonArray
            System.out.println(pokeName.toString());
            pokemon = pokeName.toString();
        }
        catch (Exception e) {
            e.getMessage();
        }

        return pokemon;
    }


}