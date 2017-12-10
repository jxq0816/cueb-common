import com.week7i.share.service.CommonService;
import com.week7i.share.service.SystemService;
import com.week7i.share.util.CSVUtils;
import com.week7i.share.util.ReadExcel;
import com.week7i.share.util.SpringContextHolder;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class CommonTest {

    @Test
    public void common() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml", "dispatcherServlet.xml", "spring-context-shiro.xml"});
        SpringContextHolder holder = context.getBean(SpringContextHolder.class);
        CommonService service = holder.getBean(CommonService.class);
        service.zeroRowTables();
        System.out.println();
    }

    @Test
    public void root() throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml", "dispatcherServlet.xml", "spring-context-shiro.xml"});
        SpringContextHolder holder = context.getBean(SpringContextHolder.class);
        CommonService service = holder.getBean(CommonService.class);
        String path = "doc/1.xlsx";
        List<String> result = ReadExcel.read(path);
        FileWriter fwriter = null;
        //遍历每一个张表
        for (int i = 0; i < result.size(); i++) {
            String code=result.get(i);
            List<HashMap> rs=service.queryAll(code);
            String content="";
            for(int j=0;j<rs.size();j++){
                HashMap map=rs.get(i);
                content+=map.get("p_date");
                content+=" ";
                content+=map.get("net");
                content+="\r\n";
            }
            String file = "doc/"+code+".txt";
            fwriter = new FileWriter(file);
            fwriter.write(content);
            fwriter.flush();
            fwriter.close();
            break;
        }
    }
}
