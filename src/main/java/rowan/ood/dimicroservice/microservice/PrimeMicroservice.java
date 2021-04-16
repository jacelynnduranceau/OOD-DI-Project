package rowan.ood.dimicroservice.microservice;

/**
 * @author Dr. Baliga
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
import rowan.ood.dimicroservice.pokemon.PokemonGenOne;

@Service
@RestController
public class PrimeMicroservice {

    PrimeTester primeTester;

    @Autowired
    public PrimeMicroservice(PrimeTester primeTester) {
        this.primeTester = primeTester;
    }

    @GetMapping("/pokeinfo")
    public String info() {
        return "Gotta Catch 'em All!";
    }

    @GetMapping("/pokemon")
    public String primetest(@Query(value = "p") String p) {
        // Use the injected prime tested to test for primality.
        PokemonGenOne pokeOne = new PokemonGenOne();
        Pokemon pokemon = pokeOne.generatePokemon();
        return new Gson().toJson(pokemon);
    }

}