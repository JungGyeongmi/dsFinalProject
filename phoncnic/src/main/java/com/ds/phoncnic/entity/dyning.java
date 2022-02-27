package com.ds.phoncnic.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
@ToString(exclude = "ceoid")
public class Dyning extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long dno;
    private long dino;
    private String dyningname;
    private long roofdesign;
    private String location;
    private long foodtype;
    private String businesshours;
    private String comment;
    private String hashtag;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member ceoid;


}