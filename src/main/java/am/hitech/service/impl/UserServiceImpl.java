package am.hitech.service.impl;

import am.hitech.model.dto.User;
import am.hitech.model.dto.UserRequestDto;
import am.hitech.model.dto.UserResponseDto;
import am.hitech.repository.UserRepo;
import am.hitech.service.UserService;
import am.hitech.util.ErrorMessage;
import am.hitech.util.InvalidAgeException;
import am.hitech.util.InvalidNameException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;


    @Override
    public User getById(int id) {

        User user = userRepo.findById(id);

        return user;
    }

    @Override
    public UserResponseDto create(UserRequestDto requestDto) throws Exception {

        User user = converToUser(requestDto);

        checker(user);

        userRepo.save(user);
        UserResponseDto responseDto = convertToDto(user);
        return responseDto;
    }

    @Override
    public UserResponseDto edit(UserResponseDto responseDto) {

    }


    private User converToUser(UserRequestDto requestDto) {
        User user = new User();

        user.setFirstName(requestDto.getFirstName());
        user.setLastName(requestDto.getLastName());
        user.setAge(requestDto.getAge());
        user.setEmail(requestDto.getEmail());
        user.setPassword(requestDto.getPassword());

        return user;
    }


    private UserResponseDto convertToDto(User user) {
        UserResponseDto responseDto = new UserResponseDto();

        responseDto.setId(user.getId());
        responseDto.setFirstName(user.getFirstName());
        responseDto.setLastName(user.getLastName());
        responseDto.setAge(user.getAge());
        responseDto.setEmail(user.getEmail());

        return responseDto;
    }


    private void checker(User user) throws Exception {
        if (user.getAge() <= 15) {
            throw new InvalidAgeException(ErrorMessage.INVALID_AGE);
        } else if (user.getFirstName().length() < 2 || user.getLastName().length() < 2) {
            throw new InvalidNameException(ErrorMessage.INVALID_NAME);
        }


    }




}
