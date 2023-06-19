package am.hitech.service;

import am.hitech.model.dto.User;
import am.hitech.model.dto.UserRequestDto;
import am.hitech.model.dto.UserResponseDto;


public interface UserService {


    User getById(int id);

    UserResponseDto create(UserRequestDto requestDto) throws Exception;

    UserResponseDto edit(UserResponseDto responseDto);
}
