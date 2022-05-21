package com.bbs.dao;

import com.bbs.entity.Main;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface MainDao {

    List<Main> getTopicList();

    List<Main> getByAuthor(Integer author);

    List<Main> queryByCondition(@Param("title") String title,@Param("nickname") String nickname,@Param("moduleName") String moduleName,@Param("addTime1") String addTime1,@Param("addTime2") String addTime2);

}
