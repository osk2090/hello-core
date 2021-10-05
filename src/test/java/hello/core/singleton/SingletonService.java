package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();//static 영역에 한번만 인스턴스 생성

    public static SingletonService getInstance() {//이 메서드를 통해서 조회
        return instance;
    }

    private SingletonService() {//생성자를 private로 막아서 외부에서 인스턴스 생성 막아줌

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
