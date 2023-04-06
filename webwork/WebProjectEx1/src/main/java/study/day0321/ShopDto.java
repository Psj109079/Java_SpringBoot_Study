package study.day0321;

public class ShopDto {
	private String sangpumName;
	private int sangpumPrice;
	private String sangpumColor;
	private String sangpumPhoto;
	
	//디폴트 생성자
	public ShopDto() {
		super();
	}

	
	
	//인자있는 생성자
	public ShopDto(String sangpumName, int sangpumPrice, String sangpumColor, String sangpumPhoto) {
		super();
		this.sangpumName = sangpumName;
		this.sangpumPrice = sangpumPrice;
		this.sangpumColor = sangpumColor;
		this.sangpumPhoto = sangpumPhoto;
	}
	//setter & getter
	public String getSangpumName() {
		return sangpumName;
	}



	public void setSangpumName(String sangpumName) {
		this.sangpumName = sangpumName;
	}



	public int getSangpumPrice() {
		return sangpumPrice;
	}



	public void setSangpumPrice(int sangpumPrice) {
		this.sangpumPrice = sangpumPrice;
	}



	public String getSangpumColor() {
		return sangpumColor;
	}



	public void setSangpumColor(String sangpumColor) {
		this.sangpumColor = sangpumColor;
	}



	public String getSangpumPhoto() {
		return sangpumPhoto;
	}



	public void setSangpumPhoto(String sangpumPhoto) {
		this.sangpumPhoto = sangpumPhoto;
	}
	
}
