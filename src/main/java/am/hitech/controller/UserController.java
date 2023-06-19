package am.hitech.controller;


import am.hitech.model.dto.User;
import am.hitech.model.dto.UserRequestDto;
import am.hitech.model.dto.UserResponseDto;
import am.hitech.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping
    public ResponseEntity<User> getById(@RequestParam int id) {
        User user = userService.getById(id);

        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> create(@RequestBody UserRequestDto requestDto) throws Exception {
        UserResponseDto responseDto = userService.create(requestDto);

        return ResponseEntity.ok(responseDto);
    }


    @PostMapping
    public ResponseEntity<UserResponseDto> edit(@RequestBody UserRequestDto requestDto) {

    }




}
