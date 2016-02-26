package fi.solita.cd;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import spark.Spark;

public class HelloIT {

    public static final int SERVER_PORT = 4567;
    public static final String SERVER_URL = "http://localhost:" + SERVER_PORT;

    @BeforeClass
    public static void startServer() {
        Spark.port(SERVER_PORT);
        Hello.main(new String[]{});
        Spark.awaitInitialization();
    }

    @AfterClass
    public static void stopServer() {
        Spark.stop();
    }

    @Test
    public void foo() throws ClientProtocolException, IOException {
        String response = Request.Get(SERVER_URL).execute().returnContent().asString();
        assertTrue(response.contains("Hello, World!"));
    }

}
