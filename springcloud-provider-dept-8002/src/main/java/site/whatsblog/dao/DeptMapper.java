package site.whatsblog.dao;

import org.apache.ibatis.annotations.Mapper;
import site.whatsblog.pojo.Dept;

import java.util.List;
@Mapper
public interface DeptMapper {
    int deleteByPrimaryKey(Long deptno);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Long deptno);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);

    List<Dept> queryAll();
}