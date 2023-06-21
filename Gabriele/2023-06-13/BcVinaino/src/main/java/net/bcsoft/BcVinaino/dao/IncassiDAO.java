package net.bcsoft.bcvinaino.dao;

import net.bcsoft.bcvinaino.entity.Incassi;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IncassiDAO {
    List <Incassi> incassiReport();
}
