package TDD;


import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AccountTest {
    //todo 클래스 이름 Account  - 완료
    //todo 기능 세가지
    //todo 잔고 조회
    //todo -10000원으로 계좌 생성
    // TODO: 2020-01-17 잔고 조회 결과 일치
    //todo 입금 - 완료
    //todo 출금
    //todo 금액은 원단위로

    @Test
    public void testAccount() throws Exception {
        Account account = new Account(1000);
    }

    @Test
    public void testGetBalance() throws Exception {
        Account account = new Account(10000);
        assertThat(10000, is(account.getBalance()));

        account = new Account(1000);
        assertThat(1000, is(account.getBalance()));

        account = new Account(0);
        assertThat(0, is(account.getBalance()));
    }

    @Test
    public void testDeposit() {
        Account account = new Account(10000);
        account.deposit(1000);
        assertThat(11000, is(account.getBalance()));
    }

    @Test
    public void testWithdraw() {
        Account account = new Account(10000);
        account.withdraw(1000);
        assertThat(9000, is(account.getBalance()));
    }


    public static void main(String[] args) {
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
