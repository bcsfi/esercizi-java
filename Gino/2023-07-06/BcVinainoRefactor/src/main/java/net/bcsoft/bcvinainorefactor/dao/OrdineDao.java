package net.bcsoft.bcvinainorefactor.dao;

import net.bcsoft.bcvinainorefactor.entity.Ordine;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrdineDao
{
    List<Ordine> selectAll();

    void insert(Ordine ordine);
}
