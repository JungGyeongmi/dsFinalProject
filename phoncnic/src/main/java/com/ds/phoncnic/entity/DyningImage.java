package com.ds.phoncnic.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class DyningImage {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ceoid;

    private String menuimagename;
    private String menuimagepath;
    private String backgroundname;
    private String backgroundpath;
    private Long dno;
}
