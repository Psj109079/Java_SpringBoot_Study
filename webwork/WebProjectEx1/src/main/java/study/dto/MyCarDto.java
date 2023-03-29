package study.dto;

public class MyCarDto {
	private int num;
	private String carname;
	private int carprice;
	private String carphoto;
	private String guipday;
	
	public MyCarDto() {
		super();
	}

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}

	public String getCarname() {
		return carname;
	}
	public void setCarname(String carname) {
		this.carname = carname;
	}

	public int getCarprice() {
		return carprice;
	}
	public void setCarprice(int carprice) {
		this.carprice = carprice;
	}

	public String getCarphoto() {
		return carphoto;
	}
	public void setCarphoto(String carphoto) {
		this.carphoto = carphoto;
	}

	public String getGuipday() {
		return guipday;
	}
	public void setGuipday(String guipday) {
		this.guipday = guipday;
	}
}
