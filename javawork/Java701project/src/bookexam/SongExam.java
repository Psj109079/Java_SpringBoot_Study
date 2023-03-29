package bookexam;

class Song{
	// page 187
	String title, artist;
	int length;
	
	Song(){
	}
	Song(String title){
		this.title = title;
	}
	Song(String title, String artist){
		this.title = title;
		this.artist = artist;
	}
	Song(String title, String artist, int length){
		this.title = title;
		this.artist = artist;
		this.length = length;
	}
	@Override
	public String toString() {
		return "Song [title=" + title + ", artist=" + artist + ", length=" + length + "]";
	}
	
}

public class SongExam {
	public static void main(String[] args) {
		Song s1 = new Song("Outward Bound", "Nana", 180);
		System.out.println(s1.toString());
		Song s2 = new Song("Jambalya", "Carpenters");
		System.out.println(s2.toString());
		Song s3 = new Song("Yesterday");
		System.out.println(s3.toString());
		Song s4 = new Song();
		System.out.println(s4.toString());
		
	}
}
