package Projection;

import org.springframework.beans.factory.annotation.Value;

public interface TeacherProjection {

    String getName();
    Integer getAge();
    @Value("#{target.name +' and age is' + target.age}")
    String getTotal();
}
