package net.bcsoft.bcvinaino.dao;

import net.bcsoft.bcvinaino.entity.ArticoliOrdini;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticoliOrdiniDAO {
    List <ArticoliOrdini> selectAll();
}
