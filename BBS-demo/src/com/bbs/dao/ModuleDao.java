package com.bbs.dao;

import com.bbs.entity.Module;

public interface ModuleDao {

    Module queryModuleById(Integer id);

    Module queryModuleMainById(Integer id);

}
