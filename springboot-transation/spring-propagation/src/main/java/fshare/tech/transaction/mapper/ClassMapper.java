package fshare.tech.transaction.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ClassMapper {

    int updateClassName(@Param("name") String className, @Param("id") int id);
}
