//package rowan.ood.dimicroservice.microservice.test;
//
//
///**
// * @author Dr. Baliga
// *
// * Web API unit test using Retrofit client
// *
// */
//
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import rowan.ood.dimicroservice.microservice.PrimeTester;
//import rowan.ood.dimicroservice.microservice.Pokemon;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
////import org.springframework.context.annotation.ComponentScan;
//import retrofit2.Call;
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;
//
//import java.util.Set;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@ExtendWith(MockitoExtension.class)
//public class PrimeMicroserviceTest {
//
//    static Endpoints endpoints;
//    static final String BaseUrl = "http://127.0.0.1:8080/"; // Location of the web api
//    static PrimeTester mockPrimeTester;
//    static Set<String> numbersToTest;
//
//    @BeforeAll
//    static void init() {
//
//        Gson gson = new GsonBuilder().create();
//        Retrofit client = new Retrofit
//                .Builder()
//                .baseUrl(BaseUrl)
//                .addConverterFactory(GsonConverterFactory.create(gson))
//                .build();
//
//        endpoints = client.create(Endpoints.class);
//
//        // Perform the injection and retrieve testing beans
//        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigTest.class);
//        mockPrimeTester = context.getBean(PrimeTester.class);
//        numbersToTest = (Set<String>) context.getBean("numbersToTest");
//
//    }
//
//    // Test microservice using numbers listed within the mock prime tester.
//    @Test
//    void primeChecks() {
//        try {
//            // Test all numbers in the test suite
//            for (String number : numbersToTest) {
//
//                // Invoke the webapi to compute the answer
//                Call<Pokemon> primeTestResponse = endpoints.getPrimeTestResponse(number);
//                Pokemon resp = primeTestResponse.execute().body();
//                assertNotNull(resp);
//
//               // assertEquals(resp.getNumber(), number);
//                // Verify that the webapi's answer is the same as the mock test's answer
//               // assertEquals(resp.getAnswer(), mockPrimeTester.isPrime(number));
//            }
//        } catch (Exception e) {
//            assertTrue(false);
//        }
//    }
//}
