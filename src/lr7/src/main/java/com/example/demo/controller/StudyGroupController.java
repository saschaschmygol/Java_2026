package com.example.demo.controller;

import com.example.demo.entity.StudyGroup;
import com.example.demo.service.StudyGroupService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudyGroupController {

    private final StudyGroupService studyGroupService;

    public StudyGroupController(StudyGroupService studyGroupService) {
        this.studyGroupService = studyGroupService;
    }

    @GetMapping("/groups")
    public String listStudyGroups(Model model) {
        model.addAttribute("studyGroups", studyGroupService.getAllStudyGroups());
        return "list-study-groups";
    }

    @GetMapping("/addStudyGroupForm")
    public String addStudyGroupForm(Model model) {
        model.addAttribute("studyGroup", new StudyGroup());
        return "add-study-group-form";
    }

    @PostMapping("/saveStudyGroup")
    public String saveStudyGroup(StudyGroup studyGroup) {
        studyGroupService.saveStudyGroup(studyGroup);
        return "redirect:/groups";
    }

    @GetMapping("/showStudyGroupUpdateForm")
    public String showStudyGroupUpdateForm(@RequestParam("studyGroupId") Integer studyGroupId, Model model) {
        model.addAttribute("studyGroup", studyGroupService.getStudyGroupById(studyGroupId));
        return "add-study-group-form";
    }

    @GetMapping("/deleteStudyGroup")
    public String deleteStudyGroup(@RequestParam("studyGroupId") Integer studyGroupId) {
        studyGroupService.deleteStudyGroupById(studyGroupId);
        return "redirect:/groups";
    }
}
