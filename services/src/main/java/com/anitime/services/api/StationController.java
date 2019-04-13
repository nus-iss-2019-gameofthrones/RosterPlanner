package com.anitime.services.api;

import com.anitime.services.db.StationRepository;
import com.anitime.services.model.Station;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/station")
@CrossOrigin
public class StationController {

    private StationRepository stationRepository;

    public StationController(StationRepository skillRepository){
        this.stationRepository = skillRepository;
    }

    @GetMapping("/all")
    public List<Station> all(){
        return this.stationRepository.findAll();
    }

    @PostMapping("/save")
    public Station save(@RequestBody Station station, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new ValidationException();
        }

        Station sta1 = new Station(station.getName());
        this.stationRepository.save(sta1);

        return station;
    }

    @PostMapping("/update")
    public Station update(@RequestBody Station station, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new ValidationException();
        }
        this.stationRepository.save(station);

        return station;
    }

    @GetMapping("/getEmp/{id}")
    public Optional<Station> getSta(@PathVariable int id){
        return this.stationRepository.findById(id);
    }
    
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable String id){
        this.stationRepository.deleteById(UUID.fromString(id));
    }

}
