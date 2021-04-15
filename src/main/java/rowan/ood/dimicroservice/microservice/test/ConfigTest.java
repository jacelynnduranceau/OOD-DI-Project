package rowan.ood.dimicroservice.microservice.test;

/**
 * @author Dr. Baliga
 *
 * Mock configuration for testing the microservice
 *
 */

import rowan.ood.dimicroservice.microservice.PrimeTester;
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
    PrimeTester mockPrimeTester;

    // Test suite
    static Map<String,Boolean> tests = new HashMap<>() {{
        put("2", true);
        put("3", true);
        put("4", false);
        put("5", true);
        put("6", false);
        put("20988936657440586486151264256610222593863921", true);
        put("140634627991438082181778195596483497841709911955057", false);
    }};

    @Bean
    PrimeTester getMockPrimeTester() {
        MockitoAnnotations.openMocks(this);
        for (String v : tests.keySet())
            when(mockPrimeTester.isPrime(v)).thenReturn(tests.get(v));
        return mockPrimeTester;
    }

    // Named bean example
    @Bean(name = "numbersToTest")
    @Primary
    public static Set<String> getTests() {
        return tests.keySet();
    }
}
