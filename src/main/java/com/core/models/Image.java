package com.core.models;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Image {
    int albumId;
    int id;
    String title;
    String path;
}
