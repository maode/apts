package com.shanghai.our.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.shanghai.our.common.ConstantOur;
import com.shanghai.our.model.Admin;
import com.shanghai.our.model.HouseInfo;
import com.shanghai.our.model.Pager;
import com.shanghai.our.model.Picture;
import com.shanghai.our.service.IHouseInfoService;
import com.shanghai.our.service.IPictureService;
import com.shanghai.our.utils.ExecuteResult;
import com.shanghai.our.utils.TipImageUtils;

@ParentPackage("basePackage")
@Namespace("/")
public class HouseInfoAction extends BaseFileAction<HouseInfo>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * 房屋对象
	 */
	private  HouseInfo houseInfo;
	private Picture picture;
	
	
	@Autowired
	private IHouseInfoService houseInfoService;
	@Autowired
	private IPictureService pictureService;
	
	

	/**
	 * 房源待审批列表
	 * @return
	 */
	@Action(value="houseAppList", results = { @Result(name = "houseAppList", location = "/houseInfo/houseAppList.jsp") })
	public String houseAppList(){
		Map<String,Object> map=new HashMap<String,Object>();
		if(houseInfo==null)
			houseInfo=new HouseInfo();
		houseInfo.setStatus(1);
		houseInfo.setDelFlag(1);
		map.put("houseInfo.title", houseInfo.getTitle());
		if(houseInfo.getProvince()!=null)
		map.put("houseInfo.provice.id", houseInfo.getProvince().getId());
		if(houseInfo.getCity()!=null)
		map.put("houseInfo.city.id", houseInfo.getCity().getId());
		initPage(map);
		this.pager=this.houseInfoService.findAll(this.pager, houseInfo);
		List<HouseInfo> list=this.pager.getRecords();
		this.pager.setRecords(list);
		return "houseAppList";
	}
	
	/**
	 * 跳转到房源审批界面
	 * @return
	 */
	@Action(value="houseApp", results = { @Result(name = "houseApp", location = "/houseInfo/houseApp.jsp") })
	public String houseApp(){
		return "houseApp";
	}
	
	/**
	 * 执行房源审批操作
	 */
	@Action(value="houseAppDo")
	public void  houseAppDo(){
		
	}
	
	/**
	 * 房屋管理界面
	 * @return
	 */
	@Action(value="houseList", results = { @Result(name = "houseList", location = "/houseInfo/houseList.jsp") })
	public String  houseList(){
		Map<String,Object> map=new HashMap<String,Object>();
		if(houseInfo==null)
			houseInfo=new HouseInfo();
		map.put("houseInfo.title", houseInfo.getTitle());
		if(houseInfo.getProvince()!=null)
		map.put("houseInfo.provice.id", houseInfo.getProvince().getId());
		if(houseInfo.getCity()!=null)
		map.put("houseInfo.city.id", houseInfo.getCity().getId());
		initPage(map);
		this.pager=this.houseInfoService.findAll(pager, houseInfo);
		List<HouseInfo> list=this.pager.getRecords();
		this.pager.setRecords(list);
		return "houseList";
	}
	
	
	/**
	 * 跳转到添加房源信息
	 * @return
	 */
	@Action(value="addHouse", results = { @Result(name = "addHouse", location = "/houseInfo/addHouse.jsp") })
	public String   addHouse(){
		return "addHouse";
	}
	
	/**
	 * 执行房源添加操作
	 */
	@Action(value="addHouseDo")
	public void  addHouseDo(){
		try{
			 Admin admin=(Admin)ServletActionContext.getRequest().getSession().getAttribute(ConstantOur.SESSION_USERINFO);
			 this.houseInfo.setAdmin(admin);
			 ExecuteResult<String> result=this.houseInfoService.publishHouse(this.houseInfo);
			if(result.isSuccess()){
				this.setUploadtypedir("_houseInfo_");
				this.uploadImgs(admin.getId(), this.houseInfo);
				super.successResponse("");
			}else{
				super.faileResponse(result.getResult());
			}
		}catch(Exception e){
			e.printStackTrace();
			super.faileResponse(ConstantOur.APP_ERROR_MSG);
		}
	}
	/**
	 * 执行房源编辑操作
	 */
	@Action(value="editHouseDo")
	public void  editHouseDo(){
		try{
			Admin admin=(Admin)ServletActionContext.getRequest().getSession().getAttribute(ConstantOur.SESSION_USERINFO);
			this.houseInfo.setAdmin(admin);
			ExecuteResult<String> result=this.houseInfoService.editHouse(this.houseInfo);
			if(result.isSuccess()){
				this.setUploadtypedir("_houseInfo_");
				this.uploadImgs(admin.getId(), this.houseInfo);
				super.successResponse("");
			}else{
				super.faileResponse(result.getResult());
			}
		}catch(Exception e){
			e.printStackTrace();
			super.faileResponse(ConstantOur.APP_ERROR_MSG);
		}
	}
	
	/**
	 * 跳转到房源编辑界面
	 * @return
	 */
	@Action(value="editHouse", results = { @Result(name = "editHouse", location = "/houseInfo/editHouse.jsp") })
	public String  editHouse(){
		this.houseInfo=this.houseInfoService.getId(this.houseInfo.getId());
		Pager<Picture> picPage=new Pager<Picture>();
		Picture pic=new Picture();
		pic.setHouseInfo(houseInfo);
		picPage=this.pictureService.findAll(picPage, pic);
		ServletActionContext.getRequest().setAttribute("pics", picPage.getRecords());
		super.pushModToRoot(houseInfo);
		return "editHouse";
	}	
	/**
	 * 删除房源
	 */
	@Action(value="delHouse")
	public void delHouse(){
		
		
	}
	private boolean uploadImgs(Integer userId,HouseInfo house){
		String path = ConstantOur.FILE_PATH+uploadtypedir;
		String dirpath="IDCARD_IMG"+userId;
		for(int i=0;i<files.length;i++){
			if(TipImageUtils.isImg(filesFileName[i])){
				 String fileName=TipImageUtils.reNameImg(filesFileName[i]);
		         File filedir=new File(path+dirpath);
		        try {
		           if(!filedir.exists()){
		        	   filedir.mkdirs();
		           }
		          FileUtils.copyFile(files[i], new File(filedir+File.separator+fileName));
		          Picture pic=new Picture();
		          pic.setHouseInfo(house);
		          pic.setFormatName(fileName);
		          pic.setName(filesFileName[i]);
		          pic.setPath(filedir.getPath());
		          this.pictureService.save(pic);
		        } catch (Exception e) {
		            e.printStackTrace();
		        }				
	    	 }else{
	    		 LOG.error("文件不是图片格式");
	    	 }
		}
       return true;
	
	}
	@Action(value="downloadHousePic")
	public void downloadHousePic(){
		try{
			File file = new File(picture.getPath()+File.separator+picture.getFormatName());// path是根据日志路径和文件名拼接出来的
		    String filename = picture.getName();// 获取日志文件名称
		    InputStream fis = new BufferedInputStream(new FileInputStream(file));
		    byte[] buffer = new byte[fis.available()];
		    fis.read(buffer);
		    fis.close();
		    getResponse().reset();
		    // 先去掉文件名称中的空格,然后转换编码格式为utf-8,保证不出现乱码,这个文件名称用于浏览器的下载框中自动显示的文件名
		    getResponse().addHeader("Content-Disposition", "attachment;filename=" + new String(filename.replaceAll(" ", "").getBytes("utf-8"),"iso8859-1"));
		    getResponse().addHeader("Content-Length", "" + file.length());
		    OutputStream os = new BufferedOutputStream(getResponse().getOutputStream());
		    getResponse().setContentType("application/octet-stream");
		    os.write(buffer);// 输出文件
		    os.flush();
		    os.close();
			}catch(Exception e){
				e.printStackTrace();
			}
	}	
	public HouseInfo getHouseInfo() {
		return houseInfo;
	}

	public void setHouseInfo(HouseInfo houseInfo) {
		this.houseInfo = houseInfo;
	}
	public Picture getPicture() {
		return picture;
	}
	public void setPicture(Picture picture) {
		this.picture = picture;
	}

	

	
	
	
	
}
