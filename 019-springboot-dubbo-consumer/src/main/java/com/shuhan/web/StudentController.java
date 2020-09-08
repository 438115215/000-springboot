package com.shuhan.web;


import com.alibaba.dubbo.config.annotation.Reference;
import com.shuhan.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {
    @Reference(interfaceClass = StudentService.class,version = "1.0.0",check = false)
    private StudentService studentService;

    @RequestMapping("/student/count")
    public @ResponseBody Object studentCount(){
        Integer allStudentCount=studentService.queryAllStudentCount();
        return "count is "+allStudentCount;
    }
}
