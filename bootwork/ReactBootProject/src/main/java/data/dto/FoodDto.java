package data.dto;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Alias("FoodDto")
public class FoodDto {
	private int num;
	private String fname;
	private String fphoto;
	private String fhp;
	private String fcontent;
	private String bookingday;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
	private Timestamp orderday;
}
