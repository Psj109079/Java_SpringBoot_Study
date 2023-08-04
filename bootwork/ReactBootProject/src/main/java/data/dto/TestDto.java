package data.dto;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Alias("Testdto")
public class TestDto {
	@ApiModelProperty(example = "1")
	private int num;
	@ApiModelProperty(example = "lee")
	private String irum;
	@ApiModelProperty(example = "hello")
	private String message;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
	private Timestamp writeday;
	
}
