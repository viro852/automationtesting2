package ru.ibs.tests.dns;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.ibs.framework.dnsframework.utils.ProductConst;
import ru.ibs.framework.dnsframework.utils.ScreenShotExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
@ExtendWith(ScreenShotExtension.class)
public class DnsTest extends BaseTests {

    @Test
    void name() {
        pageManager.getStartPage().
                checkOpenPage().
                whatTownButtonClick().
                typeNameOfProductInSearchField(propManager.getProperty(ProductConst.SEARCH_PRODUCT_NAME)).
                checkOpenPage("Найдено:").
                selectProductByProductId(propManager.getProperty(ProductConst.PRODUCT_ID));
        assertTrue(false);
    }
}
