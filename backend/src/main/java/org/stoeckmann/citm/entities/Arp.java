package org.stoeckmann.citm.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * CREATE TABLE `arps` (
 * 	`id`	INTEGER NOT NULL,
 * 	`sol_id`	INTEGER NOT NULL,
 * 	`pol_id`	INTEGER NOT NULL,
 * 	`capture_date`	TIMESTAMP NOT NULL DEFAULT ''1990-01-01 00:00:00'',
 * 	`decoding_date`	TIMESTAMP NOT NULL DEFAULT 'CURRENT_TIMESTAMP',
 * 	`viewed_date`	TIMESTAMP NOT NULL DEFAULT ''1990-01-01 00:00:00'',
 * 	`first_visualization_user_id`	INTEGER NOT NULL DEFAULT '0',
 * 	`flow_info`	VARCHAR(255) NOT NULL,
 * 	`mac`	VARCHAR(4096),
 * 	`ip`	VARCHAR(255),
 * 	PRIMARY KEY(id)
 * );
 */
@Entity
@Table(name = "arps")
public class Arp {
  @Id
  private Integer id;

  private String mac;

  private String ip;

  public String getMac() {
    return mac;
  }

  public String getIp() {
    return ip;
  }
}
