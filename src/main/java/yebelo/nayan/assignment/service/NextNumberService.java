package yebelo.nayan.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yebelo.nayan.assignment.NextNumberRepository;
import yebelo.nayan.assignment.model.NextNumber;

@Service
public class NextNumberService {
	
	@Autowired
	NextNumberRepository nextNumberRepository;

	
	public void addNextNumber(NextNumber n) {
		nextNumberRepository.save(n);
	}
	
	public NextNumber getNumberByCode(int code) {	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  nextNumberRepository.getByCode(code);
	}
	
	NextNumber updateNextNumber(NextNumber old) {
		
		
		return null;
	}
}
