package ObjectMapperTest;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.LinkedList;

public class ObjectMapperTest {

    public static void main(String[] args) throws Exception{
        Student student = new Student();
        student.name = "小王";
        student.classList = new LinkedList<Classes>();
        Classes data = new Classes();
        data.name = "语文";
        data.score = 3;

        student.classList.add(data);

        ObjectMapper objectMapper = new ObjectMapper();
        String str = objectMapper.writeValueAsString(student);

        System.out.println(str);

        Student student1 = objectMapper.readValue(str, Student.class);

        System.out.println(str);

    }
}
