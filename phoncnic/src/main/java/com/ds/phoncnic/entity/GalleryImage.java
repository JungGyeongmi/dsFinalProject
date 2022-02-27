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
<<<<<<< Updated upstream
@ToString(exclude = "gallery")
=======
@Setter
@ToString(exclude = {"gallery","artistid"})
>>>>>>> Stashed changes
public class GalleryImage  extends BaseEntity{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gino;

    private String imagename;
    private String imagepath;

    // private Long gno;
    // private String artistid;
    @ManyToOne(fetch = FetchType.LAZY)
<<<<<<< Updated upstream
=======
    private Member artistid;

    @OneToOne(mappedBy = "image", cascade = CascadeType.ALL)
>>>>>>> Stashed changes
    private Gallery gallery;
    
}
