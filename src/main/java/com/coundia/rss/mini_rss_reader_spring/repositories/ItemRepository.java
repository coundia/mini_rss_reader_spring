package com.coundia.rss.mini_rss_reader_spring.repositories;

import com.coundia.rss.mini_rss_reader_spring.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

/**
 * @author Papa Coundia
 * @created 20/04/2022 / 08:36
 * @project mini_rss_reader_spring
 */
@RepositoryRestResource(path="items")
public interface ItemRepository extends JpaRepository<Item,Long> {

   Optional<Item> findDistinctByImageUrl(String imgURL);
}

