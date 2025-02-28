package com.coundia.rss.mini_rss_reader_spring.core;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;

/**
 * @author Papa Coundia
 * @created 14/04/2022 / 22:59
 */
@Log4j2
public class MyUtils {
    /***
     *
     * @param json
     * @param elementName
     * @return JsonNode
     * @throws JsonProcessingException
     */
    public static JsonNode getJsonElelement(String json,String elementName)    {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = null;
        try {

            root = mapper.readTree(json);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            log.info("root is null !!!");
        }
        if(json ==null){
            log.info("root is null !!!");
            return null;
        }

        return root.path(elementName);
    }

}
