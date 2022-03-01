package ru.ibs.framework.dnsframework.managers;

import ru.ibs.framework.dnsframework.pages.ProductPage;
import ru.ibs.framework.dnsframework.pages.ProductSelectionPage;
import ru.ibs.framework.dnsframework.pages.StartPage;

public class PageManager {

    private static PageManager pageManager;

    private StartPage startPage;

    private ProductSelectionPage productSelectionPage;

    private ProductPage productPage;


    private PageManager() {

    }

    public static PageManager getPageManager(){
        if(pageManager==null){
            pageManager=new PageManager();
        }
        return pageManager;
    }

    public StartPage getStartPage(){
        if (startPage==null){
            startPage=new StartPage();
        }
        return startPage;
    }

    public ProductSelectionPage getProductSelectionPage(){
        if (productSelectionPage==null){
           productSelectionPage=new ProductSelectionPage();
        }
        return productSelectionPage ;
    }

    public ProductPage getProductPage(){
        if (productPage==null){
            productPage=new ProductPage();
        }
        return productPage;
    }


}
