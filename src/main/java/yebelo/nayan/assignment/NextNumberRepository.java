package yebelo.nayan.assignment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import yebelo.nayan.assignment.model.NextNumber;

@Repository
public interface NextNumberRepository extends CrudRepository<NextNumber, Integer>{

	public NextNumber getByCode(int code);
}
