package web.example.advice;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.text.SimpleDateFormat;
import java.util.Date;

// 标识控制器通知，指定对应的包路径
@ControllerAdvice(basePackages={"web.example.advice"})
public class ControllerAdviceDemo
{

    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        // 针对日期类型的格式化
        binder.registerCustomEditor(Date.class,new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),false));
    }

    // 处理模型数据----进入controller之前
    @ModelAttribute
    public void populateModel(Model model)
    {
        model.addAttribute("topic","miss you");
    }

    // 异常处理，当被拦截的控制器方法发生异常时，可用相同的视图响应
    @ExceptionHandler(Exception.class)
    public String exception()
    {
        return "exception";
    }


}
