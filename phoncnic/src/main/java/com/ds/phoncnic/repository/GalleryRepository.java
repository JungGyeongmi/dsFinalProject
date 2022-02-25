package com.ds.phoncnic.repository;

import com.ds.phoncnic.entity.Gallery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GalleryRepository extends JpaRepository<Gallery, Long>{

    @Query("select g, gi from Gallery g inner join GalleryImage gi on gi.gno = g.gno group by g")
    // @Query("SELECT g, gi FROM Gallery g INNER JOIN gallery_image gi ON gi.gno = g.gno GROUP BY g.gno")
    Page<Object[]> getListPage(Pageable pageable);
}
