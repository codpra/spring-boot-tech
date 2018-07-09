package cn.alittler.web.rest;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

/**
 * 实体Rest接口测试代码
 *
 * @author LiuDecai
 * @date 2018/6/26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeRestTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	static HttpHeaders headers = new HttpHeaders();
	static MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

	@Test
	public void test001Create() throws Exception {
		params.clear();
		params.add("name", "刘德财");
		params.add("birthday", "1993-10-01");
		String uri = "/emps";
		String result = mockMvc
				.perform(MockMvcRequestBuilders.post(uri).headers(headers).params(params)
						.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("刘德财")).andReturn().getResponse()
				.getContentAsString();
		logger.info(result);
	}

	@Test
	public void test002GetById() throws Exception {
		params.clear();
		String uri = "/emps/1";
		String result = mockMvc
				.perform(MockMvcRequestBuilders.get(uri).headers(headers).params(params)
						.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("刘德财")).andReturn().getResponse()
				.getContentAsString();
		logger.info(result);
	}

	@Test
	public void test003UpdateById() throws Exception {
		params.clear();
		params.add("id", "1");
		params.add("name", "德才");
		params.add("birthday", "1993-9-01");
		String uri = "/emps";
		String result = mockMvc
				.perform(MockMvcRequestBuilders.put(uri).headers(headers).params(params)
						.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("德才")).andReturn().getResponse()
				.getContentAsString();
		logger.info(result);
	}

	@Test
	public void test004GetPage() throws Exception {
		params.clear();
		params.add("pageNo", "0");
		params.add("pageSize", "5");
		String uri = "/emps/page";
		String result = mockMvc
				.perform(MockMvcRequestBuilders.get(uri).headers(headers).params(params)
						.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.first").value("true")).andReturn().getResponse()
				.getContentAsString();
		logger.info(result);
	}

	@Test
	public void test005GetAll() throws Exception {
		params.clear();
		String uri = "/emps";
		String result = mockMvc
				.perform(MockMvcRequestBuilders.get(uri).headers(headers).params(params)
						.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.status().is2xxSuccessful()).andReturn().getResponse()
				.getContentAsString();
		logger.info(result);
	}

	@Test
	public void test006Delete() throws Exception {
		params.clear();
		params.add("id", "1");
		String uri = "/emps";
		String result = mockMvc
				.perform(MockMvcRequestBuilders.delete(uri).headers(headers).params(params)
						.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("删除成功")).andReturn().getResponse()
				.getContentAsString();
		logger.info(result);
	}

}