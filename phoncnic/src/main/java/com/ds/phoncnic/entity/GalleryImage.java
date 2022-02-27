package com.ds.phoncnic.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = {"artistid","gallery"})
public class GalleryImage  extends BaseEntity{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gno;

    private String imagename;
    private String imagepath;
    private boolean imagetype;
    

    @ManyToOne(fetch = FetchType.LAZY)
    private Member artistid;

    @OneToOne(mappedBy = "image", cascade = CascadeType.ALL)
    private Gallery gallery;
}
