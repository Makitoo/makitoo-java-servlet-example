package com.makitoo.java.servlet.api;

import com.google.gson.GsonBuilder;
import com.makitoo.java.servlet.model.User;
import com.makitoo.java.servlet.service.UserService;
import com.makitoo.java.servlet.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by mclement on 5/19/2016.
 */
public class UsersAPI extends HttpServlet {

    private final UserService userService;

    private final GsonBuilder gsonBuilder;

    public UsersAPI(){
        this.userService = new UserServiceImpl();
        this.gsonBuilder = new GsonBuilder();
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        if ( path == null ){
            return;
        }
        sendJson(resp, userService.delete(path.substring(1)));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        if ( path == null ){
            sendJson(resp, userService.getAll());
        }else{
            sendJson(resp, userService.retrieve(path.substring(1)));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = gsonBuilder.create().fromJson(req.getReader(), User.class);
        sendJson(resp, userService.save(user));
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        if ( path == null ){
            return;
        }
        User user = gsonBuilder.create().fromJson(req.getReader(), User.class);
        user.setId(path.substring(1));
        sendJson(resp, userService.update(user));
    }

    private void sendJson(HttpServletResponse resp, Object data) throws IOException {
        resp.setContentType("application.json");
        resp.setCharacterEncoding( "UTF-8" );
        resp.getWriter().print(gsonBuilder.create().toJson(data));
    }
}
