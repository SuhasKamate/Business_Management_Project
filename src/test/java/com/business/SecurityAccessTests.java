package com.business;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrlPattern;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class SecurityAccessTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void anonymousCanViewPublicPages() throws Exception {
		mockMvc.perform(get("/home")).andExpect(status().isOk());
		mockMvc.perform(get("/products")).andExpect(status().isOk());
		mockMvc.perform(get("/login")).andExpect(status().isOk());
	}

	@Test
	void anonymousIsRedirectedFromAdminArea() throws Exception {
		mockMvc.perform(get("/admin/services"))
				.andExpect(status().is3xxRedirection())
				.andExpect(redirectedUrlPattern("**/login"));
	}

	@Test
	void postWithoutCsrfTokenIsRejected() throws Exception {
		// CSRF protection blocks cross-site POSTs before authorization runs
		mockMvc.perform(post("/deleteUser/1"))
				.andExpect(status().isForbidden());
	}

	@Test
	void anonymousCannotDeleteAUserEvenWithCsrf() throws Exception {
		mockMvc.perform(post("/deleteUser/1").with(csrf()))
				.andExpect(status().is3xxRedirection())
				.andExpect(redirectedUrlPattern("**/login"));
	}

	@Test
	void anonymousCannotDeleteAProductEvenWithCsrf() throws Exception {
		mockMvc.perform(post("/deleteProduct/1").with(csrf()))
				.andExpect(status().is3xxRedirection())
				.andExpect(redirectedUrlPattern("**/login"));
	}

	@Test
	void anonymousCannotPlaceAnOrderEvenWithCsrf() throws Exception {
		mockMvc.perform(post("/product/order")
						.with(csrf())
						.param("productName", "Tea")
						.param("oQuantity", "1"))
				.andExpect(status().is3xxRedirection())
				.andExpect(redirectedUrlPattern("**/login"));
	}
}
