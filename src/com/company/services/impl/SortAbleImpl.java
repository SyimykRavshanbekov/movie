package com.company.services.impl;

import com.company.JsonIO;
import com.company.models.Cast;
import com.company.models.Director;
import com.company.models.Movie;
import com.company.services.SortAble;

import java.util.*;

public class SortAbleImpl implements SortAble {

    private static Scanner in = new Scanner(System.in);
    @Override
    public void printAllMovies() {
        List<Movie> movies = JsonIO.getMovies();
        int n = 1;
        for (Movie i: movies) {
            System.out.println();
            System.out.println("--------------------FILM #"+n+"--------------------");
            System.out.println(i);
            n++;
        }
    }

    @Override
    public void findMovie() {
        System.out.println("Write movie name:");
        String movieName = in.nextLine().trim();
        List<Movie> movies = JsonIO.getMovies();
        int counter = 0;
        if (movieName.length()>0){
            for (Movie i: movies) {
                if (i.getName().toLowerCase().contains(movieName.toLowerCase())){
                    System.out.println("---------------------------------------------------");
                    System.out.println(i);
                    counter++;
                }
            }
            if (counter==0){
                System.out.println("THERE IS NO ONE FILM WITH THIS NAME!");
            }
        }else if (movieName.length()==0){
            System.out.println("WRITE MOVIE NAME!!!!!!");
        }
    }

    @Override
    public void sortByYear() {
        List<Movie> movies = JsonIO.getMovies();
        oneOrTwo();
        int a = in.nextInt();
        if (a == 1){
            Comparator<Movie> comparator = new Comparator<Movie>() {
                @Override
                public int compare(Movie o1, Movie o2) {
                    return o1.getYear()-o2.getYear();
                }
            };

            movies.sort(comparator);
            for (Movie m: movies) {
                System.out.println("--------------------------------------");
                System.out.println(m);
            }
        }
        if (a == 2){
            Comparator<Movie> comparator = new Comparator<Movie>() {
                @Override
                public int compare(Movie o1, Movie o2) {
                    return o2.getYear()-o1.getYear();
                }
            };

            movies.sort(comparator);
            for (Movie m: movies) {
                System.out.println("--------------------------------------");
                System.out.println(m);
            }
        } else if (a > 2){
            System.out.println("WRITE ONLY 1 OR 2 !!!");
        }

    }


    @Override
    public void sortByName() {
        List<Movie> movies = JsonIO.getMovies();
        oneOrTwo();
        int a = in.nextInt();
        if (a == 1){
            Comparator<Movie> comparator = new Comparator<Movie>() {
                @Override
                public int compare(Movie o1, Movie o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            };

            movies.sort(comparator);
            for (Movie m: movies) {
                System.out.println("--------------------------------------");
                System.out.println(m);
            }
        }
        if (a == 2){
            Comparator<Movie> comparator = new Comparator<Movie>() {
                @Override
                public int compare(Movie o1, Movie o2) {
                    return o2.getName().compareTo(o1.getName());
                }
            };

            movies.sort(comparator);
            for (Movie m: movies) {
                System.out.println("--------------------------------------");
                System.out.println(m);
            }
        } else if (a > 2){
            System.out.println("WRITE ONLY 1 OR 2 !!!");
        }
    }

    @Override
    public void sortByDirector() {
        List<Movie> movies = JsonIO.getMovies();
        oneOrTwo();
        int a = in.nextInt();

        if (a == 1){
            Comparator<Movie> comparator = new Comparator<Movie>() {
                @Override
                public int compare(Movie o1, Movie o2) {
                    return o1.getDirector().getFullName().compareTo(o2.getDirector().getFullName());
                }
            };

            movies.sort(comparator);
            for (Movie m: movies) {
                System.out.println("--------------------------------------");
                System.out.println(m);
            }
        }
        if (a == 2){
            Comparator<Movie> comparator = new Comparator<Movie>() {
                @Override
                public int compare(Movie o1, Movie o2) {
                    return o2.getDirector().getFullName().compareTo(o1.getDirector().getFullName());
                }
            };

            movies.sort(comparator);
            for (Movie m: movies) {
                System.out.println("--------------------------------------");
                System.out.println(m);
            }
        }else if (a > 2){
            System.out.println("WRITE ONLY 1 OR 2 !!!");
        }
    }

    public void showActorRoles() {
        oneOrTwo();
        int a = in.nextInt();

        if (a == 1){
            ArrayList<String> movies1 = new ArrayList<>();
            for (int i = 0; i < JsonIO.getMovies().size(); i++) {
                for (int j = 0; j < JsonIO.getMovies().get(i).getCast().size(); j++) {
                    movies1.add("Actor name -> "+JsonIO.getMovies().get(i).getCast().get(j).getFullName() + "\nRole -> " + JsonIO.getMovies().get(i).getCast().get(j).getRole() + "\nMovie name -> " +JsonIO.getMovies().get(i).getName());
                }
            }

            Comparator<String> comparator = new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            };

            movies1.sort(comparator);

            for (int i = 0; i < movies1.size(); i++) {
                System.out.println(movies1.get(i));
//                System.out.println(movies2.get(i));
                System.out.println();
            }
        }
        if (a == 2){
            ArrayList<String> movies1 = new ArrayList<>();
            for (int i = 0; i < JsonIO.getMovies().size(); i++) {
                for (int j = 0; j < JsonIO.getMovies().get(i).getCast().size(); j++) {
                    movies1.add("Actor name -> "+JsonIO.getMovies().get(i).getCast().get(j).getFullName() + "\nRole -> " + JsonIO.getMovies().get(i).getCast().get(j).getRole() + "\nMovie name -> " +JsonIO.getMovies().get(i).getName());
                }
            }
            Comparator<String> comparator = new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o2.compareTo(o1);
                }
            };

            movies1.sort(comparator);

            for (int i = 0; i < movies1.size(); i++) {
                System.out.println(movies1.get(i));
                System.out.println();
            }
        }
    }

    public void showActorRoles1(){
        oneOrTwo();
        int a = in.nextInt();
        List<Movie> movies = JsonIO.getMovies();
        TreeSet<Cast> moviesTree = new TreeSet<>();

        for (int i = 0; i < JsonIO.getMovies().size(); i++) {
            moviesTree.addAll(JsonIO.getMovies().get(i).getCast());
        }
        if (a==1){
            for (Cast cast: moviesTree) {
                System.out.println("-----------------------------------");
                System.out.println("Actor name: " + cast.getFullName());
                for (int i = 0; i < movies.size(); i++) {
                    for (int j = 0; j < movies.get(i).getCast().size(); j++) {
                        if (cast.getFullName().equals(movies.get(i).getCast().get(j).getFullName())){
                            System.out.println("movie name: " + movies.get(i).getName());
                            System.out.println("role: " + movies.get(i).getCast().get(j).getRole());
                        }
                    }
                }
            }
        }

        TreeSet<Cast> moviesTree2 = (TreeSet<Cast>) moviesTree.descendingSet();
        if (a == 2){
            for (Cast cast: moviesTree2) {
                System.out.println("-----------------------------------");
                System.out.println("Actor name: " + cast.getFullName());
                for (int i = 0; i < movies.size(); i++) {
                    for (int j = 0; j < movies.get(i).getCast().size(); j++) {
                        if (cast.getFullName().equals(movies.get(i).getCast().get(j).getFullName())){
                            System.out.println("movie name: " + movies.get(i).getName());
                            System.out.println("role: " + movies.get(i).getCast().get(j).getRole());
                        }
                    }
                }
            }
        }

        if (a > 2){
            System.out.println("WRITE ONLY 1 OR 2");
        }

    }

    static void oneOrTwo(){
        System.out.println("1 - sort from the first \n2 - sort from the end");
    }

}
