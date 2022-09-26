package yebelo.nayan.assignment;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import yebelo.nayan.assignment.model.Code;
import yebelo.nayan.assignment.model.MyUser;
import yebelo.nayan.assignment.model.NextNumber;
import yebelo.nayan.assignment.model.Values;
import yebelo.nayan.assignment.service.MyUserService;
import yebelo.nayan.assignment.service.NextNumberService;

@RestController
@Validated
public class FetchNumberController {

	@Autowired
	NextNumberService nextNumberService;
	
	@Autowired
	MyUserService myUserService;

	@GetMapping("/FetchNextNumber")
	public Values fecthBycode(@RequestBody Code c,Principal principal) {
		int categoryCode = c.getCategoryCode();
		return nextNumberService.getNumberByCode(categoryCode,principal.getName());
	}
	
	@PostMapping("/addNumber")
	public void AddNumber( @RequestBody NextNumber number,Principal principal) {
		
		nextNumberService.addNextNumber(number,principal.getName());
	}
	
	@PostMapping("/signup")
	public ResponseEntity<String> signup( @RequestBody MyUser user) {
		try {
		myUserService.addUser(user);
		return new ResponseEntity<String>("",HttpStatus.CREATED);
		}catch(DataIntegrityViolationException d) {
			return new ResponseEntity<String>("Username already Exists",HttpStatus.BAD_REQUEST);
		}
	}
}
