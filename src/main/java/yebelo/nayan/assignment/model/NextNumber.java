package yebelo.nayan.assignment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nextnumber")
public class NextNumber {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int categoryCode;
	private int num;
	private int userId;
	
	public NextNumber() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(int categoryCode) {
		this.categoryCode = categoryCode;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "NextNumber [id=" + id + ", categoryCode=" + categoryCode + ", num=" + num + ", userId=" + userId + "]";
	}
	
	
}
