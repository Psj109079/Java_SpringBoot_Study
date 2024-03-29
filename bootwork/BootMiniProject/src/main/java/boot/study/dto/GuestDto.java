package boot.study.dto;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Alias("GuestDto") // 안쓰면 패키지 이름 + 클래스 이름을 줘야함
public class GuestDto {
	private int guest_idx;
	private String nickname;
	private String content;
	private List<GuestPhotoDto> photoList;
	@JsonFormat(pattern = "yyyy-MM-dd HH-mm", timezone = "Asia/Seoul")
	private Timestamp writeday;
}
