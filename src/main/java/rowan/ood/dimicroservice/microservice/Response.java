package rowan.ood.dimicroservice.microservice;

/**
 * @author Dr. Baliga
 *
 * Web API's response for prime testing
 *
 */

public class Response {
    String number;
    String answer;

    public Response(String number, String answer) {
        this.number = number;
        this.answer = answer;
    }

    public String getNumber() {
        return number;
    }

    public String getAnswer() {
        return answer;
    }
}
