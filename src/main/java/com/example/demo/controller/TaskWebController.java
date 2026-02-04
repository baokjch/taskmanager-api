//package com.example.demo.controller;
//import java.util.List;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import com.example.demo.entity.Task;
//import com.example.demo.service.TaskService;
//
//@Controller
//public class TaskWebController {
//
//    private final TaskService taskService;
//
//    public TaskWebController(TaskService taskService) {
//        this.taskService = taskService;
//    }
//
//    @GetMapping("/tasks")
//    public String showTasks(Model model) {
//        List<Task> tasks = taskService.getAllTasks();
//        model.addAttribute("tasks", tasks);
//        return "tasks";
//    }
//}

package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Task;
import com.example.demo.service.TaskService;

@Controller
public class TaskWebController {

    private final TaskService taskService;

    public TaskWebController(TaskService taskService) {
        this.taskService = taskService;
    }

    // Hiển thị danh sách + form
    @GetMapping("/tasks")
    public String showTasks(Model model) {
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        model.addAttribute("task", new Task()); // cho form
        return "tasks";
    }

    // Xử lý submit form
    @PostMapping("/tasks")
    public String addTask(@ModelAttribute Task task) {
        taskService.save(task);
        return "redirect:/tasks";
    }
}
