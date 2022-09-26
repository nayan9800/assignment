package yebelo.nayan.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yebelo.nayan.assignment.MyUserRepository;
import yebelo.nayan.assignment.NextNumberRepository;
import yebelo.nayan.assignment.model.MyUser;
import yebelo.nayan.assignment.model.NextNumber;
import yebelo.nayan.assignment.model.Values;

@Service
public class NextNumberService {
	
	@Autowired
	NextNumberRepository nextNumberRepository;

	@Autowired
	MyUserRepository myUserRepository;

	
	public void addNextNumber(NextNumber n,String username) {
	
		MyUser u = myUserRepository.getByUsername(username);
		n.setUserId(u.getId());
		nextNumberRepository.save(n);
	}
	
	public Values getNumberByCode(int code, String username) {	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			MyUser u = myUserRepository.getByUsername(username);
			NextNumber byCode = nextNumberRepository.getByCategoryCodeAndUserId(code, u.getId());
			if(byCode == null) {
				return new Values(0, 0);
			}
			
			int newValue = updateValue(byCode.getNum());
			Values v = new Values(byCode.getNum(), newValue);
			byCode.setNum(newValue);
			nextNumberRepository.save(byCode);
			
			return v;
		}
	
		public  int updateValue(int oldValue) {
		for (int i = oldValue+1; i > oldValue; i++) {
			if(i%9==1) {
				return i;
			}
		}
		return 0;
	}
}
