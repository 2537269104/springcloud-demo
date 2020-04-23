package com.liuhao.mapper;

import com.liuhao.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liuhao
 * @since 2020-04-22
 */
public interface OrderMapper extends BaseMapper<Order> {

    Order selectOrderById(Integer id);
}
