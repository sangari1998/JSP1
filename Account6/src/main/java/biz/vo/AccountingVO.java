package biz.vo;

import java.util.Date;

public class AccountingVO {
	private long seq;
	private Date regdate;
	private String category;
	private long money;
	private String note;
	
	public AccountingVO() {}

	public long getSeq() {
		return seq;
	}

	public void setSeq(long seq) {
		this.seq = seq;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public long getMoney() {
		return money;
	}

	public void setMoney(long money) {
		this.money = money;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	
}
