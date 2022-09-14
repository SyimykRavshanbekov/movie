package com.company.services;

import com.company.models.Movie;

import java.util.List;

public interface FindAble {

    void findMoviesByActor();

    void findMoviesByDirector();

    void findMoviesByYear();

    void findMoviesAndRoleByActor();

    void showActorRoles();
}
