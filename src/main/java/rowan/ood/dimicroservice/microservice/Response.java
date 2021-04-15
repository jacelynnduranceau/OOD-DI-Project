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

    public Response(String number, Boolean answer) {
        this.number = number;
        this.answer = answer;
    }

    public String getNumber() {
        return number;
    }

    public Boolean getAnswer() {
        return answer;
    }
}
