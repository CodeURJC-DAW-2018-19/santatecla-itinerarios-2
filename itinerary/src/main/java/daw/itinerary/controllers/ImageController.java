package daw.itinerary.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import daw.itinerary.content.Content;
import daw.itinerary.content.ContentService;
import daw.itinerary.content.Image;

@Controller
public class ImageController {
	
	@Autowired
	private ContentService contentService;

	/* Image "downloading" */

	private static final Path FILES_FOLDER = Paths.get(System.getProperty("user.dir"), "images");

	@GetMapping("/images/{id}")
	public void fileDownload(@PathVariable String id, HttpServletResponse res)
			throws FileNotFoundException, IOException {
		
		String fileName = "image-" + id + ".jpg";

		Path image = FILES_FOLDER.resolve(fileName);
		
		if(Files.exists(image)) {
			res.setContentType("image/jpeg");
			res.setContentLength((int) image.toFile().length());
			FileCopyUtils.copy(Files.newInputStream(image), res.getOutputStream());
			
		} else {
			res.sendError(401, "File does not exist");
		}

	}
	
	@GetMapping("/contents")
	public String contents(Model model) {

		model.addAttribute("content", contentService.findAll());

		return "contents";
	}
	
	
	@GetMapping("/contents/editContent/{id}")
	public String editContent(Model model, @PathVariable long id) {
		
		Optional<Content> content = contentService.findOne(id);
		
		if(content.isPresent()) {
			model.addAttribute("content", content.get());
		}
		return "editContent";
	}
	
	@PostMapping("/contents/save/{id}")
	public String saveBook(Model model, Content content, @RequestParam("file") MultipartFile file, @PathVariable long id) {
		
//		Image handler
		
		String fileName = "image-" + id + ".jpg";

		if (!file.isEmpty()) {
			try {
				File uploadedFile = new File(FILES_FOLDER.toFile(), fileName);
				file.transferTo(uploadedFile);

				content.setImage(fileName);
				
				contentService.save(content);
				
				model.addAttribute("content", contentService.findAll());
				return "contents";
			} catch (Exception e) {
				model.addAttribute("error", e.getClass().getName() + ":" + e.getMessage());
				model.addAttribute("content", contentService.findAll());
				return "/contents";
			}
		} else {
			contentService.save(content);

			model.addAttribute("content", contentService.findAll());
			return "/contents";
		}
	}
}
