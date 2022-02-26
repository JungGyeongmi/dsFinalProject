package com.ds.phoncnic.repository;

import com.ds.phoncnic.entity.Emoji;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmojiRepository extends JpaRepository<Emoji,Long>{
    
}
