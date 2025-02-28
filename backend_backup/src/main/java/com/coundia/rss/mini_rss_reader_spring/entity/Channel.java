package com.coundia.rss.mini_rss_reader_spring.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * @author Papa Coundia
 * @created 22/04/2022 / 21:33
 * @project mini_rss_reader_spring
 */
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Channel implements Serializable {
@Id
@Column
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
@Column
private String language;
@Column
private String copyright;

@OneToMany(mappedBy = "channel" , cascade = CascadeType.ALL)
@OrderBy("pubDate desc")
private Set<Item> items  = new HashSet<>();
}
