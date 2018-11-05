package id.arip.controller;

import id.arip.domain.Person;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Arip Hidayat on 11/5/2018.
 */
@RestController
public class ResourceController {

    @GetMapping("user")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public Person getUser() {
        return new Person("user@arip.id", "User", "Somewhere");
    }

    @GetMapping("admin")
    @PreAuthorize("hasRole('ADMIN')")
    public Person getAdmin() {
        return new Person("admin@arip.id", "Admin", "Anywhere");
    }
}
