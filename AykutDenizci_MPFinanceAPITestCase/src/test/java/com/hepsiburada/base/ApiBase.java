package com.hepsiburada.base;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.hepsiburada.constants.ApiBaseConstants.*;

public class ApiBase {
    public final Logger logger = LogManager.getLogger(ApiBase.class);
    WireMockServer wireMockServer;

    @BeforeScenario
    public void setupStub() {
        logger.info("Mock servisler hazırlanıyor");
        wireMockServer = new WireMockServer(9999);
        wireMockServer.start();
        configureFor("127.0.0.1", 9999);
        stubFor(get(urlMatching("/allGrocery"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("getRequest.json")));

        stubFor(get(urlPathEqualTo("/allGrocery/1")).atPriority(1)
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("getRequest1.json")));

        stubFor(get(urlPathEqualTo("/allGrocery/2")).atPriority(1)
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("getRequest2.json")));

        //1 ve 2 dışında herhangi bir değer geldiğinde 404 dönmesi için yazılmış servis
        stubFor(get(urlMatching("/allGrocery/.*"))
                .atPriority(2)
                .willReturn(aResponse()
                        .withStatus(404)
                        .withHeader("Content-Type", "application/json")
                        .withBody(GET_ERROR_BODY)));

        //id-name-price veya stock parametrelerinden biri eksik gittiğinde 400 dönmesi için yazılmış servisler

        stubFor(any(urlPathEqualTo("/add"))
                .atPriority(1)
                .withRequestBody(matching("^((?!id).)*$"))
                .willReturn(aResponse()
                        .withStatus(400)
                        .withHeader("Content-Type", "application/json")
                        .withBody(POST_ID_MISSING_ERROR)));

        stubFor(any(urlPathEqualTo("/add"))
                .atPriority(1)
                .withRequestBody(matching("^((?!name).)*$"))
                .willReturn(aResponse()
                        .withStatus(400)
                        .withHeader("Content-Type", "application/json")
                        .withBody(POST_NAME_MISSING_ERROR)));

        stubFor(any(urlPathEqualTo("/add"))
                .atPriority(1)
                .withRequestBody(matching("^((?!price).)*$"))
                .willReturn(aResponse()
                        .withStatus(400)
                        .withHeader("Content-Type", "application/json")
                        .withBody(POST_PRICE_MISSING_ERROR)));

        stubFor(any(urlPathEqualTo("/add"))
                .atPriority(1)
                .withRequestBody(matching("^((?!stock).)*$"))
                .willReturn(aResponse()
                        .withStatus(400)
                        .withHeader("Content-Type", "application/json")
                        .withBody(POST_STOCK_MISSING_ERROR)));

        stubFor(any(urlEqualTo("/add")).atPriority(2)
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(POST_SUCCESSFUL_MESSAGE)));

        logger.info("Mock servisler hazırlandı");
    }

    @AfterScenario
    public void tearDown() {
        logger.info("Mock servisler kapatılıyor");
        wireMockServer.stop();
        logger.info("Mock servisler kapatıldı");
    }

}
