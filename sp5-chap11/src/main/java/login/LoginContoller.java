package login;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginContoller {

	@GetMapping
	public ModelAndView loginform(JobCode jobCode, Code codeList, Login login, ModelAndView mav) {

		List<Code> codes = new ArrayList<>();
		codes.add(new Code("일반회원", "일반"));
		codes.add(new Code("기업회원", "기업"));
		codes.add(new Code("헤드헌터회원", "헤드헌터"));
		List<String> loginTypes = Arrays.asList("일반회원", "기업회원", "헤드헌터회원");
		mav.addObject("loginTypes", loginTypes);
		mav.addObject("jobCode", codes);
		mav.setViewName("login/form");
		return mav;
	}
}
