package com.appsupp.testjava.controller;

import com.appsupp.testjava.document.PdfServer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SuccessController {
    private final PdfServer pdfServer;

    public SuccessController(PdfServer pdfServer) {
        this.pdfServer = pdfServer;
    }


    @GetMapping("/success.html")
    public String getIndex(Model model) {
        pdfServer.startServer();
        return "success";
    }
}
