package com.ahinski.meetupapi;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = MeetupApiApplication.class)
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
class MeetupApiApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoadsTest() throws Exception {
		this.mockMvc.perform(get("/meetups"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Add new meetup")));
	}

}
