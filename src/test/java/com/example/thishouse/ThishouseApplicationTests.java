package com.example.thishouse;

import com.example.thishouse.domain.testDTO;
import com.example.thishouse.mapper.TestMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ThishouseApplicationTests {
	@Autowired
	private TestMapper testMapper;

	@Test
	void contextLoads() {
	}

	@Test
	public void testOfInsert() {
		testDTO testdto = new testDTO();
		testdto.setIdx(9999);
		testdto.setName("공선환");

		int result = testMapper.insertTest(testdto);
		System.out.println("결과는"+result+"입니다");
	}

}
