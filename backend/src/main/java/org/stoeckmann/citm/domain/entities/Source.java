package org.stoeckmann.citm.domain.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * CREATE TABLE `sources` (
 * 	`id`	INTEGER NOT NULL,
 * 	`sol_id`	INTEGER NOT NULL,
 * 	`pol_id`	INTEGER NOT NULL,
 * 	`ip`	VARCHAR(255) NOT NULL,
 * 	`name`	VARCHAR(255) NOT NULL,
 * 	PRIMARY KEY(id)
 * ); 
 */
@Entity
@Table(name = "sources")
public class Source {
    @Id
    private Integer id;

    private String ip;
    private String name;

    public String getIp() {
        return ip;
    }

    public String getName() {
        return name;
    }
}
