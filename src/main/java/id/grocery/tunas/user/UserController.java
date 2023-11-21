package id.grocery.tunas.user;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("")
    public List<UserDto> getUsers(@RequestParam("page") int page) throws UnirestException {
        return userService.getUsers(page);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public UserDto getUser(@PathVariable("id") int id) throws UnirestException {
        return userService.getUser(id);
    }

    @PostMapping("")
    public void adduser(@RequestBody AddUserDto addUserDto) throws UnirestException {
        userService.addUser(addUserDto);
    }
}
