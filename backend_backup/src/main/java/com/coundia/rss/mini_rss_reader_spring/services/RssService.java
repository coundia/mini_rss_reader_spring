package com.coundia.rss.mini_rss_reader_spring.services;

import com.coundia.rss.mini_rss_reader_spring.entity.Channel;
import com.coundia.rss.mini_rss_reader_spring.entity.Item;
import com.coundia.rss.mini_rss_reader_spring.repositories.ChannelRepository;
import com.coundia.rss.mini_rss_reader_spring.repositories.ItemRepository;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import lombok.extern.log4j.Log4j2;
import org.jdom2.Element;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Papa Coundia
 * @created 20/04/2022 / 08:36
 * @project mini_rss_reader_spring
 */
@Service
@Log4j2
public class RssService {
    private ItemRepository itemRepository;
    private ChannelRepository channelRepository;

    public RssService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public String getStatus(String status) {
        return status;
    }

    /***
     *
     * @param url url le mode
     * @return List
     */
    public List<Item> getFluxLeMonde(String url) {
        log.info("******************* getFluxLeMonde () ****************");
        List<Item> list = new ArrayList<>();
        try {

            Item item;
            try (XmlReader reader = new XmlReader(new URL(url))) {
                SyndFeed flux = new SyndFeedInput().build(reader);
                log.info("***********************************");
                log.info(flux.getTitle());
                String imgURL = "";
                Optional<Item> itemExistant;
                log.info("***********************************");
                for (SyndEntry entry : flux.getEntries()) {
                    //log.info(entry);
                    imgURL = "";
                    //get image
                    List<Element> foreignMarkups = (List<Element>) entry.getForeignMarkup();
                    for (Element foreignMarkup : foreignMarkups) {
                        imgURL = foreignMarkup.getAttribute("url").getValue();
                    }
                    log.info(imgURL);
                    //get image end
                    //si il nexiste pas dans la base on le cree
                    itemExistant = verifierExistance(imgURL);
                    if (itemExistant.isPresent()) {
                        log.info("** EXISTE DEJA **");
                        list.add(itemExistant.get());
                    } else {
                        log.info("**  CREATION : {}  **", entry.getTitle());
                        item = Item.builder()
                                .title(entry.getTitle())
                                .description(entry.getDescription().getValue())
                                .imageUrl(imgURL)
                                .link(entry.getLink())
                                .pubDate(entry.getPublishedDate())
                                .build();
                        itemRepository.save(item);
                        list.add(item);
                    }
                    log.info("***********************************");
                }
                log.info("Done");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //verifier si l'article existe dans la base
    public Optional<Item> verifierExistance(String imgURL) {
        return itemRepository.findDistinctByImageUrl(imgURL);
    }

    public Channel saveChannel(Channel channel) {
        return channelRepository.save(channel);
    }
}
