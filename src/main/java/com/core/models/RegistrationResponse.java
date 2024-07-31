package com.core.models;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegistrationResponse {
    String id;
    String token;
}
