package com.core.models;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ErrorResponse {
    String error;
}
