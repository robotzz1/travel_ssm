package com.robot.controller;

import com.robot.pojo.FavoriteId;
import com.robot.pojo.PageBean;
import com.robot.pojo.Route;
import com.robot.pojo.User;
import com.robot.service.FavoriteService;
import com.robot.service.RouteService;
import com.robot.util.jsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Controller
@RequestMapping("/route")
public class RountController {

    @Autowired
    private RouteService routeService;
    @Autowired
    private FavoriteService favoriteService;
    /**
     * 分页查询
     * @param request
     * @param response
     */
    @RequestMapping("pageQuery")
    public void pageQuery(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1.接收参数
        String currentPageStr=request.getParameter("currentPage");
        String pageSizeStr=request.getParameter("pageSize");
        String cidStr=request.getParameter("cid");

        //接受线路 名称
        String rname = request.getParameter("rname");
        if(rname!=null&&rname.length()>0) {
            rname = new String(rname.getBytes("iso-8859-1"), "utf-8");
        }
        //2。处理参数
        int cid=0;//类别id
        if(cidStr!=null&&cidStr.length()>0&&!"null".equals(cidStr)){
            cid=Integer.parseInt(cidStr);
        }
        int currentPge=0;//当前页码，如果不传递，当前页码默认第一页
        if(currentPageStr!=null&&currentPageStr.length()>0){
            currentPge=Integer.parseInt(currentPageStr);
        }else {
            currentPge=1;
        }
        int pageSize=0;//每页显示条数，如果不传递，默认每页显示5条记录
        if(pageSizeStr!=null&&pageSizeStr.length()>0){
            pageSize=Integer.parseInt(pageSizeStr);
        }else {
            pageSize=5;
        }

        //3.调用service查询PageBean对象
        PageBean<Route> pb=routeService.pageQuery(cid,currentPge,pageSize,rname);
        //4.将pageBean序列化为json，返回页面

        jsonUtil.writeValue(pb,response);
    }

    @RequestMapping("findOne")
    public void findOne(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1.接收参数id
        String rid =request.getParameter("rid");
        //2.调用service查询route对象
        Route route=routeService.findOne(rid);
        //3.转为json写回客户端
        jsonUtil.writeValue(route,response);
    }

    /**
     * 判断当前登录用户是否收藏过该线路
     * @param request
     * @param response
     */
    @RequestMapping("isFavourite")
    public void isFavourite(HttpServletRequest request, HttpServletResponse response) throws IOException {
        FavoriteId favoriteId=new FavoriteId();
        //1.获取线路rid
        String rid=request.getParameter("rid");

        //2.获取当前登录用户user
        User user = (User) request.getSession().getAttribute("user");
        int uid;//用户id
        if(user==null){
            //尚未登陆
            return ;
        }else {
            //用户已经登陆
            uid=user.getUid();
        }
        favoriteId.setRid(Integer.parseInt(rid));
        favoriteId.setUid(uid);

        //3.调用FavouriteService查询是否被收藏
        boolean flag = favoriteService.isFavorite(favoriteId);

        //4.写回客户端
        jsonUtil.writeValue(flag,response);
    }

    /**
     * 添加收藏
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("addFavourite")
    public void addFavourite(HttpServletRequest request, HttpServletResponse response) throws IOException {
        FavoriteId favoriteId=new FavoriteId();
        //1.获取线路rid
        String rid=request.getParameter("rid");
        System.out.println("ridr:::::"+rid);
        //2.获取当前登录用户user
        User user = (User) request.getSession().getAttribute("user");
        int uid;//用户id
        if(user==null){
            //尚未登陆
            return ;
        }else {
            //用户已经登陆
            uid=user.getUid();
        }
        System.out.println("uid:::::::::::::::::::::"+uid);
        favoriteId.setRid(Integer.parseInt(rid));
        favoriteId.setDate(new Date());
        favoriteId.setUid(uid);
        //3.调用service添加
        favoriteService.add(favoriteId);
    }
}
