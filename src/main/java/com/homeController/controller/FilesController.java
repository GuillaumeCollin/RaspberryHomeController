package com.homeController.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.homeController.objects.Movie;
import com.homeController.serialisation.DeleteMovieBody;
import com.homeController.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController(value = "/files")
public class FilesController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getSavedFiles(){
        List<Movie> listMovies = movieService.getSavedFiles(0,10);
        return new ResponseEntity<>(listMovies, HttpStatus.OK);
    }

    @GetMapping(value = "/{movieId}")
    public ResponseEntity<List<Movie>> getFileDetails(){
        List<Movie> listMovies = movieService.getSavedFiles(0,10);
        return new ResponseEntity<>(listMovies, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
        movieService.save(file);
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteFile(@RequestBody List<DeleteMovieBody> idList){
        movieService.deleteById(idList);
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }


}
