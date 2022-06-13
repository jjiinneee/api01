package org.jjiinnee.api01.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO {
  
  @Builder.Default
  private int page = 1;
  
  @Builder.Default
  private int size = 10;
  
  private String type; // 검색의 종류 t,c, w, tc,tw, twc
  
  private String keyword;
  
  
  //추가된 내용들
  private LocalDate from;
  
  private LocalDate to;
  
  private Boolean completed;
}
