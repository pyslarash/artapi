package com.revature.Controller;

import com.revature.Model.Painting;
import com.revature.Service.PaintingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaintingController {

    PaintingService paintingService;

    @Autowired
    public PaintingController(PaintingService paintingService){
        this.paintingService = paintingService;
    }

    @PostMapping("artist/{id}/painting")
    public Painting postPainting(@PathVariable long id, @RequestBody Painting painting){
        return paintingService.savePainting(id, painting);
    }

    @GetMapping("painting")
    public List<Painting> getAllPaintings(){
        return paintingService.getAllPaintings();
    }

    @GetMapping(value = "painting", params = {"title"})
    public List<Painting> getPaintingByTitle(@RequestParam("title") String title){
        return paintingService.getAllPaintingsByTitle(title);
    }

    @GetMapping(value = "painting", params = {"genre"})
    public List<Painting> getPaintingByGenre(@RequestParam("genre") String genre){
        return paintingService.getAllPaintingsByGenre(genre);
    }

    @GetMapping(value = "painting", params = {"title", "genre"})
    public List<Painting> getPaintingByTitleAndGenre(@RequestParam("title") String title, @RequestParam("genre") String genre) {
        return paintingService.getAllPaintingsByTitleAndGenre(title, genre);
    }
}
