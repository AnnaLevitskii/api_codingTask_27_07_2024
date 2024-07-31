package com.core.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {
    String name;
    String job;
    String id;
    String createdAt;
    String email;
    String password;
}
