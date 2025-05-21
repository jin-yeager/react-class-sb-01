package shop.ingong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import shop.ingong.myba.DaoEmp;
import shop.ingong.myba.EmpVO;

import java.util.List;

@Controller
public class EmpController {

    // 직접 생성해서 사용
    private final DaoEmp daoEmp = new DaoEmp();

    /** 사원 목록 **/
    @GetMapping("/emp_list.do")
    public String list(Model model) {
        List<EmpVO> empList = daoEmp.selectList();
        model.addAttribute("empList", empList);
        return "emp_list";      // → emp_list.mustache
    }

    /** 사원 상세 **/
    @GetMapping("/emp_detail.do")
    public String detail(@ModelAttribute EmpVO vo, Model model) {
        EmpVO result = daoEmp.select(vo);
        model.addAttribute("vo", result);
        return "emp_detail";
    }

    /** 사원 수정 폼 **/
    @GetMapping("/emp_mod.do")
    public String modForm(@ModelAttribute EmpVO vo, Model model) {
        EmpVO result = daoEmp.select(vo);
        model.addAttribute("vo", result);
        return "emp_mod";       // → emp_mod.mustache
    }

    /** 사원 수정 처리 **/
    @PostMapping("/emp_mod_act.do")
    public String modAct(@ModelAttribute EmpVO vo, Model model) {
        int cnt = daoEmp.update(vo);
        model.addAttribute("cnt", cnt);
        return "emp_mod_act";   // → emp_mod_act.mustache
    }

    /** 사원 삭제 처리 **/
    @GetMapping("/emp_del_act.do")
    public String delAct(@ModelAttribute EmpVO vo, Model model) {
        int cnt = daoEmp.delete(vo);
        model.addAttribute("cnt", cnt);
        return "emp_del_act";   // → emp_del_act.mustache
    }

    /** 사원 등록 폼 **/
    @GetMapping("/emp_add.do")
    public String addForm() {
        return "emp_add";       // → emp_add.mustache
    }

    /** 사원 등록 처리 **/
    @PostMapping("/emp_add_act.do")
    public String addAct(@ModelAttribute EmpVO vo, Model model) {
        int cnt = daoEmp.insert(vo);
        model.addAttribute("cnt", cnt);
        return "emp_add_act";   // → emp_add_act.mustache
    }
}
