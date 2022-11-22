package com.shayariwayari.app.ws.Shayari.ui.controller;

import com.shayariwayari.app.ws.Shayari.dto.ShayariDto;
import com.shayariwayari.app.ws.Shayari.service.ShayariService;
import com.shayariwayari.app.ws.Shayari.ui.model.request.ShayariDetailsRequestModel;
import com.shayariwayari.app.ws.Shayari.ui.model.response.ShayariRest;
import com.shayariwayari.app.ws.user.ui.model.response.OperationStatusModel;
import com.shayariwayari.app.ws.user.ui.model.response.RequestOperationName;
import com.shayariwayari.app.ws.user.ui.model.response.RequestOperationStatus;
import com.shayariwayari.app.ws.user.ui.model.response.UserRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/shayaris")
public class ShayariController {
    @Autowired
    private ShayariService shayariService;

    @PostMapping
    public ShayariRest addShayari(@RequestBody ShayariDetailsRequestModel shayariDetailsRequestModel){
        ShayariDto shayariDto = new ShayariDto();
        BeanUtils.copyProperties(shayariDetailsRequestModel,shayariDto);
        ShayariDto savedShayari = shayariService.addShyari(shayariDto);
        ShayariRest returnValue = new ShayariRest();
        BeanUtils.copyProperties(savedShayari,returnValue);
        return returnValue;
    }

    @GetMapping
    public List<ShayariRest> getShayaris(@RequestParam(value="page", defaultValue = "0") int page,
                                         @RequestParam(value="limit", defaultValue = "25") int limit)
    {
        List<ShayariDto> shayaris = shayariService.getShayaris(page, limit);
        List<ShayariRest> returnValue = new ArrayList<>();
        for(ShayariDto shayari:shayaris){
            ShayariRest shayariRest = new ShayariRest();
            BeanUtils.copyProperties(shayari,shayariRest);
            returnValue.add(shayariRest);
        }
        return returnValue;
    }
    @DeleteMapping(path="/{id}")
    public OperationStatusModel deleteShayari(@PathVariable String id){
        shayariService.deleteShyari(id);
        OperationStatusModel returnValue = new OperationStatusModel(RequestOperationName.DELETE.name(),
                RequestOperationStatus.SUCCESS.name());
        return  returnValue;
    }

    @PutMapping
    public ShayariRest updateShayari(@RequestParam ShayariDetailsRequestModel shayariDetailsRequestModel){
        ShayariDto shayariDto = new ShayariDto();
        BeanUtils.copyProperties(shayariDetailsRequestModel,shayariDto);
        ShayariDto updatedShayari = shayariService.updateShyari(shayariDto);
        ShayariRest returnValue = new ShayariRest();
        BeanUtils.copyProperties(updatedShayari,returnValue);
        return returnValue;
    }
}
