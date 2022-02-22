package com.ds.phoncnic.dto;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import lombok.Data;



@Data

//페이지요청의 결과를 담기 위한 클래스
public class PageResultDTO<DTO,EN> {
    //페이지 결과목록을 담기 위한 변수
    private List<DTO> dtoList;

    //page navigation을 위한 변수
    private int page;      //현재 페이지 번호
    private int size;       //목록 사이즈
    private int totalPage; //총 페이지 갯수 132페이지면 토탈페이지는 14개 
    private int start, end; //시작 페이지 번호, 끝 페이지 번호
    private boolean prev, next; //이전, 다음
    private List<Integer> pageList; //페이지 번호 목록

    //페이지결과처리된 페이지
    public PageResultDTO(Page<EN> result, Function<EN,DTO> fn) {
        dtoList = result.stream().map(fn).collect(Collectors.toList());
        totalPage = result.getTotalPages();
        makePageList(result.getPageable()); //페이지초기화
    }

    private void makePageList (Pageable pageable){
        this.page = pageable.getPageNumber()+1;
        this.size = pageable.getPageSize();
        //끝나는 페이지
        int tempEnd = (int)(Math.ceil(page/(double)size))*10;
        //시작하는 페이지
        start = tempEnd-(size-1);
        end = totalPage > tempEnd? tempEnd:totalPage;
        prev = start>1;
        next = totalPage > tempEnd;
        pageList = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());

    }
}