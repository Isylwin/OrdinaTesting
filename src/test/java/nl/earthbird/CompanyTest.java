package nl.earthbird;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class CompanyTest {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8888); // No-args constructor defaults to port 8080

    @Test
    public void testSend() {
        /*WireMockServer wireMockServer = new WireMockServer(8888);
        wireMockServer.start();*/
        WireMock wiremock = new WireMock(8888);
        wiremock.register(post(urlEqualTo("/BigCompany"))
                .withRequestBody(containing("me"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody("0")));
        Company ordina = new Company(new JavaDeveloper("me"));
        ordina.send(new Contractor("BigCompany"));
        wiremock.verifyThat(WireMock.postRequestedFor(urlEqualTo("/BigCompany")));
    }
}
