package http;

/**
 * @DESC 常见的网络攻击
 * @CREATE BY @Author pbj on @Date 2020/5/12 21:24
 */
public class Cyberattack {
    /**
     * XSS  (cross-site scripting) 跨站脚本攻击 ---利用用户对指定网站的信任
     *      * 持久性  xss代码发送到服务器
     *      * 反射性  用户输入的数据反射到浏览器，XSS代码出现在URL上
     *
     *   防御：1.CSP 白名单制度
     *          * 入参字符过滤
     *          * 出参进行编码
     *          * 入参长度限制
     *        2. HttpOnly 阻止Cookie 劫持攻击
     *          * Set-Cookie 字段设置HttpOnly参数，避免Cookie劫持攻击
     */

    /**
     * CSRF (corss site Request Forgery) 跨站请求伪造 ---利用网站对用户的信任
     *      * 借助用户的cookie骗取服务器的信任
     *
     *   防御：添加 token 验证：参数形式加入一个随机产生的token，并在服务器端建立一个拦截器来验证这个token。
     */

    /**
     * DDos (Distributed Denial of Service) 分布式拒绝服务 导致服务器拥塞而无法对外提供正常服务
     *
     *  防御：
     *      资源隔离：资源隔离可以看作是用户服务的一堵防护盾。
     *      用户规则：根据流量类型、请求频率、数据包特征、正常业务之间的延时间隔等，判断用户是否为攻击行为
     *      大数据智能分析：基于对海量数据进行分析，进而对合法用户进行模型化，并利用这些指纹特征。
     */

    /**
     * SQL注入攻击：将任意 SQL 代码插入数据库查询，使攻击者能够完全控制 Web 应用程序后面的数据库服务器
     *
     *   防御：
     *      不盲目使用动态SQL
     *      加密
     *      限制访问权限
     *      避免直接向用户显示数据库的错误
     *      WEB防火墙
     *
     */
}
