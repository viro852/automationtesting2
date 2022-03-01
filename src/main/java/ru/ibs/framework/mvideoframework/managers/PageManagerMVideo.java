package ru.ibs.framework.mvideoframework.managers;

import ru.ibs.framework.mvideoframework.pages.ProductListingPage;
import ru.ibs.framework.mvideoframework.pages.StartPage;

public class PageManagerMVideo {

    private static PageManagerMVideo pageManagerMVideo;
    private StartPage startPage;
    private ProductListingPage productListingPage;

    private PageManagerMVideo(){

    }

    public static PageManagerMVideo getInstance(){
        if(pageManagerMVideo==null){
            pageManagerMVideo=new PageManagerMVideo();
        }
        return pageManagerMVideo;
    }

    public StartPage getStartPage(){
        if(startPage==null){
            startPage=new StartPage();
        }
        return startPage;
    }

    public ProductListingPage getProductListingPagePage(){
        if(productListingPage==null){
            productListingPage=new ProductListingPage();
        }
        return productListingPage;
    }

}
