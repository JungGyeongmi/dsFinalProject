package com.ds.phoncnic.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@ToString(exclude = "characterLook")
public class Member extends BaseEntity {
   
    @Id
    private String id;

    private String nickname;
    private String password;

    @OneToMany
    private List<CharacterLook> characterLook;
}
