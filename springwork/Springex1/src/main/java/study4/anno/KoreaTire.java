package study4.anno;

import org.springframework.stereotype.Component;

@Component
public class KoreaTire implements Tire {

	@Override
	public String getTireNmae() {
		return "한국 타이어";
	}
}
