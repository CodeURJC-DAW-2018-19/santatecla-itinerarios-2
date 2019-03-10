package daw.itinerary.api;

import daw.itinerary.content.Content;
import daw.itinerary.content.ContentRepository;
import daw.itinerary.content.ContentService;
import daw.itinerary.unit.Unit;
import daw.itinerary.unit.UnitService;
import daw.itinerary.user.UserComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Optional;

@RestController
public class ContentRestController {
	@Autowired
	private UnitService unitService;

	@Autowired
	private ContentRepository repo;

	@Autowired
	private UserComponent userComponent;

	@Autowired
	private ContentService contentService;

	/* Image "downloading" */
	private static final Path FILES_FOLDER = Paths.get(System.getProperty("user.dir"), "images");

	@RequestMapping("/api/units/{id}/contents")
	@ResponseStatus(HttpStatus.OK)
	public Page<Content> unitContents(Model model, @PathVariable long id, @PageableDefault(size = 10) Pageable page) {
		return repo.findAllByUnitId(id, page);
	}

	@GetMapping("/api/contents")
	public Collection<Content> getAllContents() {
		return contentService.findAll();
	}

	@PostMapping("/api/units/{id}/newContent")
	@ResponseStatus(HttpStatus.CREATED)
	public Content createContentInUnit(@RequestBody Content content, @PathVariable long id) {

		content.setUnit(unitService.findOne(id).get());
		contentService.save(content);
		return content;
	}

	@PutMapping("/api/units/{id}/contents/{content_id}/update")
	public Content updateContent(@PathVariable("content_id") long contentId, @RequestBody Content content) {
		Content originalContent = contentService.findOne(contentId).get();
		if (!content.getTitle().isEmpty()) {
			originalContent.setTitle(content.getTitle());
		}
		if (!content.getDesc().isEmpty()) {
			originalContent.setDesc(content.getDesc());
		}
		contentService.save(originalContent);
		return originalContent;
	}

	// This method was used when images where stored in file system
	/*
	 * @PostMapping("/api/units/{id}/contents/{content_id}/uploadImage") public
	 * Content uploadImageToContent(@PathVariable("id") long
	 * id, @PathVariable("content_id") long content_id,
	 * 
	 * @RequestParam("file") MultipartFile file) throws IllegalStateException,
	 * IOException { if (!file.isEmpty()) { String fileName = "image-" + content_id
	 * + ".jpg"; File uploadedFile = new File(FILES_FOLDER.toFile(), fileName);
	 * file.transferTo(uploadedFile); //
	 * contentService.findOne(content_id).get().setImage(fileName); } return
	 * contentService.findOne(content_id).get(); }
	 */

	@DeleteMapping("/api/units/{id}/contents/{content_id}/deleteContent")
	public Content deleteContent(@PathVariable("id") long id, @PathVariable long content_id) {
		Content content = contentService.findOne(content_id).get();
		if (contentService.findOne(content_id).isPresent()) {

			contentService.delete(content_id);
			return content;
		}

		return content;
	}

	/*
	 * @DeleteMapping("/api/units/{id}/deleteContent") public Content
	 * deleteContent(@PathVariable("id") long id, @RequestParam("content_id") long
	 * content_id) { Content content = contentService.findOne(content_id).get(); if
	 * (contentService.findOne(content_id).isPresent()) {
	 * 
	 * contentService.delete(content_id); return content; }
	 * 
	 * return content; }
	 */

	@PostMapping("/api/units/{id}/contents/{content_id}/uploadImage")
	public Content uploadImageToContentArray(@PathVariable("id") long id, @PathVariable("content_id") long content_id,
			@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
		Content originalContent = contentService.findOne(content_id).get();
		if (!file.isEmpty()) {
			FileInputStream inputStream = (FileInputStream) file.getInputStream();
			byte[] bytes = file.getBytes();
			contentService.findOne(content_id).get().setImageRaw(bytes);
			contentService.findOne(content_id).get().setHasImage(true);
			contentService.save(originalContent);
		}
		return contentService.findOne(content_id).get();
	}

}
