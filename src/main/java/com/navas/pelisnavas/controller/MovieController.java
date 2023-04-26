package com.navas.pelisnavas.controller;

import com.navas.pelisnavas.dto.MovieRequestDTO;
import com.navas.pelisnavas.service.interfaces.MovieService;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/movie/navas")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/list-movie-details/{id}")
    public final Object getMovie(@PathVariable Integer id) {
        return movieService.getListMovieDetails(id);
    }

    @GetMapping("/list-movie/{id}")
    public final Object getListMovie(@PathVariable Integer id) throws NoSuchFieldException, IllegalAccessException {
        return movieService.getListMovie(id);
    }
    @PostMapping("/createMovie")
    public final Object createMovie( @RequestBody MovieRequestDTO request,@RequestHeader HttpHeaders headers){
        return movieService.createMovie(headers,request);
    }
    @PutMapping ("/updateMovie/{id}")
    public final Object putMovie(@PathVariable Integer id, @RequestBody MovieRequestDTO request,@RequestHeader HttpHeaders headers){
        return movieService.putMovie(headers,id,request);
    }
    @DeleteMapping ("/deleteMovie/{id}")
    public final Object deleteMovie(@PathVariable Integer id,@RequestHeader HttpHeaders headers){
        return movieService.deleteMovie(headers,id);
    }
    @PostMapping("/pagination/{id}")
    public final Object getPaginationMovie(@RequestBody MovieRequestDTO request,@PathVariable Integer id) throws NoSuchFieldException, IllegalAccessException {
        return movieService.getPagination(request,id);

    }
}
