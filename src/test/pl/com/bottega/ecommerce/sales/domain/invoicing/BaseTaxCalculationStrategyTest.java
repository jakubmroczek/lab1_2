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

    private RequestItem getRequestItem(ProductType productType) {
        ProductData productData = new ProductData(Id.generate(), new Money(100), "test-product", productType, new Date());
        return new RequestItem(productData, 1, new Money(100));
    }

    @Before
    public void setUp() throws Exception {
        sut = new BaseTaxCalculationStrategy();
    }

    @Test
    public void shouldReturn7PercentTaxForFood() {
        RequestItem requestItem = getRequestItem(ProductType.FOOD);

        Money expectedTax = new Money(7);

        assertThat(sut.calculate(requestItem).getAmount(), equalTo(expectedTax));
    }

    @Test
    public void shouldReturn5PercentTaxForDrug() {
        RequestItem requestItem = getRequestItem(ProductType.DRUG);

        Money expectedTax = new Money(5);

        assertThat(sut.calculate(requestItem).getAmount(), equalTo(expectedTax));
    }

    @Test
    public void shouldReturn23PercentTaxForStandard() {
        RequestItem requestItem = getRequestItem(ProductType.STANDARD);

        Money expectedTax = new Money(23);

        assertThat(sut.calculate(requestItem).getAmount(), equalTo(expectedTax));
    }

}

