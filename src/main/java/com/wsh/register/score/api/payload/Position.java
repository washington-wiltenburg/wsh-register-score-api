package com.wsh.register.score.api.payload;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({ "userId", "points", "position"})
public class Position extends Score {

    private Integer position;
}