package rowan.ood.dimicroservice.microservice;

/**
 * @author Dr. Baliga
 * @author Jacelynn Duranceau
 * @author Joseph Frost
 * @author Swanora Campbell
 * @author Marc Colin
 *
 * Web API's response for pokemon testing
 *
 */

public class Pokemon {
    String id;
    String name;
    String height;
    String weight;
    String type;


    public Pokemon(String id, String name, String height, String weight, String type) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.type = type;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
