package com.wsh.register.score.api.payload;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({"userId", "points"})
public class Score {
    private Integer userId;
    private Integer points;
}
