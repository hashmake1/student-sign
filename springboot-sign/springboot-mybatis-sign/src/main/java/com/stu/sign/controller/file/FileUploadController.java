package com.stu.sign.controller.file;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class FileUploadController {
	
	@RequestMapping(value = "/uploadFileAction", method = RequestMethod.POST)
	public String uploadFileAction(@RequestParam("uploadFile") MultipartFile uploadFile, @RequestParam("id") Long id) {
		Map<String, Object> map = new HashMap<String, Object>();
		InputStream fis = null;
		OutputStream outputStream = null;
		try {
			fis = uploadFile.getInputStream();
			outputStream = new FileOutputStream(System.getProperty("user.home")+ "\\" + uploadFile.getOriginalFilename());
			IOUtils.copy(fis, outputStream);
			map.put("sucess", "上传成功");
//			return map;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		map.put("sucess", "上传失败!");
		return "h5/app";
	}

	@RequestMapping("downloadFileAction")
	public void downloadFileAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		response.setCharacterEncoding(request.getCharacterEncoding());
//		response.setContentType("application/octet-stream");
//		FileInputStream fis = null;
//		try {
//			File file = new File(System.getProperty("user.dir") + "/src/main/resources/task/后台思路整理.rtf");
//			fis = new FileInputStream(file);
//			response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
//			IOUtils.copy(fis, response.getOutputStream());
//			response.flushBuffer();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			if (fis != null) {
//				try {
//					fis.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	    String fileName = request.getParameter("fileName");
	    File file = new File(System.getProperty("user.home"), "soapui-settings.xml");
	    response.setContentType("application/octet-stream");
	    response.setHeader("Content-Disposition","attachment;filename=" + "soapui-settings.xml");
	    response.setContentLength((int) file.length());
	    
	    FileInputStream fis = null;
	    try {
	        fis = new FileInputStream(file);
	        byte[] buffer = new byte[128];
	        int count = 0;
	        while ((count = fis.read(buffer)) > 0) {
	        	response.getOutputStream().write(buffer, 0, count);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	    	response.getOutputStream().flush();
	    	response.getOutputStream().close();
	        fis.close();
	    }
	}

	// 访问路径为：http://127.0.0.1:8080/file
	@RequestMapping("/file")
	public String file() {
		return "/file";
	}

	/**
	 * 文件上传具体实现方法;
	 * 
	 * @param file
	 * @return
	 */
	@RequestMapping("/upload")
	@ResponseBody
	public String handleFileUpload(@RequestParam("file") MultipartFile file) {
		if (!file.isEmpty()) {
			String saveFileName = file.getOriginalFilename();
			File saveFile = new File("D:\\student\\" + saveFileName);
			if (!saveFile.getParentFile().exists()) {
				saveFile.getParentFile().mkdirs();
			}
			try {
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(saveFile));
				out.write(file.getBytes());
				out.flush();
				out.close();
				return " 上传成功";
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return "上传失败";
			} catch (IOException e) {
				e.printStackTrace();
				return "上传失败";
			}
		} else {
			return "上传失败，因为文件为空";
		}
	}

	/////////////////// 多文件上传.///////////////////////////
	// 访问：http://127.0.0.1:8080/mutifile
	@RequestMapping(value = "/mutifile", method = RequestMethod.GET)
	public String provideUploadInfo1() {
		return "/mutifile";
	}

	/**
	 * 多文件具体上传时间，主要是使用了MultipartHttpServletRequest和MultipartFile
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/batch/upload", method = RequestMethod.POST)
	public @ResponseBody String handleFileUpload1(HttpServletRequest request) {
		List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
		MultipartFile file = null;
		BufferedOutputStream stream = null;
		for (int i = 0; i < files.size(); ++i) {
			file = files.get(i);
			if (!file.isEmpty()) {
				try {
					byte[] bytes = file.getBytes();
					stream = new BufferedOutputStream(new FileOutputStream(new File(file.getOriginalFilename())));
					stream.write(bytes);
					stream.close();
				} catch (Exception e) {
					stream = null;
					return "You failed to upload " + i + " => " + e.getMessage();
				}
			} else {
				return "You failed to upload " + i + " because the file was empty.";
			}
		}
		return "upload successful";
	}
}
