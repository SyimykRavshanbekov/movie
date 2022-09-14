package com.company;

import com.company.models.Movie;
import com.company.services.impl.FindAbleImpl;
import com.company.services.impl.SortAbleImpl;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        mainMethod();
    }


    static void commands() {
        System.out.println("--------------Commands-----------------------");
        System.out.println("Press 1 to print catalog");
        System.out.println("Press 2 to Find a Movie by full or part name");
        System.out.println("Press 3 to sort by year");
        System.out.println("Press 4 to sort by name");
        System.out.println("Press 5 to sort by director");
        System.out.println("Press 6 to find movies by actor's name");
        System.out.println("Press 7 to find movies by director's name");
        System.out.println("Press 8 to find movies by year");
        System.out.println("Press 9 to List all movies and roles by actor's name");
        System.out.println("Press 10 to sorted List of all actors with his roles");
        System.out.println("---------------------------------------------");
    }

    static void mainMethod(){
        SortAbleImpl sortAble = new SortAbleImpl();
        FindAbleImpl findAble = new FindAbleImpl();
        String number = "null";
        while (!number.equals("x")){
            commands();
            System.out.println("Choose a command: ");
            number = in.nextLine();
            try{
                if (Character.isDigit(number.charAt(0))){
                    switch (number){
                        case "1" -> sortAble.printAllMovies();
                        case "2" -> sortAble.findMovie();
                        case "3" -> sortAble.sortByYear();
                        case "4" -> sortAble.sortByName();
                        case "5" -> sortAble.sortByDirector();
                        case "6" -> findAble.findMoviesByActor();
                        case "7" -> findAble.findMoviesByDirector();
                        case "8" -> findAble.findMoviesByYear();
                        case "9" -> findAble.findMoviesAndRoleByActor();
                        case "10" -> sortAble.showActorRoles();
                    }
                }else {
                    throw new RuntimeException();
                }
            } catch (RuntimeException e) {
                System.out.println("It is not a button");
            }
        }

    }
}
