package pl.com.bottega.ecommerce.sharedkernel;

import org.junit.Test;

import java.util.Currency;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class MoneyTest {

    @Test
    public void multiplyBy() {
        Money instance = new Money(10);
        Money expectedResult = new Money(1_000);

        assertThat(expectedResult, equalTo(instance.multiplyBy(100)));
    }

    @Test
    public void add() {
        Money lhs = new Money(10);
        Money rhs = new Money(12);

        Money expectedResult = new Money(22);
        Money result = lhs.add(rhs);

        assertThat(expectedResult, equalTo(result));
    }

    @Test
    public void subtract() {
        Money lhs = new Money(15);
        Money rhs = new Money(8);

        Money expectedResult = new Money(7);
        Money result = lhs.subtract(rhs);

        assertThat(expectedResult, equalTo(result));
    }

    @Test
    public void getCurrencyCode() {
        Money instance = new Money(10);
        assertThat(instance.getCurrencyCode(), equalTo(Money.DEFAULT_CURRENCY));
    }

    @Test
    public void greaterThan() {
        Money lhs = new Money(1);
        Money rhs = new Money(7);

        assertThat(lhs.lessThan(rhs), equalTo(true));

    }

    @Test
    public void lessThan() {
    }

    @Test
    public void lessOrEquals() {
    }
}