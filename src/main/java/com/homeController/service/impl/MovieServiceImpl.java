package com.homeController.service.impl;

import com.homeController.objects.Movie;
import com.homeController.serialisation.DeleteMovieBody;
import com.homeController.service.MovieService;
import com.mongodb.client.gridfs.GridFSFindIterable;

import com.mongodb.client.gridfs.model.GridFSFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class MovieServiceImpl implements MovieService {

    @Autowired
    GridFsOperations gridOperations;

    @Override
    public void save(MultipartFile file){
        try {
            gridOperations.store(file.getInputStream(),file.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void deleteById(List<DeleteMovieBody> idList) {
        for(DeleteMovieBody id:idList){
            Query deleteById = new Query();
            deleteById.addCriteria(Criteria.where("_id").is(id.getId()));
            gridOperations.delete(deleteById);
        }
    }

    @Override
    public List<Movie> getSavedFiles(long offset, long limit) {
        List<Movie> result = new ArrayList<>();
        GridFSFindIterable files = gridOperations.find(new Query().limit((int) limit).skip((int) offset));
        for(GridFSFile file:files) {
            result.add(new Movie(file.getObjectId().toString(),file.getFilename(), file.getLength()));
        }
        return result;
    }

}
