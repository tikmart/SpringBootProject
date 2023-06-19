package am.hitech.model.dto;

import lombok.Data;

@Data
public class UserResponseDto {
    private int id;

    private String firstName;

    private String lastName;

    private int age;

    private String email;

}
