package bruno.api.rest.springrestapi.mapper;

import bruno.api.rest.springrestapi.entities.User;
import bruno.api.rest.springrestapi.requests.UserPostRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User userPostToUser(UserPostRequestBody userPostRequestBody);


}
