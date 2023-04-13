package mycar.data;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
// 자동으로 minicar 라는 테이블이 mysql에 생성됨
@Table(name = "minicar")
@Data
public class MyCarDto {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long num;
	
	@Column(name = "carname", length = 100)
	private String carname;

	@Column(name = "carprice")
	private int carprice;
	
	@Column(name = "carcolor")
	private String carcolor;
	
	@Column(name = "carphoto")
	private String carphoto;

	// 날짜는 수정시 컬럼제외
	@Column(name = "writeday", updatable = false)
	@CreationTimestamp
	private Timestamp writeday;
	
	
	
}
