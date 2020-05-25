package com.wsh.register.score.api.payload;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({ "score", "position"})
public class Position {

    private Score score;
    private Integer position;
}