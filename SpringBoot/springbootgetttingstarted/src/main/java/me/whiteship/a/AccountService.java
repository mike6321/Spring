package me.whiteship.a;

import org.springframework.stereotype.Service;
/*ComponentScan
* 이 패키지의 하위의 클래스 까지도 빈으로 등록해준다.
* 단, 패키지 상위는 빈으로 등록되지 않는다.
* */
@Service
public class AccountService {
}
