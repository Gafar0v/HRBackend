package com.gafarov.bastion.controller;

import com.gafarov.bastion.entity.user.Activity;
import com.gafarov.bastion.entity.user.User;
import com.gafarov.bastion.exception.ForbiddenException;
import com.gafarov.bastion.model.ResumeDto;
import com.gafarov.bastion.service.impl.ResumeServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController("/resume")
@AllArgsConstructor
public class ResumeController {
    private final ResumeServiceImpl service;

    @GetMapping
    public ResumeDto getPersonalResume(@AuthenticationPrincipal User user) {
        return service.getPersonalResume(user.getId());
    }

    @PostMapping
    public ResumeDto sendResume(
            @AuthenticationPrincipal User user,
            @RequestBody ResumeDto resumeDto
    ) {
        if (user.getActivity() != Activity.REGISTERED) {
            throw new ForbiddenException();
        }
        return service.sendResume(resumeDto, user);
    }

    @PutMapping
    public ResumeDto updateResume(
            @AuthenticationPrincipal User user,
            @RequestBody ResumeDto resumeDto
    ) {
        if (user.getActivity() != Activity.REGISTERED) {
            throw new ForbiddenException();
        }
        return service.updateResume(resumeDto, user);
    }

}