package com.ss.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String filename = "music.xml";
		ServletContext sc = this.getServletContext();
		String link = sc.getRealPath("xml/music.xml");
		

		resp.setContentType("APPLICATION/OCTET-STREAM");
		resp.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
		File downloadFile = new File(link);
		// FileInputStream inStream = new FileInputStream(downloadFile);
		FileInputStream in = new FileInputStream(downloadFile);

		int i;
		while ((i = in.read()) != -1) {
			out.write(i);
		}
		in.close();
		out.close();

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	public void destroy() {

	}

}
