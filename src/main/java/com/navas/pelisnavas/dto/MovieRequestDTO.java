package com.navas.pelisnavas.dto;

import com.fasterxml.jackson.annotation.JsonInclude;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieRequestDTO extends PagueRequestDTO{
    private String name;
    private String iso_639_1;
    private String description ;
    private Integer id ;
    private String iso_3166_1 ;
    private Integer number_of_items ;
    private String poster_path ;
    private String revenue ;
    private Integer runtime ;

    public MovieRequestDTO() {
    }

    public MovieRequestDTO(String name, String iso_639_1, String description, Integer id, String iso_3166_1, Integer number_of_items, String poster_path, String revenue, Integer runtime) {
        this.name = name;
        this.iso_639_1 = iso_639_1;
        this.description = description;
        this.id = id;
        this.iso_3166_1 = iso_3166_1;
        this.number_of_items = number_of_items;
        this.poster_path = poster_path;
        this.revenue = revenue;
        this.runtime = runtime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIso_639_1() {
        return iso_639_1;
    }

    public void setIso_639_1(String iso_639_1) {
        this.iso_639_1 = iso_639_1;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIso_3166_1() {
        return iso_3166_1;
    }

    public void setIso_3166_1(String iso_3166_1) {
        this.iso_3166_1 = iso_3166_1;
    }

    public Integer getNumber_of_items() {
        return number_of_items;
    }

    public void setNumber_of_items(Integer number_of_items) {
        this.number_of_items = number_of_items;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getRevenue() {
        return revenue;
    }

    public void setRevenue(String revenue) {
        this.revenue = revenue;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    @Override
    public String toString() {
        return "MovieRequestDTO{" +
                "name='" + name + '\'' +
                ", iso_639_1='" + iso_639_1 + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", iso_3166_1='" + iso_3166_1 + '\'' +
                ", number_of_items=" + number_of_items +
                ", poster_path='" + poster_path + '\'' +
                ", revenue='" + revenue + '\'' +
                ", runtime=" + runtime +
                '}';
    }
}
