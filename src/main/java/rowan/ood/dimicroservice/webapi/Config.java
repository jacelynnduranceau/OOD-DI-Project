package rowan.ood.dimicroservice.webapi;

/**
 * @author Dr. Baliga
 *
 * DI configuration for the web api
 *
 */

import rowan.ood.dimicroservice.microservice.PokeMicroservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import rowan.ood.dimicroservice.pokemon.*;

@Configuration
public class Config {

    // H2 database jdbc connector injected by Spring.
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Bean
    public PokemonGen getPokemon() {
        return new PokemonGenOne(jdbcTemplate);
    }

    @Bean
    public PokeMicroservice getPrimeMicroService() {
        return new PokeMicroservice(this.getPokemon());
    }
}
