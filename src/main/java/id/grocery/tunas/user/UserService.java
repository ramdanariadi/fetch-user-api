package id.grocery.tunas.user;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserService {

    private static Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    public List<UserDto> getUsers(int page) throws UnirestException {
        HttpResponse<JsonNode> json = Unirest.get("https://reqres.in/api/users?" + page).asJson();
        System.out.println(json.getBody().toString());
        JSONObject object = json.getBody().getObject();
        JSONArray data = object.getJSONArray("data");
        List<UserDto> users = new ArrayList<>();
        data.forEach(o -> {
            JSONObject dataUser = (JSONObject) o;
            UserDto userDto = new UserDto();
            userDto.setId(dataUser.getInt("id"));
            userDto.setEmail(dataUser.getString("email"));
            userDto.setFirst_name(dataUser.getString("first_name"));
            userDto.setLast_name(dataUser.getString("last_name"));
            userDto.setAvatar(dataUser.getString("avatar"));
            users.add(userDto);
        });

        return users;
    }

    public UserDto getUser(int userId) throws UnirestException {
        HttpResponse<JsonNode> json = Unirest.get("https://reqres.in/api/users/" + userId)
                .asJson();
        JSONObject object = json.getBody().getObject();
        JSONObject dataUser = object.getJSONObject("data");
        UserDto userDto = new UserDto();
        userDto.setId(dataUser.getInt("id"));
        userDto.setEmail(dataUser.getString("email"));
        userDto.setFirst_name(dataUser.getString("first_name"));
        userDto.setLast_name(dataUser.getString("last_name"));
        userDto.setAvatar(dataUser.getString("avatar"));

        return userDto;
    }

    public void addUser(AddUserDto addUserDto) throws UnirestException {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", addUserDto.getName());
        requestBody.put("job", addUserDto.getJob());
        HttpResponse<JsonNode> json = Unirest.post("https://reqres.in/api/users").body(requestBody).asJson();
        LOGGER.info("response code : " + json.getStatus());
    }
}
