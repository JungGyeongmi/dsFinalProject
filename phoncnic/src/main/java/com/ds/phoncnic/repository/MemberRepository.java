package com.ds.phoncnic.repository;



import com.ds.phoncnic.entity.Member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {
    
}
