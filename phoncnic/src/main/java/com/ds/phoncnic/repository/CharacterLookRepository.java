package com.ds.phoncnic.repository;


import java.util.List;
import java.util.Optional;

import com.ds.phoncnic.entity.CharacterLook;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CharacterLookRepository extends JpaRepository<CharacterLook,Long>{
   @Query(value="select * from character_look ch where lno = 1",
   nativeQuery = true)
    Optional<CharacterLook> getCharacterLook();

    // @Query("select m.id,nickname,hair,clothes from Member m join  CharacterLook ch on m.id=ch.id where m.id=:id")
    // Object getCharacterLook(String id);

    // @Query("select hair,clothes,nickname from CharacterLook ch left join Member m on ch.id=m.id where m.id=:id")
    // Object getCharacterLook(String id);

//     @Query("select memberId,hair,clothes ,(select nickname from Member where id=:id) nickname "+
// "from CharacterLook ch where memberId = :id")
//     List<Object[]> mypageCharacterLook(String id);

//     select member_id,hair,clothes ,(select nickname from member where id="user10@icloud.com") nickname

// from character_look

// where member_id = "user10@icloud.com";

// @Query("select m.id,nickname,hair,clothes from Member m join  CharacterLook ch on m.id=ch.id where m.id=:id")
//     Object[] getmypage(@Param("id") String id);
}
