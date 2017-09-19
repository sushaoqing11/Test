package servlet;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import bean.deletedao;
import bean.updatedao;
import bean.user;
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
    		
    	}else if("update".equals(oprate)) {
    		
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


