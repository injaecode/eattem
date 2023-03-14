package com.mysite.eattem.Article;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImgService {

	private final FileService fileService;
	
	@Value("${itemImgLocation}")
	private String imgLocation;
	
	public String returnImg(MultipartFile img) throws Exception{
		String oriName =img.getOriginalFilename();
		String name="";
		String url="";
		if (!StringUtils.isEmpty(oriName)) {
			name=fileService.uploadFile(imgLocation, oriName, img.getBytes());
			return url="/imges/item/"+name;
		}
		
		return null;
	}
	
}
