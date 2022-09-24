package yebelo.nayan.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FetchNumberController {

	@Autowired
	NextNumberService nextNumberService;

	@GetMapping("/FetchNextNumber")
	public NextNumber fecthBycode(@RequestBody Code c) {
		int categoryCode = c.getCategoryCode();
		return nextNumberService.getNumberByCode(categoryCode);
	}
	
	@PostMapping("/addNumber")
	public void AddNumber( @RequestBody NextNumber number) {
		
		nextNumberService.addNextNumber(number);
	}
}
