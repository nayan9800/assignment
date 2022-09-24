package yebelo.nayan.assignment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import yebelo.nayan.assignment.model.MyUser;

@Repository
public interface MyUserRepository extends CrudRepository<MyUser, Integer> {
	public MyUser getByUsername(String Username);
}
