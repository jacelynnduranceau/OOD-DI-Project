package rowan.ood.dimicroservice.microservice.test;

/**
 * @author Dr. Baliga
 *
 * Mock configuration for testing the microservice
 *
 */

import rowan.ood.dimicroservice.pokemon.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.*;

import static org.mockito.Mockito.when;


@Configuration
public class ConfigTest {

    @Mock
    PokemonGen mockPokemonGen;

    // Test suite
    static Map<String,String> tests = new HashMap<>() {{
        put("1", "bulbasaur");
        put("197", "umbreon");
        put("258", "mudkip");
        put("446", "munchlax");
        put("570", "zorua");
        put("710", "pumpkaboo-average");
        put("724", "decidueye");
        put("865", "sirfetchd");
    }};

    @Bean
    PokemonGen getMockPokemonGenTester() {
        MockitoAnnotations.openMocks(this);
        for (String v : tests.keySet())
            when(mockPokemonGen.getPokemonName(Integer.parseInt(v))).thenReturn(tests.get(v));
        return mockPokemonGen;
    }

    // Named bean example
    @Bean(name = "pokemonToTest")
    @Primary
    public static Map<String, String> getTests() {
        return tests;
    }
}
