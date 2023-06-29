package net.bcsoft.bcvinaino.dao;

import net.bcsoft.bcvinaino.entity.Ordine;
import org.apache.ibatis.annotations.Mapper;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Mapper
public interface OrdineDAO {
    List<Ordine> selectAll();

    Long insert(Ordine ordine);

    void deleteOrdinePerId(Integer id);
    void deleteOrdinePerData(LocalDate Data);

    List<Integer> getOrdiniPerData(LocalDate data);
}
