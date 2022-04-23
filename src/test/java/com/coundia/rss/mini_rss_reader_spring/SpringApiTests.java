package com.coundia.rss.mini_rss_reader_spring;

/**
 * @author Papa Coundia
 * @created 22/04/2022 / 22:10
 * @project mini_rss_reader_spring
 */

import com.coundia.rss.mini_rss_reader_spring.entity.Channel;
import com.coundia.rss.mini_rss_reader_spring.entity.Item;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles(profiles = "test")
@ContextConfiguration
@Log4j2
@SpringBootTest(classes = MiniRssReaderSpringApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SpringApiTests {

    private TestRestTemplate restTemplate = new TestRestTemplate();
    private static String BASE_URI = "http://localhost:8787/api/v1/rss";

    @Test
    public void testContext(){

    }
    @Test
      void saveChanelCorrectTests() {
        log.info("*********** saveChanelCorrectTests () **********");
        //creer un channel
        Channel channel = Channel.builder()
                .id(1L)
                .title("Continue")
                .build();

        Item item1 = Item.builder()
                .id(1L).title("Continue in 2 ")
                .imageUrl("https://img.lemde.fr/2022/04/18/228/0/3500/1750/644/322/60/0/5bbd6c4_none-mexico-electricity-0418-11.jpg")
                .description("Desc Title 1").build();
        Item item2 = Item.builder()
                .id(2L).title("Continue in 2 ")
                .imageUrl("https://img.lemde.fr/2022/04/18/228/0/3500/1750/644/322/60/0/5bbd6c4_none-mexico-electricity-0418-11.jpg")
                .description("Desc Title 2").build();

        restTemplate.postForEntity(BASE_URI + "/channels", channel, Channel.class);
        restTemplate.postForEntity(BASE_URI + "/items", item1, Item.class);
        restTemplate.postForEntity(BASE_URI + "/items", item2, Item.class);
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Content-Type", "text/uri-list");
        HttpEntity<String> itemHttpEntity   = new HttpEntity<>(BASE_URI + "/channels" + "/1", requestHeaders);
        restTemplate.exchange(BASE_URI + "/items" + "/1/channel", HttpMethod.PUT, itemHttpEntity, String.class);
        restTemplate.exchange(BASE_URI + "/items" + "/2/channel", HttpMethod.PUT, itemHttpEntity, String.class);
        //recuperer la channel  de item 1
        ResponseEntity<Channel> channelGetResponse = restTemplate.getForEntity(BASE_URI + "/items" + "/1/channel", Channel.class);
        assertEquals(channelGetResponse.getBody().getTitle(), "Continue");
    }
}
