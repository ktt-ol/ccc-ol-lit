package org.stoeckmann.citm.domain.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * CREATE TABLE `webs` (
 * 	`id`	INTEGER NOT NULL,
 * 	`sol_id`	INTEGER NOT NULL,
 * 	`pol_id`	INTEGER NOT NULL,
 * 	`source_id`	INTEGER NOT NULL,
 * 	`web_id`	INTEGER DEFAULT '-1',
 * 	`capture_date`	TIMESTAMP NOT NULL DEFAULT ''1990-01-01 00:00:00'',
 * 	`decoding_date`	TIMESTAMP NOT NULL DEFAULT 'CURRENT_TIMESTAMP',
 * 	`viewed_date`	TIMESTAMP NOT NULL DEFAULT ''1990-01-01 00:00:00'',
 * 	`first_visualization_user_id`	INTEGER,
 * 	`flow_info`	VARCHAR(255) NOT NULL,
 * 	`url`	VARCHAR(4096),
 * 	`relation`	VARCHAR(40) DEFAULT ''NONE'',
 * 	`method`	VARCHAR(10) NOT NULL,
 * 	`response`	VARCHAR(5) NOT NULL,
 * 	`agent`	TEXT,
 * 	`host`	VARCHAR(255) NOT NULL,
 * 	`content_type`	VARCHAR(255) NOT NULL,
 * 	`rq_header`	VARCHAR(255),
 * 	`rq_body`	VARCHAR(255),
 * 	`rq_bd_size`	INTEGER,
 * 	`rs_header`	VARCHAR(255),
 * 	`rs_body`	VARCHAR(255),
 * 	`rs_bd_size`	INTEGER,
 * 	PRIMARY KEY(id)
 * ); */
@Entity
@Table(name = "webs")
public class Web {
  @Id
  private int id;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "source_id")
  private Source source;

  private String url;
  private String method;
  private String agent;
  private String host;

  public Source getSource() {
    return source;
  }

  public String getURL() {
    return url;
  }

  public String getMethod() {
    return method;
  }

  public String getAgent() {
    return agent;
  }

  public String getHost() {
    return host;
  }
}
