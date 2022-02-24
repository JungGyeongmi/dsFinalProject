package com.ds.phoncnic.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

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
@ToString(exclude = "member")
public class GalleryImage  extends BaseEntity{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gino;

    private String imagename;
    private String imagepath;

    // private Long gno;
    // private String artistid;
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @OneToOne
    @JoinColumn(name = "gno")
    private Gallery gallery;
    
}
