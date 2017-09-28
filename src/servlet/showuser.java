package servlet;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.deletedao;
import bean.login;
import bean.register;
import bean.updatedao;
import bean.user;
import bean.userRegister;
import bean.userdao;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class showuser extends HttpServlet{
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException   
    {  
        doPost(request, response);  
    }  
  
      
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException   
    {  
    	String oprate = request.getParameter("oprate");
    	if("delete".equals(oprate)) {
    		Integer id = Integer.valueOf(request.getParameter("id"));
    		deletedao.delete(id);
    		response.sendRedirect("showuser");
    		
    	}else if("login".equals(oprate)) {
    		String username = request.getParameter("username");
     	      String password = request.getParameter("password");
     	     List<String> info=new ArrayList<String>();  
     	    if(username==null||"".equals(username)){ 
     	        info.add("用户名不能为空");  
     	        System.out.println("用户名不能为空");  
     	    }  
     	  
     	    if(password==null||"".equals(password)){
     	        info.add("密码不能为空");  
     	        System.out.println("密码不能为空");  
     	    }  
     	    if(info.size()==0){  


     	        try {  
     	              
     	            if(login.findLogin(username,password)){  
     	            	request.getRequestDispatcher("index.jsp").forward(request, response);              
     	            }else {  
     	                info.add("用户登录失败，错误的用户名和密码");  
     	            }                         
     	        } catch (Exception e) {  
     	            e.printStackTrace();  
     	        }  
     	    }  
     	   request.setAttribute("info", info);
     	    request.getRequestDispatcher("login.jsp").forward(request,response);  
    	}
    	
    	else if("register".equals(oprate)) {
   		 String username = request.getParameter("username");
  	      String password = request.getParameter("password");


  	   			register.userregister(username,password);

  	   			request.getRequestDispatcher("regsuccess.jsp").forward(request, response);

   	}
    	
    	
    	else if("update".equals(oprate)) {
    		
    		  request.setCharacterEncoding("utf-8");
    	      
    	      
    		  Integer id = Integer.valueOf(request.getParameter("id"));
    	      String name = request.getParameter("name");
    	      String age = request.getParameter("age");
    	      updatedao.update(id,name,age);
    	      request.getRequestDispatcher("updatesuccess.jsp").forward(request, response);
    			
    	} else if("toupdate".equals(oprate)) {
    	Integer id = Integer.valueOf(request.getParameter("id"));
    	user user  =null;
    	try {
			user = userdao.getuser(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	request.setAttribute("user", user);
    	request.getRequestDispatcher("userupdate.jsp").forward(request, response);
    	}
    
    	
    	else {
    	      Integer pagenumber = 1;
    	      String pn = request.getParameter("pagenumber");
    	      if(pn != null) {
    	    	  pagenumber = Integer.valueOf(pn);
    	      }
    	      if(pagenumber <1) {
    	    	  pagenumber=1;
    	      }
    	      int count = userdao.getCount();
    	      Integer pagesize =4;
    	      int pagecount ;
    	      if(count%pagesize==0) {
    	    	  pagecount = count/pagesize;
    	      }else {
    	    	  pagecount = count/pagesize+1;
    	      }
    	    	if(pagenumber>=pagecount)
    	    	{
    	    		pagenumber=pagecount;
    	    	}	
    	      
    	      List<user> Userlist = null;
				try {
					Userlist = userdao.getuserList(pagenumber,pagesize);
				} catch (SQLException e) {
					e.printStackTrace();
				}

    			
    	    	request.setAttribute("userlist", Userlist);
    	    	request.setAttribute("pagenumber", pagenumber);
    	    	request.setAttribute("pagecount", pagecount);
    	    	request.getRequestDispatcher("showuser.jsp").forward(request, response);
    	    
    }
    }


}


