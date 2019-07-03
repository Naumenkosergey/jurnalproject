package com.itacademy.database.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.criteria.Predicate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FilterDto {

    private Predicate predicate;
    private LimitOffsetDto limitOffsetDto;
}
