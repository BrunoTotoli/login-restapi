package bruno.api.rest.springrestapi.requests;

import lombok.Data;

@Data
public class UserPutRequestBody {
    private Long id;
    private String login;
    private String password;
    private String name;
}
