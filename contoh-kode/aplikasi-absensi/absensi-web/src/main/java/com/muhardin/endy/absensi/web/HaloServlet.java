package com.muhardin.endy.absensi.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HaloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nama = req.getParameter("nama");
        String waktu = req.getParameter("waktu");
        String sapa = waktu == null ? "Halo" : "Selamat "+waktu;
        
        String output = "<html>";
        output += "<head><title>Halo Servlet</title></head>";
        output += "<body><h1>"+sapa+", "+nama+"</h1></body>";
        output += "</html>";
        
        resp.setContentType("text/html");
        resp.getWriter().print(output);
        resp.getWriter().flush();
    }
    
}
