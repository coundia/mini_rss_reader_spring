package com.coundia.rss.mini_rss_reader_spring.repositories;

import com.coundia.rss.mini_rss_reader_spring.entity.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Papa Coundia
 * @created 22/04/2022 / 21:43
 * @project mini_rss_reader_spring
 */
@RepositoryRestResource(path="channels")
public interface ChannelRepository extends JpaRepository<Channel,Long> {
}
