package com.epam.mentoring.mongodb;

import com.epam.mentoring.mongodb.model.Friendship;
import com.epam.mentoring.mongodb.model.Message;
import com.epam.mentoring.mongodb.model.Movie;
import com.epam.mentoring.mongodb.model.User;
import com.epam.mentoring.mongodb.repository.friendship.FriendshipRepository;
import com.epam.mentoring.mongodb.repository.friendship.FriendshipResult;
import com.epam.mentoring.mongodb.repository.message.MessageRepository;
import com.epam.mentoring.mongodb.repository.message.MessageResult;
import com.epam.mentoring.mongodb.repository.movie.MovieRepository;
import com.epam.mentoring.mongodb.repository.user.MovieResult;
import com.epam.mentoring.mongodb.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class MongoDBApplication implements CommandLineRunner {

    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FriendshipRepository friendshipRepository;
    @Autowired
    private MovieRepository movieRepository;

    public static void main(String[] args) {
        SpringApplication.run(MongoDBApplication.class, args);
    }

    @Override
    public void run(String... args) {
        reportAverageNumberOfMessagesByDayOfWeek();

        reportMaxNumberOfFriendshipsFromMonthToMonth();

        reportMinNumberOfWatchedMoviesForUsersWithHundredMoreFriends();
    }

    private void reportAverageNumberOfMessagesByDayOfWeek() {
        Message message1 = new Message("Content 1", LocalDateTime.now());
        messageRepository.save(message1);

        Message message2 = new Message("Content 2", LocalDateTime.of(2017, Month.JULY, 7, 17, 0));
        messageRepository.save(message2);

        List<MessageResult> messageToNumberList = messageRepository.getAverageNumberByDayOfWeek();

        for(MessageResult messageResult : messageToNumberList) {
            System.out.println("Day of week " + messageResult.getWeekday() + " "
                    + "Average number of messages " + messageResult.getAverageNumber());
        }
    }

    private void reportMaxNumberOfFriendshipsFromMonthToMonth() {
        User actionUser = new User();
        userRepository.save(actionUser);

        LocalDateTime user1Birthday = LocalDateTime.of(1997, Month.JULY, 5, 5, 0);
        User user1 = new User("user1", "User 1", "New", user1Birthday, Collections.singletonList(actionUser));
        userRepository.save(user1);

        Friendship friendship = new Friendship(user1, actionUser, LocalDateTime.now());
        friendshipRepository.save(friendship);

        List<FriendshipResult> maxNumberByMonth = friendshipRepository.getMaxNumberByMonth();
        for(FriendshipResult friendshipResult : maxNumberByMonth) {
            System.out.println("Month " + friendshipResult.getMonth() + " "
                    + "Max number of friendships " + friendshipResult.getMaxNumber());
        }
    }

    private void reportMinNumberOfWatchedMoviesForUsersWithHundredMoreFriends() {
        Movie movie1 = new Movie("Name 1", "Desc 1", "http://site.com/movie1");
        Movie movie2 = new Movie("Name 2", "Desc 2", "http://site.com/movie2");
        movieRepository.save(movie1);
        movieRepository.save(movie2);

        List<Movie> watchedMovies = new ArrayList<>();
        watchedMovies.add(movie1);
        watchedMovies.add(movie2);

        LocalDateTime user2Birthday = LocalDateTime.of(1998, Month.SEPTEMBER, 8, 12, 0);

        User actionUser = new User();
        userRepository.save(actionUser);

        User user2 = new User("user2", "User 2", "New 2", user2Birthday, Collections.singletonList(actionUser));
        user2.setWatchedMovies(watchedMovies);
        userRepository.save(user2);

        LocalDateTime user3Birthday = LocalDateTime.of(1998, Month.APRIL, 10, 14, 0);
        User user3 = new User("user3", "User 3", "New 3", user3Birthday, Arrays.asList(actionUser, user2));
        user3.setWatchedMovies(Collections.singletonList(movie2));
        userRepository.save(user3);

        List<MovieResult> movieResults = userRepository.getMinNumberOfWatchedMoviesWhenHundredMoreFriends();
        for(MovieResult movieResult : movieResults) {
            System.out.println("Min number of watched movies " + movieResult.getMinNumberOfMovies());
        }
    }
}
