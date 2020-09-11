package com.busyvacation.happyclass.controller;

import java.io.IOException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.busyvacation.happyclass.db.service.StorageService;
import com.busyvacation.happyclass.exception.StorageFileNotFoundException;

@Controller
@RequestMapping("/files")
public class FileUploadController {
	
	@Autowired
	private StorageService storageService;
	
	@RequestMapping(value= {"","/"}, method=RequestMethod.GET)
	public String files(Model model) throws IOException {
		model.addAttribute("files", storageService.loadAll().map(
				path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
				"serveFile", path.getFileName().toString()).build().toString())
				.collect(Collectors.toList()));
		
		return "uploadForm";
		}
	@RequestMapping(value="/{filename:.+}", method=RequestMethod.GET)
	public ResponseEntity<Resource> serveFile(@PathVariable String filename){
	Resource file = storageService.loadAsResource(filename);
	return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
	"attachment; filename=\"" + file.getFilename() + "\"").body(file);

	}

	@RequestMapping(value={"", "/"}, method=RequestMethod.POST)
	public String handleFileUpload(@RequestParam("file") MultipartFile file,
	RedirectAttributes redirectAttributes) {

	storageService.store(file);
	redirectAttributes.addFlashAttribute("message",
	"성공!! " + file.getOriginalFilename() + "!");

	return "redirect:/files";
	}

	@ExceptionHandler(StorageFileNotFoundException.class)
	public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
	return ResponseEntity.notFound().build();
	}
	}


