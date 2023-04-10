package study4.anno;

import org.springframework.stereotype.Component;

// @Component: xml 없이 자동으로 bean을 등록(id는 자동으로 canadaTire)
// @Component("cTire"): id가 cTire 가 된다

@Component
public class CanadaTire implements Tire {

	@Override
	public String getTireNmae() {
		return "캐나다 타이어";
	}
}
