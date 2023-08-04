package data.dto;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Alias("MemoDto")
public class MemoDto {
	private int num;
	private String nickname;
	private String kormsg;
	private String engmsg;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
	private Timestamp writeday;
	
}
