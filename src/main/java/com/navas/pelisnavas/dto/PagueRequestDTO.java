package com.navas.pelisnavas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;


public class PagueRequestDTO {
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JsonSetter(nulls = Nulls.SKIP)
    private Integer size = 0;

    public PagueRequestDTO() {
    }

    public PagueRequestDTO(Integer size) {
        this.size = size;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
    @Override
    public String toString() {
        return "PagueRequestDTO{" +
                "size=" + size +
                '}';
    }
}
