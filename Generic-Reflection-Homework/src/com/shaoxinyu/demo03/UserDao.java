package com.shaoxinyu.demo03;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UserDao<T> {

    private Map<String,T> userMap = new HashMap<String,T>();

    /**
     * 向map中存数据
     * @param id key
     * @param entity value
     */
    public void save(String id, T entity){
        userMap.put(id,entity);
    }

    /**
     * 根据key获取map中的value
     * @param id key
     * @return 返回一个value
     */
    public T getUser(String id){
        return userMap.get(id);
    }

    /**
     * 更新map中的数据
     * @param id key
     * @param entity value
     */
    public void update(String id, T entity){
        T put = userMap.put(id, entity);
        if (userMap.get(id) == entity){
            System.out.println("更新成功");
        }else {
            System.out.println("更新失败");
        }
    }

    /**
     * 遍历map集合
     */
    public void getUserList(){
        Set<String> strings = userMap.keySet();
        for (String keys : strings) {
            System.out.println(userMap.get(keys));
        }
    }

    /**
     * 根据key删除map中的value
     * @param id
     */
    public void delete(String id){
        T remove = userMap.remove(id);
        if (remove != null) {
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
    }

}
