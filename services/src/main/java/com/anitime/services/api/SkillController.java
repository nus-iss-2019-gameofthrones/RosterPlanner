package com.anitime.services.api;

import com.anitime.services.db.SkillRepository;
import com.anitime.services.model.Skill;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/skill")
@CrossOrigin
public class SkillController {

    private SkillRepository skillRepository;

    public SkillController(SkillRepository skillRepository){
        this.skillRepository = skillRepository;
    }

    @GetMapping("/all")
    public List<Skill> all(){
        return this.skillRepository.findAll();
    }

    @PostMapping("/save")
    public Skill save(@RequestBody Skill skill, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new ValidationException();
        }

        this.skillRepository.save(skill);

        return skill;
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable String id){
        this.skillRepository.deleteById(UUID.fromString(id));
    }

}
