package net.bcsoft.bcvinaino.dao;

import net.bcsoft.bcvinaino.entity.Ordini;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrdiniDAO {
    List<Ordini> selectAll();
}
