package shop.dto;

public class BasketListDto {
	private int prinum;

	private String id;
	private int num;
	private String image;
	private String name;
	private String size;
	private int price;
	
	public BasketListDto() {
		super();
	}

	public int getPrinum() {
		return prinum;
	}
	public void setPrinum(int prinum) {
		this.prinum = prinum;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}

	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
