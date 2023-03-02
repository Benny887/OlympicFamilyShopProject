package all.BackEnd.Admin.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BECustomerRestController {
    @Autowired
    private BECustomerService service;

    @PostMapping("/customers/check_email")
    public String checkDuplicateEmail(Integer id, String email) {
        if (service.isEmailUnique(id, email)) {
            return "OK";
        } else {
            return "Duplicated";
        }
    }
}
