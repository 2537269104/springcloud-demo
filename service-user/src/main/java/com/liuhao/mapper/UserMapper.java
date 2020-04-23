package com.liuhao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuhao.entity.User;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liuhao
 * @since 2020-04-22
 */
public interface UserMapper {

    User getUserById(Integer id);
}
