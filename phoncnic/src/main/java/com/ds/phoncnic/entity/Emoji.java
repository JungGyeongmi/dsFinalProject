package com.ds.phoncnic.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
@ToString(exclude = {"member", "dyning", "gallery"})
public class Emoji extends BaseEntity{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eno;

    private String emojitype;
    
    @ManyToOne
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    private Dyning dyning;

    @ManyToOne(fetch = FetchType.LAZY)
    private Gallery gallery;
}
