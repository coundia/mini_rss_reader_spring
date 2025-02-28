package com.coundia.rss.mini_rss_reader_spring.api;

import com.coundia.rss.mini_rss_reader_spring.entity.Channel;
import com.coundia.rss.mini_rss_reader_spring.entity.Item;
import com.coundia.rss.mini_rss_reader_spring.services.RssService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Papa Coundia
 * @created 20/04/2022 / 08:37
 * @project mini_rss_reader_spring
 */
@RestController
@RequestMapping("/api/v1/rss")
public class RssApi {

    private RssService rssService;
    @Value("${URI_RSS_MONDE}")
    private String uri;

    public RssApi(RssService rssService) {
        this.rssService = rssService;
    }
    //tester api
    @GetMapping("status")
    public String getStatus() {
        return rssService.getStatus("UP");
    }
    //actualiser flux
    @GetMapping("refresh")
    public  List<Item> refreshFlux() {
        return  rssService.getFluxLeMonde(uri);
    }
    //charger
    @PostMapping("refreshByChannel")
    public  List<Item> refreshByUri(@RequestBody Channel channel) {

        if(!rssService.saveChannel(channel).getLink().isEmpty())
        return  rssService.getFluxLeMonde(channel.getLink());
        else
        return new ArrayList<>();

    }

}
