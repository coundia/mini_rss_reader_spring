package com.coundia.rss.mini_rss_reader_spring.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Papa Coundia
 * @created 20/04/2022 / 08:20
 * @project mini_rss_reader_spring
 */
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Item implements Serializable {
    @Id
    @Column
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition="TEXT")
    private String title;
    @Column
    private String link;
    @Column(columnDefinition="TEXT")
    private String description;
    @Column
    private String imageUrl;
    @Column
    private Date pubDate;
}
