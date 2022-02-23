package exercises;

import common.model.Author;
import common.model.Book;
import common.model.Movie;
import common.model.MovieSeries;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static common.DataFactory.*;

public class Streams {

    /**
     * Please complete all of below exercises using Stream API and data from @DataFactory class
     * <p>
     * For data sources please use following methods:
     * <p>
     * book list - getBooks() method
     * movie series list - getMovieSeries() method
     * random words generator - getSomeRandomWords() method
     */
    public static void main(String[] args) {

        // map
        /**
         * Please return a list of book titles from provided book list
         */
        List<String> bookNames = getBooks().stream().map(Book::getTitle).collect(Collectors.toList());
        //System.out.println(bookNames);

        for (String s : bookNames
        ) {
            System.out.println(s);

        }
        // flatmap
        /**
         * Please return a list of all available movies from provided movie series list
         */
        List<Movie> availableMovies = getMovieSeries().stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println("\n Flatmap ");
        for (Movie movie : availableMovies
        ) {
            System.out.println(movie.getTitle());

        }
        // filter
        /**
         * Please return a list of all books written by J_K_ROWLING from provided book list
         */ Predicate <Book> bookPredicate = book -> book.getAuthor() == Author.J_K_ROWLING;
        List<Book> booksByJKRowling = getBooks().stream().filter(bookPredicate).collect(Collectors.toList());
        //List<Book> booksByJKRowling = getBooks().stream().filter(book -> book.getAuthor() == Author.J_K_ROWLING).collect(Collectors.toList());

        // countList<Book> booksByJKRowling = getBooks().stream().filter(book -> book.getAuthor() == Author.J_K_ROWLING).collect(Collectors.toList());
        /**
         * Please return the amount of books written by T_PRATCHETT from provided book list
         */
        long booksByTerryPratchettCount = getBooks().stream().filter(book -> book.getAuthor() == Author.J_K_ROWLING).count();

        // findFirst - nicer effect with parallel stream
        /**
         * Please find first available STAR_WARS movie from provided movie series list
         */
        Optional<Movie> firstStarWarsMovieOnTheShelf = getMovieSeries().stream().flatMap(Collection::stream).filter(movie -> movie.getSeries() == MovieSeries.STAR_WARS).findFirst();

        // findAny - nicer effect with parallel stream
        /**
         * Please find any book written by A_SAPKOWSKI from provided book list
         */
        Optional<Book> anyBookByASapkowski = getBooks().parallelStream().filter(book -> book.getAuthor() == Author.A_SAPKOWSKI).findAny();


        // toList
        /**
         * Please create a list of all movie title from provided movie list
         */
        List<String> movieTitlesList = getMovieSeries().stream().flatMap(Collection::stream).map(Movie::getTitle).collect(Collectors.toList());
        // toSet
        /**
         * Please create a set of all authors from provided book list
         */
        Set<Author> bookAuthors = getBooks().stream().map(Book::getAuthor).collect(Collectors.toSet());

        // toMap
        /**
         * Please create a map of books with author as a key from provided book list
         *
         * !only one book per author is required
         * !if new book is found for the same author it should replace the previous one
         */
        Map<Author, Book> bookOfAnAuthorMap = getBooks().stream().collect(Collectors.toMap(Book::getAuthor, Function.identity(), (Book existing, Book replacement) -> existing));

        // groupingBy
        /**
         * Please create a map of books with author as a key from provided book list
         */
        Map<Author, Set<Book>> booksGroupedByAuthor = getBooks().stream().collect(Collectors.groupingBy(Book::getAuthor,Collectors.toSet()));

        // joining
        /**
         * Please create a string from provided random words generator, using " " (space) as a delimiter
         */
        String totallyRandomSentence = getSomeRandomWords().stream().map(String::toUpperCase).collect(Collectors.joining(""));

        // forEach - only to display results!
        /**
         * Please display any of the results on the console using forEach() method and a Consumer<T> functional interface
         */
        availableMovies.forEach(movie -> System.out.println(movie.getTitle()));
        // code
    }
}
