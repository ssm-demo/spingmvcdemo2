package web.example.advice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.swing.text.DateFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/miss")
public class ControllerWithAdviceDemo
{
    @RequestMapping("/miss")
    public ModelAndView miss(Date date, Model model)
    {
        ModelAndView modelAndView = new ModelAndView();
        Map<String, Object> map = new HashMap<>();
        map.putAll(model.asMap());
        map.put("date", date);
        modelAndView.addAllObjects(map);
        modelAndView.setView(new MappingJackson2JsonView());
        return modelAndView;
    }

    @RequestMapping("/exception")
    public void exception()
        throws Exception
    {
        throw new Exception();
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
