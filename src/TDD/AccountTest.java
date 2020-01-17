package TDD;


import org.junit.Test;

public class AccountTest {
    //todo 클래스 이름 Account  - 완료
    //todo 기능 세가지
    //todo 잔고 조회
    //todo 입금
    //todo 출금
    //todo 금액은 원단위로

    @Test
    public void testAccount() throws Exception {
        Account account = new Account();
    }

    public static void main(String[] args)  {
        AccountTest test = new AccountTest();
        try {
            test.testAccount(); // 계좌 생성 테스트
            //test.testBalance(); // 잔고 조회 테스트
        } catch (Exception e) {
            System.out.println("실패(X)"); //예외가 발생하면 실패(x)
            return;
        }
        System.out.println("성공(o)");

    }

}
