import com.teamword.dao.Giuongbenhlmpl;
import com.teamword.model.Giuongbenh;
import junit.framework.*;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import java.lang.String;
import java.math.BigDecimal;
import java.util.List;


public class testGiuongbenh {
   ClassPathXmlApplicationContext context  = new ClassPathXmlApplicationContext("spring-config");
   Giuongbenhlmpl gbDao=(Giuongbenhlmpl) context.getBean("gbDao");

@Test
    public  void testcreteGiuongbenh (){
    Giuongbenh gb = new Giuongbenh();
    try{
            gb.setName("Thuongabc");
            gb.setPrice(new BigDecimal(100000.0000) );
            gb.setDescription("Giuong benh gianh cho benh vien o lau kinh te thap");
            gbDao.create(gb);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }


    }

    @Test
    public  void testdelete (){
        Giuongbenh gb = new Giuongbenh();
        try{
            gbDao.delete(7);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }


    }

    @Test
    public  void testget (){
        Giuongbenh gb = new Giuongbenh();
        try{
          gb =gbDao.get(2);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }



    @Test
        public void getAll(){
            try {
                List<Giuongbenh> dsGiuongbenh = gbDao.getall();
                Assert.assertNotNull(dsGiuongbenh);
               // Assert.assertNotSame(0,dsGiuongbenh.size());
               // Assert.assertEquals("0",dsGiuongbenh);
            } catch (Exception e) {
                e.printStackTrace();
                Assert.fail();
            }


    }
}
