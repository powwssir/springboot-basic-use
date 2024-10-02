package fshare.tech.transaction.mapper;

import fshare.tech.transaction.entity.StudentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface StudentMapper {

	StudentEntity getStudentById(int id);

	int addStudent(StudentEntity student);

	int updateStudentName(@Param("name") String name, @Param("id") int id);

	StudentEntity getStudentByIdWithClassInfo(int id);
}
