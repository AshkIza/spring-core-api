package io.ashkan.izadpanah.springboot.courseapi.course;

import java.util.List;

/* Derived queries: https://www.baeldung.com/spring-data-derived-queries
 * 
 * */
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long>{
	List<Course> findByTopicId(Long id);//derived query
}
