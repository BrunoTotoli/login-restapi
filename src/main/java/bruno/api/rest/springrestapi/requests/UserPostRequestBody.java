package bruno.api.rest.springrestapi.requests;

import bruno.api.rest.springrestapi.entities.Phone;
import lombok.Data;

import java.util.List;

@Data
public class UserPostRequestBody {
    private String login;
    private String password;
    private String name;
    private List<Phone> phones;
}
