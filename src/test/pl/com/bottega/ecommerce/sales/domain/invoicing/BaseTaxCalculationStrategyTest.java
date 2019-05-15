package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.Before;
import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.util.Date;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class BaseTaxCalculationStrategyTest {

    private BaseTaxCalculationStrategy sut;

    private RequestItem getFoodRequestItem() {
        ProductType productType = ProductType.FOOD;
        ProductData productData = new ProductData(Id.generate(), new Money(100), "test-product", productType, new Date());
        return new RequestItem(productData, 1, new Money(100));
    }

    @Before
    public void setUp() throws Exception {
        sut = new BaseTaxCalculationStrategy();
    }

    @Test
    public void shouldReturn7PercentTaxForFood() {
        RequestItem requestItem = getFoodRequestItem();

        Money expectedTax = new Money(7);

        assertThat(sut.calculate(requestItem).getAmount(), equalTo(expectedTax));
    }

}

