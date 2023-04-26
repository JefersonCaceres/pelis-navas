package com.navas.pelisnavas.service;

import com.navas.pelisnavas.dto.MovieRequestDTO;
import com.navas.pelisnavas.excepciones.MovieException;
import com.navas.pelisnavas.repository.MovieRepository;
import com.navas.pelisnavas.service.interfaces.MovieService;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {
    private MovieRepository movieRepository ;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    @Override
    public Object getListMovieDetails(Integer id) throws MovieException{
        Object movieResponse = movieRepository.getListMovieDetails(id);
        validateMovie(movieResponse);
        return movieResponse;
    }
    @Override
    public Object getListMovie(Integer id) throws NoSuchFieldException, IllegalAccessException {
        Object response = movieRepository.getListMovie(id);
        validateMovie(response);
        return response;
    }
    @Override
    public Object createMovie(HttpHeaders headers, MovieRequestDTO request) {
        Object response = movieRepository.postMovie(headers,request);
        validateMovie(response);
        return response;
    }

    @Override
    public Object putMovie(HttpHeaders headers,Integer id, MovieRequestDTO request) {
        Object response = movieRepository.putMovie(headers,id,request);
        return response;
    }
    @Override
    public Object deleteMovie(HttpHeaders headers,Integer id) {
        Object response = movieRepository.deleteMovie(headers,id);
        return response;
    }
    @Override
    public Object getPagination(MovieRequestDTO request,Integer id) {
        validatePaginationMovie(request);
        Object response = movieRepository.getPagination(request,id);
        return response;
    }

    private void validateMovie(Object movie){
        if(movie == null || movie==""){
            throw new MovieException("El objeto viene nulo o vacio");
        }
    }
    private void validatePaginationMovie(MovieRequestDTO request){
        if(request.getSize() > 20){
            throw new MovieException("la el tamanio maximo de la paginacion es 20");
        }
    }
}
