package com.pu.thread.concurrent_vector;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @DESC
 *      迭代器在遍历时直接访问集合中的内容，并且在遍历过程中使用一个 modCount 变量，集合在遍历时如果内容发生变化，modCount会改变
 *      每次迭代器使用 hasNext()/next() 遍历下一个元素之前，就会检测 modCount 遍历是否为期待值，是的话遍历，否则抛出异常Concurrent Modification Exception
 * @使用场景： java.util 都是fast-fail。安全机制
 * @CREATE BY @Author pbj on @Date 2020/7/13 16:30
 */
public class FailFast {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            list.add(i);
        }
        /**
         * 安全删除
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next() + " ");
            iterator.remove();
        }*/
        /**
         *
         *  foreach 出现 fastfail
         * F:\Java\jdk1.8.0_121\bin\java.exe "-javaagent:F:\Program Files\JetBrains\IntelliJ IDEA 2019.1.1\lib\idea_rt.jar=13013:F:\Program Files\JetBrains\IntelliJ IDEA 2019.1.1\bin" -Dfile.encoding=UTF-8 -classpath F:\Java\jdk1.8.0_121\jre\lib\charsets.jar;F:\Java\jdk1.8.0_121\jre\lib\deploy.jar;F:\Java\jdk1.8.0_121\jre\lib\ext\access-bridge-64.jar;F:\Java\jdk1.8.0_121\jre\lib\ext\cldrdata.jar;F:\Java\jdk1.8.0_121\jre\lib\ext\dnsns.jar;F:\Java\jdk1.8.0_121\jre\lib\ext\jaccess.jar;F:\Java\jdk1.8.0_121\jre\lib\ext\jfxrt.jar;F:\Java\jdk1.8.0_121\jre\lib\ext\localedata.jar;F:\Java\jdk1.8.0_121\jre\lib\ext\nashorn.jar;F:\Java\jdk1.8.0_121\jre\lib\ext\sunec.jar;F:\Java\jdk1.8.0_121\jre\lib\ext\sunjce_provider.jar;F:\Java\jdk1.8.0_121\jre\lib\ext\sunmscapi.jar;F:\Java\jdk1.8.0_121\jre\lib\ext\sunpkcs11.jar;F:\Java\jdk1.8.0_121\jre\lib\ext\zipfs.jar;F:\Java\jdk1.8.0_121\jre\lib\javaws.jar;F:\Java\jdk1.8.0_121\jre\lib\jce.jar;F:\Java\jdk1.8.0_121\jre\lib\jfr.jar;F:\Java\jdk1.8.0_121\jre\lib\jfxswt.jar;F:\Java\jdk1.8.0_121\jre\lib\jsse.jar;F:\Java\jdk1.8.0_121\jre\lib\management-agent.jar;F:\Java\jdk1.8.0_121\jre\lib\plugin.jar;F:\Java\jdk1.8.0_121\jre\lib\resources.jar;F:\Java\jdk1.8.0_121\jre\lib\rt.jar;F:\JavaCodes\Java_8_codes\out\production\Java_8_codes com.pu.thread.concurrent_vector.FailFast
         * 0 Exception in thread "main" java.util.ConcurrentModificationException
         * 	at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:901)
         * 	at java.util.ArrayList$Itr.next(ArrayList.java:851)
         * 	at com.pu.thread.concurrent_vector.FailFast.main(FailFast.java:27)
         */

        /**
         * 可以实现遍历
         */
        for(int i= 0; i < list.size(); i++){
            System.out.print( list.get(i) + " ");
            list.remove(i);
            i--;
        }
        System.out.println();
        System.out.println("---------------------");
    }
}
