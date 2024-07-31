package com.core.models;

import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Photo {
    int albumId;
    int id;
    String title;
    String url;
    String thumbnailUrl;

}
