package com.wsh.register.score.api.controller;

import com.wsh.register.score.api.payload.Position;
import com.wsh.register.score.api.payload.Score;
import com.wsh.register.score.api.payload.ScoreList;
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
@RequestMapping("/api/score")
public class ScoreController {

    @Autowired
    private ScoreService service;

    @ApiOperation(value = "Create new score")
    @PostMapping
    public void createScore(@RequestBody Score payload) {
        log.info("-- created score --");
    }

    @ApiOperation(value = "Actual Position")
    @GetMapping(value = "/userId")
    public Position position(@PathVariable("userId") Integer userId) {
        return null;
    }

    @ApiOperation(value = "High Score List")
    @GetMapping
    public List<ScoreList> highScoreList() {
        return null;
    }
}