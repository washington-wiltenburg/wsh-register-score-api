package com.wsh.register.score.api.service;

import com.wsh.register.score.api.exception.ScoreNotFoundException;
import com.wsh.register.score.api.payload.Position;
import com.wsh.register.score.api.payload.Score;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;

@Slf4j
@Service
public class ScoreService {

    static Map<Integer, Score> map = new HashMap<>();

    public void add(Score score) {
        Score s = map.get(score.getUserId());
        if (s == null) map.put(score.getUserId(), new Score()
                .setUserId(score.getUserId())
                .setPoints((score.getPoints() > 20000) ? 20000 : score.getPoints()));
        else update(score, findByUserIdPosition(score.getUserId()));
        findAllPositions().stream().forEach(System.out::println);
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
                .sorted(sort(t -> t.getValue().getPoints(), true))
                .forEach(i -> {
                    lists.add(new Position()
                            .setUserId(i.getValue().getUserId())
                            .setPoints(i.getValue().getPoints())
                            .setPosition(lists.size() + 1));
                });
        return lists;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private <T> Comparator<T> sort(Function<T, ? extends Comparable> attribute, boolean descending) {
        if (descending) {
            return (o1, o2) -> attribute.apply(o2).compareTo(attribute.apply(o1));
        }
        return (o1, o2) -> attribute.apply(o1).compareTo(attribute.apply(o2));
    }

    private Position update(Score score, Position result) {
        int points = result.getPoints() + score.getPoints();
        return result.setPoints((points > 20000) ? 20000 : points);
    }
}