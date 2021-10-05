package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
//        basePackages = "hello.core.member",//해당 패키지의 하위 클래스를 찾는다는 어노테이션
//        basePackageClasses = AutoAppConfig.class,//해당 클래스가 속한 패키지에서 찾는다는
//        ->결국엔 default를 추천하므로 최상단에 해당 설정 클래스를 위치하는 것이 좋다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)//해당 클래스 제외 필터링
)
public class AutoAppConfig {

}
