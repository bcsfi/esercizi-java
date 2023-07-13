package net.bcsoft.bcvinainorefactor.dao;

import net.bcsoft.bcvinainorefactor.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuDAO {
    List<Menu> selectAll();

    void update(Menu menu);
}
