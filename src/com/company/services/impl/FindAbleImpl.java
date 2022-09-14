package com.company.services.impl;

import com.company.JsonIO;
import com.company.models.Director;
import com.company.models.Movie;
import com.company.services.FindAble;
import com.company.services.SortAble;

import java.util.*;

public class FindAbleImpl implements FindAble{
    private static Scanner in = new Scanner(System.in);

    @Override
    public void findMoviesByActor() {
        System.out.println("Write actor name:");
        String actorName = in.nextLine().trim();
        List<Movie> movies = JsonIO.getMovies();
        for (int i = 0; i < JsonIO.getMovies().size(); i++) {
            for (int j = 0; j < JsonIO.getMovies().get(i).getCast().size(); j++) {
                if (JsonIO.getMovies().get(i).getCast().get(j).getFullName().toLowerCase().equals(actorName.toLowerCase()) ||
                        JsonIO.getMovies().get(i).getCast().get(j).getFullName().toLowerCase().contains(actorName.toLowerCase())){
                    System.out.println();
                    System.out.println("Movie: " + JsonIO.getMovies().get(i).getName());
                    System.out.println("Actor: " + JsonIO.getMovies().get(i).getCast().get(j).getFullName());
                }
            }
        }
    }

    @Override
    public void findMoviesByDirector() {
        System.out.println("Write director name:");
        String directorName = in.nextLine().trim().toLowerCase();
        List<Movie> movies = JsonIO.getMovies();
        int counter = 0;
        for (int i = 0; i < movies.size(); i++) {
            if (JsonIO.getMovies().get(i).getDirector().getFullName().toLowerCase().trim().contains(directorName) ||
                    JsonIO.getMovies().get(i).getDirector().getFullName().toLowerCase().trim().equals(directorName.toLowerCase())){
                System.out.println();
                System.out.println("Movie: " + JsonIO.getMovies().get(i).getName());
                System.out.println("Director: " + JsonIO.getMovies().get(i).getDirector().getFullName());
                counter++;
            }
        }

        if (counter == 0){
            System.out.println("THERE IS NO ONE FILM WITH THIS DIRECTOR!!!");
        }
    }

    @Override
    public void findMoviesByYear() {
        List<Movie> movies = JsonIO.getMovies();
        try{
            System.out.println("Write year:");
            int year = in.nextInt();
            if (year>=2005 && year <= 2022){
                for (int i = 0; i < JsonIO.getMovies().size(); i++) {
                    if (JsonIO.getMovies().get(i).getYear() == year){
                        System.out.println("Movie name: " +movies.get(i).getName());
                        System.out.println("Movie year: " +movies.get(i).getYear());
                        System.out.println();
                    }
                }
            }else
                System.out.println("There is no such movie in the catalog!");

        } catch (Exception e) {
            System.out.println("This is not year");
        }

    }

    @Override
    public void findMoviesAndRoleByActor() {
        System.out.println("Write actor name:");
        String actorName = in.nextLine().trim();
        for (int i = 0; i < JsonIO.getMovies().size(); i++) {
            for (int j = 0; j < JsonIO.getMovies().get(i).getCast().size(); j++) {
                if (JsonIO.getMovies().get(i).getCast().get(j).getFullName().toLowerCase().equals(actorName.toLowerCase()) ||
                        JsonIO.getMovies().get(i).getCast().get(j).getFullName().toLowerCase().contains(actorName.toLowerCase())){
                    System.out.println();
                    System.out.println("Actor: " + JsonIO.getMovies().get(i).getCast().get(j).getFullName());
                    System.out.println("Movie: " + JsonIO.getMovies().get(i).getName());
                    System.out.println("Role: " + JsonIO.getMovies().get(i).getCast().get(j).getRole());
                }
            }
        }
    }

    @Override
    public void showActorRoles() {

    }
}
