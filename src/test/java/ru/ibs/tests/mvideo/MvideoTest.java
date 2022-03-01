package ru.ibs.tests.mvideo;

import org.junit.jupiter.api.Test;

public class MvideoTest extends BaseTests{



    @Test
    void someTest() {
pageManagerMVideo.getStartPage().
        typeRequestToSearchLineButtonAndEnter("iphone").
        chooseTheRightProduct("3056059036");

    }
}
