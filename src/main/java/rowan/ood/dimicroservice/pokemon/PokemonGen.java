package rowan.ood.dimicroservice.pokemon;


import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import rowan.ood.dimicroservice.microservice.Pokemon;

import java.sql.ResultSet;


/**
 * @author Jacelynn Duranceau
 * @author Joseph Frost
 * @author Swanora Campbell
 * @author Marc Colin
 *
 * Abstract class for Pokemon generations. Creates Pokemon objects based on
 * pokemon IDs.
 *
 */
public abstract class PokemonGen {

    private JdbcTemplate jdbcTemplate;

    public PokemonGen(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
        jdbcTemplate.execute("DROP TABLE caughtpokemon IF EXISTS");
        jdbcTemplate.execute(
                "CREATE TABLE caughtpokemon(" +
                        "id SERIAL, " +
                        "poke_id VARCHAR(255), " +
                        "name VARCHAR(255), " +
                        "height VARCHAR(255), " +
                        "weight VARCHAR(255), " +
                        "type VARCHAR(255))"

        );
    }

    abstract int generatePokeID();

    public Pokemon generatePokemon(int pokeID){

        var querystr = "SELECT * FROM caughtpokemon WHERE poke_id = ?";

        var rm = (RowMapper<Pokemon>) (ResultSet result, int rowNum) -> {

            var pokemon = new Pokemon();

            pokemon.setId(result.getString("poke_id"));
            pokemon.setName(result.getString("name"));
            pokemon.setHeight(result.getString("height"));
            pokemon.setWeight(result.getString("weight"));
            pokemon.setType(result.getString("type"));
            pokemon.setCaught(true);

            return pokemon;
        };

        try {
            Pokemon pokemon = (Pokemon) jdbcTemplate.queryForObject(querystr, new Object[]{pokeID}, rm);
            return pokemon;
        }
        catch(Exception e) {
            Pokemon pokemon = new Pokemon(String.valueOf(pokeID), getPokemonName(pokeID),
                                        getPokemonHeight(pokeID),
                                        getPokemonWeight(pokeID),
                                        getPokemonType(pokeID));
            querystr = String.format("INSERT into caughtpokemon (poke_id,name,height,weight,type) " +
                                    "VALUES ('%s','%s','%s','%s','%s')",
                                    pokeID,getPokemonName(pokeID),
                                    getPokemonHeight(pokeID),
                                    getPokemonWeight(pokeID),
                                    getPokemonType(pokeID));
            jdbcTemplate.execute(querystr);
            return pokemon;
        }
    }

    public Pokemon generatePokemon(){
        return generatePokemon(generatePokeID());
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
            pokemon = pokeName.toString().replaceAll("\"", "");
        }
        catch (Exception e) {
            e.getMessage();
        }
        return pokemon;
    }

    public String getPokemonHeight(int pokeID) {

        String height = "";

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
            JsonElement pokeHeight = pokeInfoJson.get("height"); //JsonArray
            height = pokeHeight.toString();
        }
        catch (Exception e) {
            e.getMessage();
        }

        return height;
    }

    public String getPokemonWeight(int pokeID) {

        String weight = "";

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
            JsonElement pokeWeight = pokeInfoJson.get("weight"); //JsonArray
            weight = pokeWeight.toString();
        }
        catch (Exception e) {
            e.getMessage();
        }

        return weight;
    }

    public String getPokemonType(int pokeID) {

        String type = "";

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
            JsonElement pokeType = pokeInfoJson.get("types"); //JsonArray
            JsonElement pokeTypeEle = pokeType.getAsJsonArray().get(0);
            JsonObject pokeTypeJson = pokeTypeEle.getAsJsonObject();
            JsonElement pokeTypeName = pokeTypeJson.get("type");
            JsonObject jsonType = pokeTypeName.getAsJsonObject();
            JsonElement typeName = jsonType.get("name");
            type = typeName.toString().replaceAll("\"", "");
        }
        catch (Exception e) {
            e.getMessage();
        }

        return type;
    }
}
