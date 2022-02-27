package com.ds.phoncnic.repository;

import java.util.List;

import com.ds.phoncnic.entity.Dyning;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DyningRepository extends JpaRepository<Dyning, Long>{
    
    @Query(value = "select * from dyning di LEFT OUTER JOIN dyning_image d ON di.dno= d.dyning_dno", nativeQuery = true)
    Page<Object[]> getListPage(Pageable pageable);

    @Query(value = "select * from dyning di LEFT OUTER JOIN dyning_image d ON di.dno= d.dyning_dno where d.dyning_dno=1", nativeQuery = true)
    List<Object[]> getDyningDetailsByDno(long dno);
}
