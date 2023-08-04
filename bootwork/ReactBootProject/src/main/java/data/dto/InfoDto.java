package data.dto;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Alias("InfoDto")
public class InfoDto {
	private int num;
	private String irum;
	private String address;
	private String photo;
	private String birthday;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Timestamp gaipday;
}
