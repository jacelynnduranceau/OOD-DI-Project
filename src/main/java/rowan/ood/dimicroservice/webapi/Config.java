package rowan.ood.dimicroservice.webapi;

/**
 * @author Dr. Baliga
 *
 * DI configuration for the web api
 *
 */

import rowan.ood.dimicroservice.microservice.PrimeMicroservice;
import rowan.ood.dimicroservice.microservice.PrimeTester;
import rowan.ood.dimicroservice.primetester.PrimeTesterImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import rowan.ood.dimicroservice.pokemon.*;

@Configuration
public class Config {

    // H2 database jdbc connector injected by Spring. How convenient!
    @Autowired
    JdbcTemplate jdbcTemplate;

//    @Bean
//    public PrimeTester getPrimeTester() {
//        return new PrimeTesterImpl(jdbcTemplate);
//    }
//
//    @Bean
//    public PrimeMicroservice getPrimeMicroService() {
//        return new PrimeMicroservice(this.getPrimeTester());
//    }

    @Bean
    public PokemonGen getPokemon() {
        return new PokemonGenSeven(jdbcTemplate);
    }

    @Bean
    public PrimeMicroservice getPrimeMicroService() {
        return new PrimeMicroservice(this.getPokemon());
    }
}
