package com.olympicFamily.olympicFamily.BackEnd.Controller;

import com.olympicFamily.olympicFamily.BackEnd.Admin.FileUploadUtil;
import com.olympicFamily.olympicFamily.BackEnd.Security.OFUserDetails;
import com.olympicFamily.olympicFamily.BackEnd.User.UserService;
import com.olympicFamily.olympicFamily.Common.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
public class AccountController {
    @Autowired
    private UserService service;

    @GetMapping("/account")
    public String viewDetails(@AuthenticationPrincipal OFUserDetails loggedUser,
                              Model model){
        String email = loggedUser.getUsername();
        User user = service.getByEmail(email);
        model.addAttribute("user", user);

        return "BackEnd/account_form";
    }

    @PostMapping("/account/update")
    public String saveDetails(User user, RedirectAttributes redirectAttributes,
                              @AuthenticationPrincipal OFUserDetails loggedUser,
                           @RequestParam("image") MultipartFile multipartFile) throws IOException {

        if(!multipartFile.isEmpty()) {
            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            user.setPhotos(fileName);
            User savedUser = service.updateAccount(user);
            String uploadDir = "user-photos/" + savedUser.getId();

            FileUploadUtil.cleanDirectory(uploadDir);
            FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        } else {
            if(user.getPhotos().isEmpty()){
                user.setPhotos(null);
            }
            service.updateAccount(user);
        }

        loggedUser.setFirstName(user.getFirstName());
        loggedUser.setLastName(user.getLastName());

        redirectAttributes.addFlashAttribute("message", "Your account have been updated");

        return "redirect:/account";
    }
}
