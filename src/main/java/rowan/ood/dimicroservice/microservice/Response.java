package rowan.ood.dimicroservice.microservice;

/**
 * @author Dr. Baliga
 *
 * Web API's response for prime testing
 *
 */

public class Response {
    String number;
    Boolean answer;
    String pokeAnswer;

    public Response(String number, Boolean answer) {
        this.number = number;
        this.answer = answer;
    }

    public Response(String number, String answer) {
        this.number = number;
        this.pokeAnswer = answer;
    }


    public String getNumber() {
        return number;
    }

    public Boolean getAnswer() {
        return answer;
    }

    public String getPokeAnswer() { return pokeAnswer; }
}
