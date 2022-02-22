package com.ds.phoncnic.dto;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data

//page를 요청할 때 단순히 페이지번호 보다 객체로 처리를 위함
public class PageRequestDTO {
    private int page;
    private int size;
    private String type;
    private String keyword;

    //기본생성자 단축키 ctor+tab
    //allargsConstruvtor 애너테이션이 있어서 this를 쓸 수 있음
    public PageRequestDTO() {
        this.page = 1;
        this.size = 10;
    }
    public Pageable getPageable(Sort sort){

        return PageRequest.of(page -1, size, sort);
    }

}