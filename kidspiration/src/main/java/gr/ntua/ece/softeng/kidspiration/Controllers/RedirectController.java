package gr.ntua.ece.softeng.kidspiration.Controllers;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class RedirectController {
	
	@RequestMapping({ "/home", "/user-login", "/parent-register", "/provider-register", "/event-register", "/search", "/faq", "/about-us", "/contacts",
	"/terms", "/points", "/parent-profile/**", "/provider-profile/**", "/event-page/**", "/reset-pass", "/adminlogin", "/control-panel"})
/*	public String index() {

	return "forward:/index.html";
	}
}
*/
	public ModelAndView redirectWithUsingForwardPrefix(ModelMap model) {
		model.addAttribute("attribute", "forwardWithForwardPrefix");
		return new ModelAndView("forward:/index.html", model);
	}
}