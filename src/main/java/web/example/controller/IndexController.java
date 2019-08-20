package web.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import web.example.pojo.Role;

@Controller
@RequestMapping("/home")
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/toSaySth")
    public String toSaySth(){
        return "saySth";
    }


    @RequestMapping("/getRole/{id}")
    public ModelAndView getRole(@PathVariable("id")Long id)
    {
        Role role = new Role();
        role.setName("xxx");
        role.setSex("male");
        ModelAndView mv = new ModelAndView();
        mv.addObject(role);
        mv.setView(new MappingJackson2JsonView());
        return mv;
    }

    @RequestMapping("/getSth")
    public ModelAndView getSth(String role, String sth)
    {
        Role r = new Role();
        r.setName(role);
        r.setSth(sth);
        ModelAndView mv = new ModelAndView();
        mv.addObject(r);
        mv.setView(new MappingJackson2JsonView());
        return mv;
    }

    @RequestMapping("/tryDataModel")
    public ModelAndView tryDataModel(ModelMap modelMap)
    {
        modelMap.addAttribute("test");
        ModelAndView mv = new ModelAndView();
        mv.setView(new MappingJackson2JsonView());
        return mv;
    }

    @RequestMapping("/getRoleByModelAttr")
    @ResponseBody
    public Role getRoleByModelAttr(@ModelAttribute("role") Role role)
    {
        return role;
    }


    // 在getRoleByModelAttr之前运行 获取role
    @ModelAttribute("role")
    public Role initRole(@RequestParam(value ="id",required = false) String id)
    {
        if(null == id || "".equals(id))
        {
            return null;
        }

        Role role = new Role();
        role.setSth("sth");
        role.setId(id);
        role.setSex("sex");
        role.setName("name");
        return role;

    }


}
