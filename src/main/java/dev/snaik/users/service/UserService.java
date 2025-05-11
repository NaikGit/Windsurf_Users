package dev.snaik.users.service;

import dev.snaik.users.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import java.util.List;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/users";
    private final RestClient restClient;

    @Autowired
    public UserService(RestClient restClient) {
        this.restClient = restClient;
    }

    @Cacheable("users")
    public List<User> getAllUsers() {
        logger.info("Calling JSONPlaceholder: getAllUsers");
        User[] users = restClient.get()
            .uri(BASE_URL)
            .retrieve()
            .body(User[].class);
        return Arrays.asList(users);
    }

    @Cacheable(value = "userById", key = "#id")
    public User getUserById(int id) {
        logger.info("Calling JSONPlaceholder: getUserById with id={}", id);
        return restClient.get()
            .uri(BASE_URL + "/" + id)
            .retrieve()
            .body(User.class);
    }

    public User createUser(User user) {
        return restClient.post()
            .uri(BASE_URL)
            .body(user)
            .retrieve()
            .body(User.class);
    }

    public User updateUser(int id, User user) {
        return restClient.put()
            .uri(BASE_URL + "/" + id)
            .body(user)
            .retrieve()
            .body(User.class);
    }

    public void deleteUser(int id) {
        restClient.delete()
            .uri(BASE_URL + "/" + id)
            .retrieve();
    }
}
