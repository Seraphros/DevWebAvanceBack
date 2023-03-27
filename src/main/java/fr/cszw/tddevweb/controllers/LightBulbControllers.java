package fr.cszw.tddevweb.controllers;

import fr.cszw.tddevweb.models.LightBulb;
import fr.cszw.tddevweb.services.LightBulbService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class LightBulbControllers {

    private LightBulbService lightBulbService;

    public LightBulbControllers(LightBulbService lightBulbService) {
        this.lightBulbService = lightBulbService;
    }

    @GetMapping("hello-world")
    public String helloWorld() {
        return "hello-world";
    }


    @GetMapping("bulb")
    public List<LightBulb> getLightBulbList() {
        return lightBulbService.getLightBulbList();
    }

    @PostMapping("bulb")
    public ResponseEntity addLightBulb() {
        this.lightBulbService.addLightBulb();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("bulb")
    public ResponseEntity removeLightBulb() {
        this.lightBulbService.removeLightBulb();
        return ResponseEntity.ok().build();
    }

    @PatchMapping("bulb")
    public ResponseEntity updateLightBulbState(@RequestParam("id") int id) {
        try {
            this.lightBulbService.toggleLightBulbState(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("errortest")
    public ResponseEntity error() {
        return ResponseEntity.internalServerError().build();
    }
}
