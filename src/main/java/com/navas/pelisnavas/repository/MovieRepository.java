package com.navas.pelisnavas.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.navas.pelisnavas.dto.MovieRequestDTO;

import com.navas.pelisnavas.dto.PagueRequestDTO;
import com.navas.pelisnavas.excepciones.MovieException;


import net.bytebuddy.description.method.MethodDescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class MovieRepository {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${jc.tmdb.variable.api.key:null}")
    private String apiKey;
    @Value("${jc.tmdb.variable.api.url.movie:null}")
    private String urlMovie;
    @Value("${jc.tmdb.variable.api.list.movie:null}")
    private String urlListMovie;
    @Value("${jc.tmdb.variable.api.create.movie:null}")
    private String urlCreateMovie;
    public Object getListMovieDetails(Integer id) throws MovieException{
        return restTemplate.getForObject(urlMovie+id+apiKey,Object.class);
    }
    public Object getListMovie(Integer id) throws MovieException{
        return restTemplate.getForObject(urlListMovie+id+"/lists"+apiKey,Object.class);
    }
    public Object postMovie(HttpHeaders headersRespo , MovieRequestDTO request) throws MovieException {
        HttpEntity<MovieRequestDTO> requestMovie = new HttpEntity<>(request,headersRespo);
        Object data = restTemplate.postForObject(urlCreateMovie,requestMovie,Object.class,requestMovie);
        return data;
    }
    public Object putMovie(HttpHeaders headersRespo ,Integer id, MovieRequestDTO request) throws MovieException {
        HttpEntity<MovieRequestDTO> requestMovie = new HttpEntity<>(request,headersRespo);
        Object data = restTemplate.exchange(urlMovie+id, HttpMethod.PUT,requestMovie,Object.class);
        return data;
    }
    public Object deleteMovie(HttpHeaders headersRespo ,Integer id) throws MovieException {
        HttpEntity<Object> requestMovie = new HttpEntity<>(headersRespo);
        Object data = restTemplate.exchange(urlMovie+id, HttpMethod.DELETE,requestMovie,Object.class);
        return data;
    }

    public Object getPagination(MovieRequestDTO request,Integer id) throws MovieException {
        Map<String,Object> re = restTemplate.getForObject(urlListMovie+id+"/lists"+apiKey,Map.class);
        Object obj = listMovie(re);
        String json = converToJson(obj);
        List<Object> pagination = listMovie(json,request.getSize());

        return pagination;
    }
    public Object listMovie(Map<String,Object> re)throws MovieException{
        Object listMovies = new ArrayList<>();
        for (Map.Entry<String,Object> data : re.entrySet()){
            if(data.getKey().equals("results")){
                listMovies = data.getValue();
                break;
            }
        }
        return listMovies;
    }
    public String converToJson(Object obj){
        Gson gson = new Gson();
        String json = gson.toJson(obj);
        return json;
    }
    public List<Object> listMovie(String json,Integer id){
        Gson gson = new Gson();
        List<Object> list = gson.fromJson(json, new TypeToken<List<Object>>(){}.getType());
        List<Object> pagination= new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if(i<id){
                pagination.add(list.get(i));
            }else{
                break;
            }
        }
        System.out.println("Lista"+pagination.size());
        return pagination;
    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
