package fi.solita.cd;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import spark.Spark;

public class HelloIT {

    public static final int PORT = 4567;
    public static final String BASE_URL = "http://localhost:" + PORT;

    @BeforeClass
    public static void startServer() {
        Spark.port(PORT);
        Hello.main(new String[]{});
        Spark.awaitInitialization();
    }

    @AfterClass
    public static void stopServer() {
        Spark.stop();
    }

    @Test
    public void foo() throws ClientProtocolException, IOException {
        String response = Request.Get(BASE_URL).execute().returnContent().asString();
        assertTrue(response.contains("Hello, World!"));
    }

}
