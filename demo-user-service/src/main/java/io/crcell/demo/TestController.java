package io.crcell.demo;

import io.crcell.demo.entities.User;
import io.crcell.demo.user.UserClient;
import io.easywalk.simply.controllable.SimplyControllableResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@SimplyControllableResponse
@RestController
@RequestMapping("/test")
public class TestController {
    private final UserClient client;

    @PostMapping
    public User create(@RequestBody User user) throws Throwable {
        return client.create(user);
    }

    @GetMapping("/{id}")
    public User get(@PathVariable Long id) throws Throwable {
        return client.get(id);
    }

    @GetMapping
    public List<User> getAll() throws Throwable {
        return client.getAll();
    }


    @PutMapping("/{id}")
    public User put(@PathVariable Long id, @RequestBody User user) throws Throwable {
        return client.replaceById(id, user);
    }

    @PatchMapping("/{id}")
    public User updateById(@PathVariable Long id, @RequestBody Map<String, Object> fields) throws Throwable {
        return client.updateById(id, fields);
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) throws Throwable {
        client.deleteById(id);
    }

}
