
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Assert;
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
    private WebTarget tut;

    @Before
    public void init() {
        this.client = ClientBuilder.newClient();
        this.tut = this.client.target("http://localhost:8080/world-presenter-1.0/api/countries");
    }

    @Test
    public void crud() {
//        Response resp = this.tut.request(MediaType.TEXT_PLAIN).get();
//        String payload = resp.readEntity(String.class);
//        System.out.println("payload = " + payload);
//        Assert.assertTrue(payload.startsWith("core"));
        Response resp = this.tut.request(MediaType.APPLICATION_JSON).get();
        assertThat(resp.getStatus(), is(200));
        JsonObject payload = resp.readEntity(JsonObject.class);
        System.out.println("payload = " + payload);
        assertTrue(payload.getString("name").startsWith("Deutsch"));

    }

}
