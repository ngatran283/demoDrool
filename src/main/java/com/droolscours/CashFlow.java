package com.droolscours;

import java.text.DateFormat;
import java.util.Date;

public class CashFlow {
	private Date date;
	private int type;
	private long accountNo;
	private double amount;
	public static int CREDIT = 1;
	public static int DEBIT = 2;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer buff = new StringBuffer();
		buff.append("-----CashFlow-----)\n");
		buff.append("Account no=" + this.accountNo + "\n");
		if (this.date != null) {
			buff.append("Mouvement Date= " + DateFormat.getDateInstance().format(this.date) + "\n");
		} else {
			buff.append("No Mouvement date was set\n");
		}
		buff.append("Mouvement Amount=" + this.amount + "\n");
		buff.append("-----CashFlow end--)");
		return buff.toString();
	}
}
