package yebelo.nayan.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import yebelo.nayan.assignment.MyUserRepository;
import yebelo.nayan.assignment.model.MyUser;

@Service
public class MyUserService implements UserDetailsService{

	@Autowired
	MyUserRepository myUserRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		MyUser user = myUserRepository.getByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username+" Not Found");
		}
		return User.builder().username(user.getUsername()).password(user.getPassword()).roles("USER")
				.build();
		
	}
	public void addUser(MyUser user) throws DataIntegrityViolationException {
		myUserRepository.save(user);
		
	}

}
