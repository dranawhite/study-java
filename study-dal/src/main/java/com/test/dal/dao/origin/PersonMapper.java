package com.test.dal.dao.origin;

import com.test.dal.model.origin.PersonDO;
import com.test.dal.model.origin.PersonDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PersonMapper {
    long countByExample(PersonDOExample example);

    int deleteByExample(PersonDOExample example);

    int insert(PersonDO record);

    int insertSelective(PersonDO record);

    List<PersonDO> selectByExample(PersonDOExample example);

    int updateByExampleSelective(@Param("record") PersonDO record, @Param("example") PersonDOExample example);

    int updateByExample(@Param("record") PersonDO record, @Param("example") PersonDOExample example);
}