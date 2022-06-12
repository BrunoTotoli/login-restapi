package bruno.api.rest.springrestapi.requests;

import lombok.Data;

@Data
public class UserPostRequestBody {
    private String login;
    private String password;
    private String name;
}
