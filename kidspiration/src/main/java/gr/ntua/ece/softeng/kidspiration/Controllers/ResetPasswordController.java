package gr.ntua.ece.softeng.kidspiration.Controllers;

import gr.ntua.ece.softeng.kidspiration.ResetPassword;
import gr.ntua.ece.softeng.kidspiration.Salt;
import gr.ntua.ece.softeng.kidspiration.SendResetEmail;
import gr.ntua.ece.softeng.kidspiration.Services.ParentService;
import gr.ntua.ece.softeng.kidspiration.Services.ProviderService;
import gr.ntua.ece.softeng.kidspiration.StringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class ResetPasswordController {

	@Autowired
	ParentService parentService;

	@Autowired
	ProviderService providerService;

	@RequestMapping(path="/api/reset/parent", method = RequestMethod.POST)
	public ResponseEntity<?> resetParent(@RequestBody String username) {

		String delims = "[:}]"; // "[:\"}]";  // CHECK PARSING WITH STRING
		String[] tokens = username.split(delims);
		System.out.println(tokens[1]);
		String user = tokens[1];

		try {
			parentService.addHashedUser(user);
		} catch (Exception ex) {
			System.out.println(ex);
			return ResponseEntity.badRequest().body("Error");
		}
			return ResponseEntity.accepted().body("OK");
	}

	@RequestMapping(path="/api/reset/provider", method = RequestMethod.POST)
	public ResponseEntity<?> resetProvider(@RequestBody String username) {

		String delims = "[:}]"; // "[:\"}]";  // CHECK PARSING WITH STRING
		String[] tokens = username.split(delims);
		System.out.println(tokens[1]);
		String user = tokens[1];

		try {
			providerService.addHashedUser(user);
		} catch (Exception ex) {
			System.out.println(ex);
			return ResponseEntity.badRequest().body("Error");
		}
		return ResponseEntity.accepted().body("OK");
	}

	@RequestMapping (path = "/api/password_change/parent", method = RequestMethod.POST)
	public ResponseEntity<?> resetPasswordParent(@RequestBody ResetPassword resetPassword) {

		boolean	reset;
		reset = parentService.resetPassword(resetPassword.getPseudoPassword(), resetPassword.getSalt(), resetPassword.getNewPassword());
		if (reset == true)
			return ResponseEntity.accepted().body("OK");
		else
			return ResponseEntity.badRequest().body("Error");
	}

	@RequestMapping (path = "/api/password_change/provider", method = RequestMethod.POST)
	public ResponseEntity<?> resetPasswordProvider(@RequestBody ResetPassword resetPassword) {

		boolean	reset;
		reset = providerService.resetPassword(resetPassword.getPseudoPassword(), resetPassword.getSalt(), resetPassword.getNewPassword());
		if (reset == true)
			return ResponseEntity.accepted().body("OK");
		else
			return ResponseEntity.badRequest().body("Error");
	}

	
	
	
	
	
	

}