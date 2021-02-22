package com.hy.shortmessage.service;

import com.hy.shortmessage.common.algorithms.Base62And10;
import com.hy.shortmessage.common.idcenter.Idproduce;
import com.hy.shortmessage.domain.Shortmessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestIShortmessageService {

    @Autowired
    private IShortmessageService shortmessageService;


   /* public void testSaveMessage(){
        final Shortmessage shortmessage = new Shortmessage();
        final long id = Idproduce.getIdwork().getId();
        shortmessage.setId(id);
        final String shortKey = Base62And10.toBase62(id);
        shortmessage.setShortKey(shortKey);
        shortmessage.setOriginalUrl("https://t.bestsign.info/9udU/2ND4/F3y1");
        shortmessageService.saveShortmessage(shortmessage);
    }


    public void testSelectShortmessageByShortKey(){
        Shortmessage shortmessage=shortmessageService.selectShortmessageByShortKey("4Hpm3ViK");

        System.out.println(shortmessage.getOriginalUrl());

    }*/

    @Test
    public void testSelectShortmessageByOriginalUrl(){
        Shortmessage shortmessage=shortmessageService.selectShortmessageByOriginalUrl("https://t.bestsign.info/9udU/2ND4/F3y1");
        System.out.println(shortmessage.getShortKey());

    }
}
