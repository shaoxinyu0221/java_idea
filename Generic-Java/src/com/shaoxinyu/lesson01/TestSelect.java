

import java.lang.reflect.Constructor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 究极残废版JDBC框架,使用泛型和反射编写
 */
public class TestSelect {
    public static <T> T select(String sql, Class<T> clazz) throws Exception {
        //获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/book?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
        String name = "root";
        String password = "root";
        Connection conn = DriverManager.getConnection(url, name, password);
        //sql预编译
        PreparedStatement pst = conn.prepareStatement(sql);
        //执行sql返回结果集
        ResultSet rs = pst.executeQuery();
        //只读一行
        rs.next();
        //创建结果变量
        T t = null;
        //获取结果列数
        int columnCount = rs.getMetaData().getColumnCount();
        //查询结果为一列,包装类或String
        if(columnCount == 1){
            t = (T)rs.getObject(1);
            return t;
        }
        //查询结果为对象
        //结果列数也是有参构造参数个数,创建一个数组装参数
        Object[] objArray = new Object[columnCount];
        //把结果集每列数据装到数组中
        for(int i = 1;i<=columnCount;i++) {
            objArray[i-1] = rs.getObject(i);
        }
//        T t = new T();不行
//        Class<T> clazz = T.class;也不行
//        没得对象,所以getClass()也不行
//        没得全类名,所以Class.forName()也不行
//        所以传了个Class<T> clazz进来
        //获取T的有参构造器
        Constructor<?> csr = clazz.getConstructors()[1];
        //调用有参构造,数组当作参数传入
        t = (T)csr.newInstance(objArray);
        //返回结果
        return t;
    }

    public static void main(String[] args) throws Exception {
        //用户类
        class User{
            private Integer id;
            private String name;
            private String password;
            public User() {}
            public User(Integer id, String name, String password) {
                this.id = id;
                this.name = name;
                this.password = password;
            }
            @Override
            public String toString() {
                return "User [编号=" + id + ", 姓名=" + name + ", 密码=" + password + "]";
            }
        }
        //图书类
        class Book{
            private Integer id;
            private String name;
            private String desp;
            private Double price;
            public Book() {}
            public Book(Integer id, String name, String desp, Double price) {
                this.id = id;
                this.name = name;
                this.desp = desp;
                this.price = price;
            }
            @Override
            public String toString() {
                return "编号:"+ id + ",书名:" + name + ",描述:" + desp + ",价格:" + price;
            }
        }
        //测试这个究极残废版JDBC框架(只支持查询语句,且结果为单列或对象)
        User user = select("select * from user",User.class);
        String name = select("select name from user",String.class);
        Integer id = select("select account from user",Integer.class);
        System.out.println(user+"\n"+id+"\n"+name);

        Book book = select("select * from books", Book.class);
        Double price = select("select price from books", Double.class);
        System.out.println(book+"\n"+price);
    }
}
