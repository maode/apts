package com.shanghai.our.auth;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.shanghai.our.common.ConstantOur;

public class AuthInterceptor extends AbstractInterceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		  HttpSession session=  ServletActionContext.getRequest().getSession();
	       String actionName=actionInvocation.getInvocationContext().getName();
	       String  spaceName=actionInvocation.getProxy().getNamespace();
	       if(spaceName!=null&&spaceName.trim().length()>0){
	    	   if(spaceName.trim().equals("/"))
	    		   actionName="/"+actionName;
	    	   else{
	    		   actionName=spaceName+"/"+actionName;
	    	   }
	       };
	       Object object=session.getAttribute(ConstantOur.SESSION_USERINFO);
	       if(object==null&&!actionName.equals("/login")&&!actionName.equals("/loginDo"))
	    	   return Action.LOGIN;
	            return actionInvocation.invoke();  
	}

}
