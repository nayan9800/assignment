package yebelo.nayan.assignment;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import yebelo.nayan.assignment.model.Code;
import yebelo.nayan.assignment.model.MyUser;
import yebelo.nayan.assignment.model.NextNumber;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
class FetchNumberControllerTest {

	@Autowired
	ObjectMapper o = new ObjectMapper();
	@Autowired
	private MockMvc mockMvc;
	
	
	@Test
	void signupTest() throws Exception {
	MyUser a = new MyUser();
	a.setUsername("user1");
	a.setPassword("pass1");
	
	mockMvc.perform(post("/signup")
			.contentType(MediaType.APPLICATION_JSON)
			.content(o.writeValueAsBytes(a))).andExpect(status().isCreated());
		   
	}	
	
	@Test
	void unauthorizedAddNumberTest() throws Exception{
		NextNumber n = new NextNumber();
		n.setCategoryCode(4);
		n.setNum(10);
		
		mockMvc.perform(post("/AddNumber")
				.contentType(MediaType.APPLICATION_JSON)
				.content(o.writeValueAsBytes(n))).andExpect(status().isUnauthorized());
	}
	
	
	@Test
	void unauthorizedFetchNextNumber() throws Exception{
		Code a = new Code();
		a.setCategoryCode(4);
		
		mockMvc.perform(get("/FetchNextNumber")
				.contentType(MediaType.APPLICATION_JSON)
				.content(o.writeValueAsBytes(a))).andExpect(status().isUnauthorized());
	}
	

	
}
