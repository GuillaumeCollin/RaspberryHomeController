package com.homeController.service;

import com.homeController.objects.Movie;
import com.homeController.serialisation.DeleteMovieBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MovieService {

      void save(MultipartFile file);

      void deleteById(List<DeleteMovieBody> idList);

      List<Movie> getSavedFiles(long offset, long limit);


}
