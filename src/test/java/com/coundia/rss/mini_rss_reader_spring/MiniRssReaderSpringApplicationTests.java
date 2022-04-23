package com.coundia.rss.mini_rss_reader_spring;

import com.coundia.rss.mini_rss_reader_spring.entity.Channel;
import com.coundia.rss.mini_rss_reader_spring.entity.Item;
import com.coundia.rss.mini_rss_reader_spring.repositories.ChannelRepository;
import com.coundia.rss.mini_rss_reader_spring.repositories.ItemRepository;
import com.coundia.rss.mini_rss_reader_spring.services.RssService;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.digester.ArrayStack;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.event.annotation.AfterTestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


@SpringBootTest
@Slf4j
@ActiveProfiles(profiles = "dev")
class MiniRssReaderSpringApplicationTests {
    //variables pour les tests

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private RssService rssService;
    //charger avant les tests
    @BeforeEach
    public void setup() {
        log.info("***********DEBUT TEST **********");
//        itemRepository.deleteAll();
        Item item=Item.builder()
                .id(1L).title("Title 1")
                .imageUrl("https://img.lemde.fr/2022/04/18/228/0/3500/1750/644/322/60/0/5bbd6c4_none-mexico-electricity-0418-11.jpg")
                .description("Desc Title 1").build();

        itemRepository.save(item);
    }
   @AfterTestMethod
    void tearDown() {
       log.info("***********DEBUT TEST **********");
       Item item=itemRepository.findById(1L).get();
       itemRepository.delete(item);
   }
    @Test
    void contextLoads() {
    }

    /***
     * tester modification de titre
     */
    @Test
    void testerEditTitleJpa(){
        log.info("*********** testerEditTitleJpa () **********");
        Item item= itemRepository.findById(1L).get();
        item.setTitle("Title Edite");
        String edit=itemRepository.save(item).getTitle();
        Assertions.assertEquals("Title Edite", edit);
    }

    /***
     * tester modification de titre
     */
    @Test
    void testerEditDescriptionJpa(){
        log.info("*********** testerEditDescriptionJpa () **********");
        Item item= itemRepository.findById(1L).get();
        item.setDescription("Desc Edite");
        String edit=itemRepository.save(item).getDescription();
        Assertions.assertEquals("Desc Edite", edit);
    }
    //tdd tester status
    @Test
    void testerStatus(){
        String st=rssService.getStatus("UP");
        Assertions.assertEquals("UP", st);
    }
    //tdd lire les flux rss   monde
    @Test
    void testerVerifierExistanceSuccess() {
        boolean ok=rssService.verifierExistance("https://img.lemde.fr/2022/04/18/228/0/3500/1750/644/322/60/0/5bbd6c4_none-mexico-electricity-0418-11.jpg").isPresent();
        Assertions.assertTrue(ok);
    }
    //tdd lire les flux rss   monde
    @Test
    void testerVerifierExistanceKO() {
        boolean ok=rssService.verifierExistance("bad.png").isPresent();
        Assertions.assertFalse(ok);
    }

}
