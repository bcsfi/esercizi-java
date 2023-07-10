package net.bcsoft.BcVinaino.dao;

import net.bcsoft.BcVinaino.entity.IncassoGiornaliero;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ReportDAO {
    List <IncassoGiornaliero> calcolaIncassi();
}

