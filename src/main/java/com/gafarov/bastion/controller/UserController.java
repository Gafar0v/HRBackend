package com.gafarov.bastion.controller;

import com.gafarov.bastion.entity.user.Activity;
import com.gafarov.bastion.entity.user.Role;
import com.gafarov.bastion.entity.user.User;
import com.gafarov.bastion.exception.ForbiddenException;
import com.gafarov.bastion.service.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@AllArgsConstructor

public class UserController extends BaseController {
    private final UserServiceImpl userService;

    @PutMapping("/{id}")
    public void changeUserStatus(
            @PathVariable Integer id,
            @AuthenticationPrincipal User user
    ) {
        if (user.getRole() != Role.ADMIN) throw new ForbiddenException("only for admin");
        userService.changeUserStatus(id, Activity.INTERVIEW);
    }
    @PutMapping("/{id}/{role}")
    public void changeUserRole(
            @PathVariable Integer id,
            @AuthenticationPrincipal User user,
            @PathVariable Role role
    ) {
        if (user.getRole() != Role.ADMIN) throw new ForbiddenException("only for admin");
        userService.changeUserRole(id, role);
    }
}
