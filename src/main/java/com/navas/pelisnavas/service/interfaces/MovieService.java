package com.navas.pelisnavas.service.interfaces;

import com.navas.pelisnavas.dto.MovieRequestDTO;
import org.springframework.http.HttpHeaders;

public interface MovieService {
    Object getListMovieDetails(Integer id);
    Object getListMovie(Integer id) throws NoSuchFieldException, IllegalAccessException;
    Object createMovie(HttpHeaders headers, MovieRequestDTO request);
    Object putMovie(HttpHeaders headers,Integer id, MovieRequestDTO request);
    Object deleteMovie(HttpHeaders headers,Integer id);
    Object getPagination(MovieRequestDTO request,Integer id);
}
