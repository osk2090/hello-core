package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class PrototypeTest {

    /*
    요약하자면 싱글톤은 하나만 객체를 생성하고 추가로 생성하더라도 똑같은 객체의 주소값을 전달해준다.그리고 스프링 컨테이너에서 컨트롤이 가능하다
    하지만 프로토타입은 객체를 생성하고 바로 스프링 컨테이너로부터 독립되기 때문에 권한이 없다.
    그래서 추가로 생성하면 새로운 주소값을 리턴하며 별도로 close를 해줘야 한다.
     */

    @Test
    void prototypeBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        System.out.println("find prototypeBean1");
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);

        System.out.println("find prototypeBean2");
        PrototypeBean prototypeBean2= ac.getBean(PrototypeBean.class);

        System.out.println("prototypeBean1 = " + prototypeBean1);
        System.out.println("prototypeBean2 = " + prototypeBean2);

        Assertions.assertThat(prototypeBean1).isNotSameAs(prototypeBean2);

        prototypeBean1.destroy();//스프링 컨테이너의 관할에서 벗어나기때문에 별도로 close를 선언해줘야 한다.
        prototypeBean2.destroy();

        ac.close();//소용이 없다.
    }

    @Scope("prototype")
    static class PrototypeBean {
        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeBean.destroy");
        }
    }

}
