package com.university.kursovaya.webControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.university.kursovaya.models.Member;
import com.university.kursovaya.services.MemberService;

@Controller
public class MemberThymeleafController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/members")
    public String getMembers(Model model) {
        model.addAttribute("members", memberService.findAll());
        return "member";
    }

    @PostMapping("/members/add")
    public String addMember(@RequestParam String name, @RequestParam String email) {
        Member member = new Member();
        member.setName(name);
        member.setEmail(email);
        memberService.save(member);
        return "redirect:/members";
    }

    @PostMapping("/members/delete/{id}")
    public String deleteMember(@PathVariable Long id) {
        memberService.deleteById(id);
        return "redirect:/members";
    }
}
