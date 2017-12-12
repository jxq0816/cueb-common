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
import java.util.*;

public class CommonTest {

    @Test
    public void zeroRowTables() {
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
        String path = "doc/qihuo1.xlsx";
        List<Map> result = ReadExcel.read(path);
        FileWriter fileWriter = null;
        int rowNum=result.size();
        if(rowNum!=0){
            //遍历每一个张表
            for (int i = 0; i < rowNum; i++) {
                Map m=result.get(i);
                String code=(String) m.get("code");
                String name=(String) m.get("name");
                System.out.println(code+" start");
                List<HashMap> rs=service.wangzhao(code);
                if(rs.size()!=0){
                    String content="";
                    content+="code";
                    content+=" ";
                    content+="name";
                    content+=" ";
                    content+="date_time";
                    content+=" ";
                    content+="open";
                    content+=" ";
                    content+="high";
                    content+=" ";
                    content+="low";
                    content+=" ";
                    content+="close";
                    content+=" ";
                    content+="volume";
                    content+=" ";
                    content+="amount";
                    content+=" ";
                    content+="position";
                    content+="\r\n";
                    Double pre_close=0.0;
                    for(int j=0;j<rs.size();j++){
                        System.out.println(j);
                        HashMap map=rs.get(i);
                        content+=code;
                        content+=" ";
                        content+=name;
                        content+=" ";
                        content+=map.get("date_time");
                        content+=" ";
                        content+=map.get("open");
                        content+=" ";
                        content+=map.get("high");
                        content+=" ";
                        content+=map.get("low");
                        content+=" ";

                        Double close=(Double) map.get("close");
                        content+=close;
                        content+=" ";
                        content+=pre_close;//前收盘

                        pre_close=close;

                        content+=map.get("volume");
                        content+=" ";
                        content+=map.get("amount");
                        content+=" ";
                        content+=map.get("position");
                        content+="\r\n";
                    }
                    String file = "doc/"+code+".txt";
                    fileWriter = new FileWriter(file);
                    fileWriter.write(content);
                    fileWriter.flush();
                    fileWriter.close();
                    System.out.println(code+" end");
                }
            }
        }
    }
}
