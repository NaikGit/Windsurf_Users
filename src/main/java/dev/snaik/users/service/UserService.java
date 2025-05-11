package dev.snaik.users.service;

import dev.snaik.users.model.User;
import dev.snaik.users.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import java.util.List;
import java.util.Arrays;

@Service
public class UserService {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/users";
    private final RestClient restClient;

    @Autowired
    public UserService(RestClient restClient) {
        this.restClient = restClient;
    }

    public List<User> getAllUsers() {
        User[] users = restClient.get()
            .uri(BASE_URL)
            .retrieve()
            .body(User[].class);
        return Arrays.asList(users);
    }

    public User getUserById(int id) {
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
