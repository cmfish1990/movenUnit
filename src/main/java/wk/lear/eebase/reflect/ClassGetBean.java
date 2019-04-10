/*
 * cf
 * FileName: ClassGetBean.java
 * Author:   BM
 * Date:     2019-05-11 15:36:37
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-05-11 15:36:37> <version> <desc> <source>
 *
 */

package wk.lear.eebase.reflect;

public class ClassGetBean {

    private String beanName;

    private Integer beanAge;


    public void getNameAndAge(String tag){
        System.out.println(tag+":"+beanName);

    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public Integer getBeanAge() {
        return beanAge;
    }

    public void setBeanAge(Integer beanAge) {
        this.beanAge = beanAge;
    }
}
