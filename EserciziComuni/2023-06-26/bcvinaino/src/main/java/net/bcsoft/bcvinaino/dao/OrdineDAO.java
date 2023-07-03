package net.bcsoft.bcvinaino.dao;

import net.bcsoft.bcvinaino.entity.Ordine;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface OrdineDAO {
    List<Ordine> selectAll();

    Long insert(Ordine ordine);

    Long deleteByID(Long id);

    LocalDate deleteByData(LocalDate data);
}
