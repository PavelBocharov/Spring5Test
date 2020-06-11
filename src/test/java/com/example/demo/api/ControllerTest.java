package com.example.demo.api;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("junit")
class ControllerTest {

    @LocalServerPort
    private int port;

    @Test
    void getInfoWithoutLogin() throws IOException, URISyntaxException {
        URI uri = new URI("http://localhost:" + port + "/info");
        HttpGet get = new HttpGet(uri);

        HttpResponse response = HttpClientBuilder.create().build().execute(get);
        String responseString = EntityUtils.toString(response.getEntity());

        assertFalse(StringUtils.isEmpty(responseString), "Response entity null or empty.");
        assertTrue(responseString.contains("JUnit_test_login"), "JUnit context not used for tests.");
    }

    @Test
    void getInfoWithLogin() throws IOException, URISyntaxException {
        String login = "Roma";
        URI uri = new URI("http://localhost:" + port + "/info?login=" + login);
        HttpGet get = new HttpGet(uri);

        HttpResponse response = HttpClientBuilder.create().build().execute(get);
        String responseString = EntityUtils.toString(response.getEntity());

        assertFalse(StringUtils.isEmpty(responseString), "Response entity null or empty.");
        assertTrue(responseString.contains(login), "HelloService uncorrect work with login.");
    }
}