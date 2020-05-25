package com.wsh.register.score.api;

import com.wsh.register.score.api.payload.Score;
import com.wsh.register.score.api.service.ScoreService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@SpringBootTest
class RegisterScoreApiApplicationTests {

	@Autowired
	private ScoreService service;

	final static int qtdUsers = 100;
	final static AtomicInteger counter = new AtomicInteger();

	@Test
	void createUsersToScorePoints() {
		log.info("---------- tests ----------------");
		log.info("qtd users to import: " + qtdUsers);
		List<Score> lists = createMockScore();
		lists.stream().forEach(i-> {
			service.add(i);
		});
	}

	@Test
	void listsAllPositions() {
		service.findAllPositions();
	}

	private List<Score> createMockScore() {
		List<Score> lists = new ArrayList<>();
		for (int i=1; i<qtdUsers; i++) {
			lists.add(new Score()
					.setUserId(counter.incrementAndGet())
					.setPoints(counter.incrementAndGet()));
		}
		return lists;
	}
}
