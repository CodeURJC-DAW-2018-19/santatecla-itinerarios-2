package daw.itinerary.controllers;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import daw.itinerary.unit.*;
import daw.itinerary.user.UserComponent;
import daw.itinerary.content.*;
import daw.itinerary.itineraries.ItineraryService;

@Controller
public class WebController
{

	@Autowired
	private UnitService unitService;

	@Autowired
	private ItineraryService itService;


	@Autowired
	private UserComponent userComponent;

	@Autowired
	private ContentService contentService;

	@ModelAttribute
	public void addUserToModel(Model model)
	{
		boolean logged = userComponent.getLoggedUser() != null;
		model.addAttribute("logged", logged);
		if(logged)
		{
			model.addAttribute("admin", userComponent.getLoggedUser().getRoles().contains("ROLE_ADMIN"));
			model.addAttribute("userName", userComponent.getLoggedUser().getName());
		}
	}


	@RequestMapping("/")
	public String index()
	{

		return "redirect:units";
	}

	@RequestMapping("/itinerary")
	public String itinerary()
	{
		return "itinerary";
	}

	@RequestMapping("/units/{units_id}/itinerary")
	public String itinerary(Model model)
	{
//		model.addAttribute("unit", unitService.findOne(id));
//		model.addAttribute("itinerary", itService.findAll());
		return "itinerary";
	}



	@RequestMapping("/units")
	public String units(Model model)
	{

		model.addAttribute("unit", unitService.findAll());

		return "units";
	}

	@GetMapping("/contents")
	public String contents(Model model)
	{

		model.addAttribute("content", contentService.findAll());

		model.addAttribute("images", images.values());

		return "contents";
	}

	/* Image uploading */

	private static final Path FILES_FOLDER = Paths.get(System.getProperty("user.dir"), "images");

	private Map<Integer, Image> images = new ConcurrentHashMap<>();
	private AtomicInteger imageId = new AtomicInteger();

	@PostConstruct
	public void init() throws IOException
	{

		if(!Files.exists(FILES_FOLDER))
		{
			Files.createDirectories(FILES_FOLDER);
		}
	}

	@PostMapping(value = "/contents/upload")
	public String imageUploaded(Model model, @RequestParam("file") MultipartFile file)
	{

		int id = imageId.getAndIncrement();

		String fileName = "image-" + id + ".jpg";

		if(!file.isEmpty())
		{
			try
			{
				File uploadedFile = new File(FILES_FOLDER.toFile(), fileName);
				file.transferTo(uploadedFile);

				images.put(id, new Image(id, fileName));
				return "upload";
			} catch(Exception e)
			{
				model.addAttribute("error", e.getClass().getName() + ":" + e.getMessage());

				return "upload";
			}
		} else
		{
			model.addAttribute("error", "The file is empty");
			return "upload";
		}

	}

	@GetMapping("/images/{id}")
	public void fileDownload(@PathVariable String id, HttpServletResponse res)
			throws FileNotFoundException, IOException
	{

		String fileName = "image-" + id + ".jpg";

		Path image = FILES_FOLDER.resolve(fileName);

		if(Files.exists(image))
		{
			res.setContentType("image/jpeg");
			res.setContentLength((int) image.toFile().length());
			FileCopyUtils.copy(Files.newInputStream(image), res.getOutputStream());

		} else
		{
			res.sendError(401, "File does not exist");
		}

	}

	@GetMapping("/error")
	public String error()
	{
		return "error";
	}


}
