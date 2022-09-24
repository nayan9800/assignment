package yebelo.nayan.assignment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "next_number")
public class NextNumber {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int code;
	private int value;
	private int userId;
	
	public NextNumber() {}
	
	public NextNumber(int id, int code, int value, int userId) {
		this.id = id;
		this.code = code;
		this.value = value;
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}
