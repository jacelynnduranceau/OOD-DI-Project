package rowan.ood.dimicroservice.microservice;

/**
 * @author Dr. Baliga
 * @author Jacelynn Duranceau
 * @author Joseph Frost
 * @author Swanora Campbell
 * @author Marc Colin
 *
 * Implements the prime testing microservice. DI is used to inject
 * a prime testing implementation.
 *
 */

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.http.Query;
import rowan.ood.dimicroservice.pokemon.PokemonGen;

@Service
@RestController
public class PokeMicroservice {

    PokemonGen pokemonGen;

    @Autowired
    public PokeMicroservice(PokemonGen pokemonGen) {
        this.pokemonGen = pokemonGen;
    }

    @GetMapping("/pokeinfo")
    public String info() {
        return "Gotta Catch 'em All!";
    }

    @GetMapping("/pokemon")
    public String randomPokemon() {
        // Use the injected pokemon to show its information (id, name, height, weight, type).
        return new Gson().toJson(pokemonGen.generatePokemon());
    }

    @GetMapping("/pokemon-id")
    public String findPokemon(@Query(value = "p") String p) {
        // Use the injected pokemon based on the query string (the id = p). This can be used for testing.
        try {
            return new Gson().toJson(pokemonGen.generatePokemon(Integer.parseInt(p)));
        }
        catch (NumberFormatException e) {
            e.getMessage();
            return new Gson().toJson("Error, Enter a Number");
        }
    }
}