
import com.darktower.worldpresenter.business.timezones.entity.Continent;
import com.darktower.worldpresenter.business.timezones.entity.Country;
import java.math.BigDecimal;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Hijack
 */
public class CountriesRessourceIT {

    private Client client;
    private WebTarget wt;

    @Before
    public void init() {
        this.client = ClientBuilder.newClient();
        this.wt = this.client.target("http://localhost:8080/world-presenter-1.0/api/countries");
        basic();
        save();
    }

    public void basic() {
        Response resp = this.wt.request(MediaType.APPLICATION_JSON).get();
        assertThat(resp.getStatus(), is(200));
    }

    @Test
    public void save() {

        JsonObjectBuilder countryBuilder = Json.createObjectBuilder();
        JsonObject country = countryBuilder.add("continent", Continent.EUROPE.toString()).add("name", "Deutschland").build();
        Response resp = this.wt.request().post(Entity.json(country));
        assertThat(resp.getStatus(), is(204));
    }

    @Test
    //Testing GET with Parameter
    public void find() {
        JsonObject country = this.wt.path("42").request(MediaType.APPLICATION_JSON).get(JsonObject.class);
        assertTrue(country.getString("name").contains("42"));
    }

    @Test
    //Testing GET
    public void getAll() {
        //Get All
        Response resp = this.wt.request(MediaType.APPLICATION_JSON).get();
        JsonArray allCountries = resp.readEntity(JsonArray.class);
        assertFalse(allCountries.isEmpty());
        JsonObject country = allCountries.getJsonObject(0);
        assertNotNull(country);
        assertTrue(country.getString("name").startsWith("Deutsch"));
    }

    @Test
    //Testing DELETE with Parameter
    public void delete() {
        //automatically id generated from save()
        Response resp = this.wt.path("1").request(MediaType.APPLICATION_JSON).delete();
        assertThat(resp.getStatus(), is(204));
    }

}
