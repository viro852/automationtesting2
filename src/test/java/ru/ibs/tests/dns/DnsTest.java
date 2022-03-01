package ru.ibs.tests.dns;

import org.junit.jupiter.api.Test;
import ru.ibs.framework.dnsframework.utils.ProductConst;


public class DnsTest extends BaseTests {


    @Test
    void name() {

        pageManager.getStartPage().
                checkOpenPage().
                whatTownButtonClick().
                typeNameOfProductInSearchField(propManager.getProperty(ProductConst.SEARCH_PRODUCT_NAME)).
                checkOpenPage("Найдено:").
                selectProductByProductId(propManager.getProperty(ProductConst.PRODUCT_ID)).
                checkOpenPage("Код товара: 4710978").
                clickBuyButton().
                clickEmergingAddToCartButton();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
