package yebelo.nayan.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import yebelo.nayan.assignment.model.Code;
import yebelo.nayan.assignment.model.MyUser;
import yebelo.nayan.assignment.model.NextNumber;
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
	public NextNumber fecthBycode(@RequestBody Code c) {
		int categoryCode = c.getCategoryCode();
		return nextNumberService.getNumberByCode(categoryCode);
	}
	
	@PostMapping("/addNumber")
	public void AddNumber( @RequestBody NextNumber number) {
		
		nextNumberService.addNextNumber(number);
	}
	
	@PostMapping("/signup")
	public void signup( @RequestBody MyUser user) {
		myUserService.addUser(user);
	}
}
