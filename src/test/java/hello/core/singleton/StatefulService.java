package hello.core.singleton;

public class StatefulService {
//    private int price;//상태를 유지하는 필드
//    -> 결국엔 하나의 공간을 가지기 때문에(새로운 인스턴스 생성x) 최신 값으로 저장되기 때문에
//    이전의 데이터는 덮어진다.

    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
//        this.price = price;//여기가 문제!
        return price;
    }
}
