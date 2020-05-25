package com.wsh.register.score.api.controller;

import com.wsh.register.score.api.payload.Position;
import com.wsh.register.score.api.payload.Score;
import com.wsh.register.score.api.service.ScoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "ScoreEndpoint")
@Slf4j
@RestController
@RequestMapping("/api")
public class ScoreController {

    @Autowired
    private ScoreService service;

    @ApiOperation(value = "Create new score")
    @PostMapping(value = "/create")
    public void create(@RequestBody Score payload) {
        service.add(payload);
    }

    @ApiOperation(value = "Actual Position")
    @GetMapping(value = "/actual/position/{userId}")
    public Position position(@PathVariable("userId") Integer userId) {
        return service.findByUserIdPosition(userId);
    }

    @ApiOperation(value = "High Score List")
    @GetMapping(value = "/high/lists")
    public List<Position> highScoreList() {
        return service.findAllPositions();
    }
}