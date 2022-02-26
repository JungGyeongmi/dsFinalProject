package com.ds.phoncnic.entity;

import javax.persistence.CascadeType;
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
@ToString (exclude = "member")
public class CharacterLook extends BaseEntity{
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long lno;

    private String hair;
    private String clothes;

    @ManyToOne(fetch = FetchType.LAZY)
    Member member;
}
