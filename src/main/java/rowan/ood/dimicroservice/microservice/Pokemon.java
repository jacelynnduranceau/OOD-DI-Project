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
    Boolean caught = false;

    public Pokemon(){}

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

    public Boolean getCaught() {
        return caught;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCaught(Boolean caught) {
        this.caught = caught;
    }
}
