package rowan.ood.dimicroservice.pokemon;


import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import rowan.ood.dimicroservice.microservice.Pokemon;

public abstract class PokemonGen {

    abstract int generatePokeID();

    public Pokemon generatePokemon(int pokeID){
        Pokemon pokemon = new Pokemon(String.valueOf(pokeID), getPokemonName(pokeID),
                              getPokemonHeight(pokeID),
                              getPokemonWeight(pokeID),
                              getPokemonType(pokeID));
        return pokemon;
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
