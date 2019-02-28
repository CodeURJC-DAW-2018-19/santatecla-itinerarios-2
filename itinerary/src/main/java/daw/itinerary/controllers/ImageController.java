package daw.itinerary.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
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

import daw.itinerary.content.ContentService;
import daw.itinerary.content.Image;

@Controller
public class ImageController {
	
	@Autowired
	private ContentService contentService;

	/* Image uploading */

	private static final Path FILES_FOLDER = Paths.get(System.getProperty("user.dir"), "images");

	private Map<Integer, Image> images = new ConcurrentHashMap<>();
	private AtomicInteger imageId = new AtomicInteger();

	@PostConstruct
	public void init() throws IOException {

		if (!Files.exists(FILES_FOLDER)) {
			Files.createDirectories(FILES_FOLDER);
		}
	}

	@PostMapping(value = "/contents/upload/{id}")
	public String imageUploaded(Model model, @RequestParam("file") MultipartFile file, @PathVariable Long id) {
		

		String fileName = "image-" + id + ".jpg";

		if (!file.isEmpty()) {
			try {
				File uploadedFile = new File(FILES_FOLDER.toFile(), fileName);
				file.transferTo(uploadedFile);

//				images.put(id, new Image(id, fileName));

				model.addAttribute("images", images.values());
				model.addAttribute("content", contentService.findAll());
				return "/contents";
			} catch (Exception e) {
				model.addAttribute("error", e.getClass().getName() + ":" + e.getMessage());
				model.addAttribute("content", contentService.findAll());
				return "/contents";
			}
		} else {
			model.addAttribute("error", "The file is empty");
			return "/contents";
		}

	}

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

		model.addAttribute("images", images.values());

		return "contents";
	}
}
