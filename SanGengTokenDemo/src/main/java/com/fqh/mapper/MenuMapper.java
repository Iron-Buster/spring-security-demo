package com.fqh.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fqh.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    List<String> selectPermsByUserId(@Param("userId") Long userId);
}
