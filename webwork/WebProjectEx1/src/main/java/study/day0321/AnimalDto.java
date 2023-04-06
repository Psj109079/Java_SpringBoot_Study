package study.day0321;

public class AnimalDto {
	String animalName;
	int animalAge;
	String animalPhoto;
	
	public AnimalDto() {
		super();
	}

	public AnimalDto(String animalName, int animalAge, String animalPhoto) {
		super();
		this.animalName = animalName;
		this.animalAge = animalAge;
		this.animalPhoto = animalPhoto;
	}

	public String getAnimalName() {
		return animalName;
	}

	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}

	public int getAnimalAge() {
		return animalAge;
	}

	public void setAnimalAge(int animalAge) {
		this.animalAge = animalAge;
	}

	public String getAnimalPhoto() {
		return animalPhoto;
	}

	public void setAnimalPhoto(String animalPhoto) {
		this.animalPhoto = animalPhoto;
	}
}
