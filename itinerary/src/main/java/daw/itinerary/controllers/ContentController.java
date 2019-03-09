package daw.itinerary.controllers;

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
import org.springframework.stereotype.Controller;
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
import java.util.Optional;

@Controller
public class ContentController
{
    @Autowired
    private UnitService unitService;

    @Autowired
    private ContentService contentService;

    @Autowired
    private ContentRepository repo;

    @Autowired
    private UserComponent userComponent;

    @RequestMapping("/units/{id}/contents")
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

    private static final Path FILES_FOLDER = Paths.get(System.getProperty("user.dir"), "images");

    @GetMapping("/images/{id}")
    public void fileDownload(@PathVariable Long id, HttpServletResponse res)
            throws FileNotFoundException, IOException
    {

        String fileName = "image-" + id + ".jpg";

//        Path imagePath = FILES_FOLDER.resolve(fileName);
        byte[] image = contentService.findOne(id).get().getImageRaw();

            res.setContentType("image/jpeg");
//            res.setContentLength((int) image.toFile().length());
            FileCopyUtils.copy(image, res.getOutputStream());


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
                
                content.setImageRaw(file.getBytes());

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
    }
}
