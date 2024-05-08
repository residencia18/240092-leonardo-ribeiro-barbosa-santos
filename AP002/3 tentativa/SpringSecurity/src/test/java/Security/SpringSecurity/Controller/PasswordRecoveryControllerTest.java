package Security.SpringSecurity.Controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import Security.SpringSecurity.controller.PasswordRecoveryController;

class PasswordRecoveryControllerTest {

	@Autowired
	private MockMvc mockmvc;
	
	@Autowired
	 private PasswordRecoveryController passwordRecoveryController;
	
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
