package pl.com.bottega.ecommerce.sharedkernel;

import org.junit.Test;

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
    }

    @Test
    public void getCurrencyCode() {
    }

    @Test
    public void getCurrency() {
    }

    @Test
    public void greaterThan() {
    }

    @Test
    public void lessThan() {
    }

    @Test
    public void lessOrEquals() {
    }
}