import com.week7i.share.service.CommonService;
import com.week7i.share.service.SystemService;
import com.week7i.share.util.SpringContextHolder;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CommonTest {

    @Test
    public void common(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml", "dispatcherServlet.xml","spring-context-shiro.xml"});
        SpringContextHolder holder= context.getBean(SpringContextHolder.class);
        CommonService service= holder.getBean(CommonService.class);
        String rs=service.common();
        System.out.println(rs);
    }
}
