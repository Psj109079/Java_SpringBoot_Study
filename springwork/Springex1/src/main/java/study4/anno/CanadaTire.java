package study4.anno;

import org.springframework.stereotype.Component;

// @Component: xml ���� �ڵ����� bean�� ���(id�� �ڵ����� canadaTire)
// @Component("cTire"): id�� cTire �� �ȴ�

@Component
public class CanadaTire implements Tire {

	@Override
	public String getTireNmae() {
		return "ĳ���� Ÿ�̾�";
	}
}
