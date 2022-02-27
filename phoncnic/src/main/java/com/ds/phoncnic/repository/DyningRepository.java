package com.ds.phoncnic.repository;

import java.util.List;

import com.ds.phoncnic.entity.Dyning;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DyningRepository extends JpaRepository<Dyning, Long>{
    
    @Query("select di, d from Dyning di LEFT OUTER JOIN DyningImage d ON di = d.dyning")
    Page<Object[]> getListPage(Pageable pageable);

    // @Query("select di, d from Dyning di LEFT OUTER JOIN DyningImage d ON di = d.dyning where d.dyning_dno=1")
    // List<Object[]> getDyningDetailsByDno(long dno);
}
