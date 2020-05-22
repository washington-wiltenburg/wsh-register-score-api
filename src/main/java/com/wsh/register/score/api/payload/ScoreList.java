package com.wsh.register.score.api.payload;

import lombok.Data;

import java.util.List;

@Data
public class ScoreList {

    private List<Position> positions;
}
