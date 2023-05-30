package com.example.thishouse.domain.house;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class House_picture {
    private int house_picture_num;
    private int house_num;
    private String original_name;
    private String save_name;
    private long size;

    @Builder
    House_picture(String originalName, String saveName, long size) {
        this.original_name = originalName;
        this.save_name = saveName;
        this.size = size;
    }

}
