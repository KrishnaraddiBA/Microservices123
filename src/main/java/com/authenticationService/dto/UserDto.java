package com.authenticationService.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDto {

    private long id;

    private String name;

    private String username;

    private String email;

    private String password;

    private String role;

}
