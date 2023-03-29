package study.day0307;

public class Sawon {
	private String name;
	private String blood;
	private String buseo;
	private String gender;
	
	public Sawon() {
		this.buseo = "관리부";
	}

	public Sawon(String name, String buseo) {
		super();
		this.name = name;
		this.buseo = buseo;
	}

	public Sawon(String name, String blood, String buseo, String gender) {
		super();
		this.name = name;
		this.blood = blood;
		this.buseo = buseo;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getBlood() {
		return blood;
	}
	public void setBlood(String blood) {
		this.blood = blood;
	}

	public String getBuseo() {
		return buseo;
	}
	public void setBuseo(String buseo) {
		this.buseo = buseo;
	}

	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
	
}
