package com.ds.phoncnic.repository;

import javax.transaction.Transactional;

import com.ds.phoncnic.entity.GalleryImage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface GalleryImageRepository extends JpaRepository<GalleryImage, Long> {
    
    @Transactional
    @Modifying
    @Query("delete from GalleryImage gi where gi.gno=:gno")
    void deleteByGno(long gno);

}
