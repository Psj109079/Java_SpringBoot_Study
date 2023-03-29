package study.day0321;

import java.sql.Timestamp;

public class OracleShopDto {
	private int num;
	private String sangpum;
	private String color;
	private int su;
	private int dan;
	private Timestamp today;

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}

	public String getSangpum() {
		return sangpum;
	}
	public void setSangpum(String sangpum) {
		this.sangpum = sangpum;
	}

	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	public int getSu() {
		return su;
	}
	public void setSu(int su) {
		this.su = su;
	}

	public int getDan() {
		return dan;
	}
	public void setDan(int dan) {
		this.dan = dan;
	}

	public Timestamp getToday() {
		return today;
	}
	public void setToday(Timestamp today) {
		this.today = today;
	}
}
