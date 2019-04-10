/*
 * cf
 * FileName: ClassGetRun.java
 * Author:   BM
 * Date:     2019-05-11 15:36:14
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-05-11 15:36:14> <version> <desc> <source>
 *
 */

package wk.lear.eebase.reflect;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 获取类的三种方法
 * 创建对象
 * 获取属性
 * setAccessible
 * invoke
 * 配置文件
 * 绕过泛型
 */
public class ClassGetRun {

    public static void main(String[] args) throws Exception {


        Class bClass = ClassGetBean.class;
        Class cClass = Class.forName("wk.lear.eebase.reflect.ClassGetBean");
        Class dClass = new ClassGetBean().getClass();

        ClassGetBean classGetBean = (ClassGetBean) bClass.newInstance();

        Field[] fields = bClass.getDeclaredFields();
        Field[] fields1 = bClass.getFields();
        for (Field field : fields) {
            System.out.println(field.getName());
            System.out.println(field.getType());
        }
        Field field = bClass.getDeclaredField("beanName");
        bClass.newInstance();
        field.setAccessible(true);
        field.set(classGetBean, "小明测试");
        System.out.println(classGetBean.getBeanName());

        Method[] methods = bClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        Method method = bClass.getMethod("getNameAndAge", String.class);
        method.invoke(classGetBean, "注意");


        aroucntFaxing();
    }

    //绕过泛型
    public static void aroucntFaxing() throws Exception {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        Class listClass = list.getClass();
        Method method = listClass.getMethod("add", Object.class);
        method.invoke(list, "helloworld");
        System.out.println(list.get(2));
    }


}
