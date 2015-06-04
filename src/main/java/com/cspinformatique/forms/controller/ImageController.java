package com.cspinformatique.forms.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/image")
public class ImageController implements InitializingBean {
	private List<String> supportedExtensions = Arrays.asList(new String[] {
			"jpeg", "jpg", "png" });

	@Value("${upload.folder.path}")
	private String fileUploadDestionation;

	@Override
	public void afterPropertiesSet() throws Exception {
		new File(fileUploadDestionation).mkdirs();
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
	public @ResponseBody String handleFileUpload(
			@RequestParam("file") MultipartFile file) {
		String fileExtension = file.getOriginalFilename().substring(
				file.getOriginalFilename().lastIndexOf(".")+1).toLowerCase();

		if (!supportedExtensions.contains(fileExtension)) {
			throw new RuntimeException("L'extension " + fileExtension
					+ " n'est pas supporté.");
		}

		try {
			byte[] bytes = file.getBytes();

			String filename = new Date().getTime() + "." + fileExtension;

			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File(fileUploadDestionation + "/"
							+ filename)));

			stream.write(bytes);
			stream.close();

			return filename;
		} catch (IOException ioEx) {
			throw new RuntimeException(ioEx);
		}
	}
}
