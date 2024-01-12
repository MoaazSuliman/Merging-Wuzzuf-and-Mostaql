package com.moaaz.wuzzufmostaql.Controller.Client;

import com.moaaz.wuzzufmostaql.Service.Client.ClientProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/moaaz/wuzzufmostaql/api/admin/projects")
public class AdminProjectController {

    @Autowired
    private ClientProjectService clientProjectService;

    @PostMapping("/open/{clientProjectId}")
    public String closeClientProject(@PathVariable long clientProjectId) {
        clientProjectService.openClientProject(clientProjectId);
        return "Client Project Is Available Now";
    }

}
