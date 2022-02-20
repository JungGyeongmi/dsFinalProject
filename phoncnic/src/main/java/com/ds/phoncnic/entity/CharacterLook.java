package com.ds.phoncnic.entity;

import javax.persistence.Entity;

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
public class CharacterLook extends BaseEntity{
 
    @id
    @GenertatedValue(strategy = GenerationType.IDENTITY)

}
