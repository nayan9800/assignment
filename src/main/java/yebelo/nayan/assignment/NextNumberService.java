package yebelo.nayan.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NextNumberService {
	
	@Autowired
	NextNumberRepository nextNumberRepository;

	
	public void addNextNumber(NextNumber n) {
		nextNumberRepository.save(n);
	}
	
	public NextNumber getNumberByCode(int code) {
		
		return  nextNumberRepository.getByCode(code);
	}
}
