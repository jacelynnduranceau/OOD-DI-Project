package rowan.ood.dimicroservice.microservice.test;


/**
 * @author Dr. Baliga
 * @author Jacelynn Duranceau
 * @author Joseph Frost
 * @author Swanora Campbell
 * @author Marc Colin
 *
 * Endpoints supported by the web api
 *
 */

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rowan.ood.dimicroservice.microservice.Pokemon;

public interface Endpoints {
    @GET("pokemon-id")
    Call<Pokemon> findPokemonTestResponse(@Query("p") String p);
}