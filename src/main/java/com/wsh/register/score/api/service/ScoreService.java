package com.wsh.register.score.api.service;

import com.wsh.register.score.api.exception.ScoreNotFoundException;
import com.wsh.register.score.api.payload.Position;
import com.wsh.register.score.api.payload.Score;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

@Slf4j
@Service
public class ScoreService {

    static Map<Integer, Score> map = new HashMap<>();
    final static AtomicInteger counter = new AtomicInteger();

    public void add(Score score) {
        Score s = map.get(score.getUserId());
        if (s == null) map.put(score.getUserId(), validateLimitPoints(score));
        else update(score);
        findAllPositions().stream().forEach(System.out::println);
    }

    private Score validateLimitPoints(Score score) {
        return new Score()
                .setUserId(score.getUserId())
                .setPoints((score.getPoints() > 20000) ? 20000 : score.getPoints());
    }

    private Score update(Score score) {
        Score scoreMap = map.get(score.getUserId());
        int points = scoreMap.getPoints() + score.getPoints();
        return scoreMap.setPoints((points > 20000) ? 20000 : points);
    }

    public Position findByUserIdPosition(int userId) {
        return findAllPositions().stream()
                .filter(o ->
                        o.getUserId().equals(userId))
                .findAny().orElseThrow(
                        () -> new ScoreNotFoundException("No records found for this userId: " + userId));
    }

    public List<Position> findAllPositions() {
        List<Position> lists = new ArrayList<>();
        map.entrySet().stream()
                .sorted(sort(t -> t.getValue().getPoints()))
                .forEach(i -> {
                    lists.add(new Position()
                            .setUserId(i.getValue().getUserId())
                            .setPoints(i.getValue().getPoints())
                            .setPosition(lists.size() + 1));
                });
        return lists;
    }

    private <T> Comparator<T> sort(Function<T, ? extends Comparable> attribute) {
        return (obj1, obj2) -> attribute.apply(obj2).compareTo(attribute.apply(obj1));
    }

    public List<Position> importScorePoints(int qtdScore) {
        List<Score> lists = createMockScore(qtdScore);
        lists.stream().forEach(i-> {
            add(i);
        });
        return findAllPositions();
    }

    private List<Score> createMockScore(int qtd) {
        List<Score> lists = new ArrayList<>();
        for (int i=1; i<qtd; i++) {
            lists.add(new Score()
                    .setUserId(counter.incrementAndGet())
                    .setPoints(counter.incrementAndGet()));
        }
        return lists;
    }
}