package net.bcsoft.bcvinainorefactor.dao;

import net.bcsoft.bcvinainorefactor.entity.ArticoliOrdine;
import net.bcsoft.bcvinainorefactor.dto.ArticoliOrdineDto;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ArticoliOrdineDao
{
    List<ArticoliOrdine> selectAll ();
    void insert (ArticoliOrdineDto articoliOrdineDto);
}
