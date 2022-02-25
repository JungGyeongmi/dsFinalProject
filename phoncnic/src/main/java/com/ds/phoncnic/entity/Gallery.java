package com.ds.phoncnic.entity;

import javax.persistence.CascadeType;
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
@ToString(exclude = {"artistid", "image"})
public class Gallery extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gno;

    private String title;
    private String  content;
    private boolean imagetype;
   
    private String imagepath;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Member artistid;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "image_gno", referencedColumnName = "gno")
    private GalleryImage image;
}
