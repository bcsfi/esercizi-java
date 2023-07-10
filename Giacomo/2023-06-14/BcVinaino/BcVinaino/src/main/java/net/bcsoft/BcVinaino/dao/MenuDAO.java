package net.bcsoft.BcVinaino.dao;

import net.bcsoft.BcVinaino.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuDAO {
    List<Menu> selectAll();
    void updateFocaccia(Menu menu);
}