package fi.solita.cd;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.junit.Test;

public class HelloTest {

    @Test
    public void foo() throws ClientProtocolException, IOException {
        String response = Request.Get("http://localhost:4567").execute().returnContent().asString();
        assertTrue(response.contains("Hello, World!"));
    }

}
