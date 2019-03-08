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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Optional;

@RestController
public class ContentRestController
{
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
    public Page<Content> unitContents(Model model, @PathVariable long id, @PageableDefault(size = 10) Pageable page)
    {
        return repo.findAllByUnitId(id, page);
    }
    
    @GetMapping("/api/contents")
    public Collection<Content> getAllContents(){
    	return contentService.findAll();
    }
    
    @PostMapping("/api/units/{id}/newContent")
    @ResponseStatus(HttpStatus.CREATED)
    public Content createContentInUnit(@RequestBody Content content, @PathVariable long id ) {

    	content.setUnit(unitService.findOne(id).get());
    	contentService.save(content);
    	return content;
    }
    @PostMapping("/api/units/{id}/contents/{content_id}/uploadImage")
    public Content uploadImageToContent(@PathVariable("content_id") long content_id, @RequestParam("file") MultipartFile file) throws IllegalStateException, IOException{
    	if (!file.isEmpty()) {
    		String fileName = "image-" + content_id + ".jpg";
    	    File uploadedFile = new File(FILES_FOLDER.toFile(), fileName);
    	    file.transferTo(uploadedFile);
    		contentService.findOne(content_id).get().setImage(fileName);
    }
    	return contentService.findOne(content_id).get();
    	
    }

    
    
    /*@RequestMapping("/units/{id}/contents")
    public String contents(Model model, @PathVariable long id, @PageableDefault(size = 10) Pageable page)
    {
        boolean logged = userComponent.getLoggedUser() != null;
        model.addAttribute("logged", logged);

        Page<Content> contents = repo.findAllByUnitId(id, page);
        model.addAttribute("contentsPage", contents);

        Unit unit = unitService.findOne(id).get();
        model.addAttribute("units", unit);
        model.addAttribute("unit", unitService.findAll());
        model.addAttribute("contents", unit.getContents());

        if(logged)
        {
            model.addAttribute("admin", userComponent.getLoggedUser().getRoles().contains("ROLE_ADMIN"));
        }
        return "contents";
    }

    @RequestMapping("/units/{id}/contents/list")
    public String contentsList(Model model, @PathVariable long id, @PageableDefault(size = 10) Pageable page)
    {
        boolean logged = userComponent.getLoggedUser() != null;
        model.addAttribute("logged", logged);

        Page<Content> contents = repo.findAllByUnitId(id, page);
        model.addAttribute("contentsPage", contents);

        Unit unit = unitService.findOne(id).get();
        model.addAttribute("units", unit);
        model.addAttribute("unit", unitService.findAll());
        model.addAttribute("contents", unit.getContents());

        if(logged)
        {
            model.addAttribute("admin", userComponent.getLoggedUser().getRoles().contains("ROLE_ADMIN"));
        }
        return "contentsList";
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

    @GetMapping("/contents")
    public String contents(Model model)
    {

        boolean logged = userComponent.getLoggedUser() != null;
        model.addAttribute("logged", logged);
        model.addAttribute("content", contentService.findAll());

        return "contents";
    }

    @GetMapping("/units/{units.id}/contents/newContent/")
    public String newContent(Model model, @PathVariable("units.id") long id)
    {
        boolean logged = userComponent.getLoggedUser() != null;
        model.addAttribute("logged", logged);
        return "newContent";

    }

    @PostMapping("/units/{units.id}/contents/newContent/save/")
    public String saveContent(Model model, Content content, @RequestParam("file") MultipartFile file,
                              @PathVariable("units.id") long unitId)
    {
        if(content.getTitle().isEmpty())
        {
            return "redirect:/units/{units.id}/contents";
        }
        if(!file.isEmpty())
        {
            try
            {
                contentService.save(content);
                String fileName = "image-" + content.getId() + ".jpg";
                File uploadedFile = new File(FILES_FOLDER.toFile(), fileName);
                file.transferTo(uploadedFile);

                content.setImage(fileName);
                content.setUnit(unitService.findOne(unitId).get());

                contentService.save(content);
                Unit unit = unitService.findOne(unitId).get();
                model.addAttribute("units", unit);
                model.addAttribute("unit", unitService.findAll());
                model.addAttribute("contents", unit.getContents());
                // In previous version we use "contents", no redirect
                // Change it because a bug
                return "redirect:/units/{units.id}/contents";
            } catch(Exception e)
            {
                model.addAttribute("error", e.getClass().getName() + ":" + e.getMessage());
                model.addAttribute("content", contentService.findAll());
                // In previous version we use "/contents", no redirect
                // Change it because a bug
                return "redirect:/units/{units.id}/contents";
            }
        } else
        {
            content.setUnit(unitService.findOne(unitId).get());
            contentService.save(content);
            Unit unit = unitService.findOne(unitId).get();
            model.addAttribute("units", unit);
            model.addAttribute("unit", unitService.findAll());
            model.addAttribute("contents", unit.getContents());

            model.addAttribute("content", contentService.findAll());
            return "redirect:/units/{units.id}/contents";
        }
    }


    @GetMapping("/units/{units.id}/contents/edit/{id}/")
    public String editContent(Model model, @PathVariable long id)
    {

        Optional<Content> content = contentService.findOne(id);

        if(content.isPresent())
        {
            boolean logged = userComponent.getLoggedUser() != null;
            model.addAttribute("logged", logged);
            model.addAttribute("content", content.get());
        }
        return "editContent";
    }

    @PostMapping("/units/{units.id}/contents/edit/{id}/save")
    public String saveContent(Model model, Content content, @RequestParam("file") MultipartFile file, @PathVariable long id,
                              @PathVariable("units.id") long unitId)
    {

//		Image handler
        if(content.getTitle().isEmpty())
        {
            return "redirect:/units/{units.id}/contents";
        }
        String fileName = "image-" + id + ".jpg";

        if(!file.isEmpty())
        {
            try
            {
                File uploadedFile = new File(FILES_FOLDER.toFile(), fileName);
                file.transferTo(uploadedFile);

                content.setImage(fileName);
                content.setUnit(unitService.findOne(unitId).get());
                contentService.save(content);

                Unit unit = unitService.findOne(unitId).get();
                model.addAttribute("units", unit);
                model.addAttribute("unit", unitService.findAll());
                model.addAttribute("contents", unit.getContents());
                return "redirect:/units/{units.id}/contents";
            } catch(Exception e)
            {
                model.addAttribute("error", e.getClass().getName() + ":" + e.getMessage());
                model.addAttribute("content", contentService.findAll());
                return "redirect:/units/{units.id}/contents";
            }
        } else
        {
            content.setUnit(unitService.findOne(unitId).get());
            contentService.save(content);
            Unit unit = unitService.findOne(unitId).get();
            model.addAttribute("units", unit);
            model.addAttribute("unit", unitService.findAll());
            model.addAttribute("contents", unit.getContents());

            model.addAttribute("content", contentService.findAll());
            return "redirect:/units/{units.id}/contents";
        }
    }*/
}
