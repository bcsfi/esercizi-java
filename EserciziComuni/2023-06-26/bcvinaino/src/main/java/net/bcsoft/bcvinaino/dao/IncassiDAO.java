package net.bcsoft.bcvinaino.dao;

import net.bcsoft.bcvinaino.entity.IncassoGiornaliero;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IncassiDAO {
    List <IncassoGiornaliero> calcolaIncassi();
}
