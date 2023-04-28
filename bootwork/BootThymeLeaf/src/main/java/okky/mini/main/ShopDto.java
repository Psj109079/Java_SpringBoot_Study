package okky.mini.main;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShopDto {
	private String sang;
	private String photo;
	private int su;
	private int dan;
}
