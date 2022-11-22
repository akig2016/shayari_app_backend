package com.shayariwayari.app.ws.Shayari.service.impl;

import com.shayariwayari.app.ws.Shayari.dto.ShayariDto;
import com.shayariwayari.app.ws.Shayari.io.document.ShayariDocumentModel;
import com.shayariwayari.app.ws.Shayari.io.repositories.ShayariRepository;
import com.shayariwayari.app.ws.Shayari.service.ShayariService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ShayariServiceImpl implements ShayariService {
    @Autowired
    ShayariRepository shayariRepository;
    @Override
    public ShayariDto addShyari(ShayariDto shayari) {
        ShayariDocumentModel shayariDocumentModel = new ShayariDocumentModel();
        BeanUtils.copyProperties(shayari,shayariDocumentModel);
        shayariDocumentModel.setCreatedAt(new Date());
        shayariDocumentModel.setUpdatedAt(shayariDocumentModel.getUpdatedAt());
        ShayariDocumentModel savedShayari = shayariRepository.save(shayariDocumentModel);
        ShayariDto returnValue = new ShayariDto();
        BeanUtils.copyProperties(savedShayari,returnValue);
        return returnValue;
    }

    @Override
    public void deleteShyari(String id) {
        Optional<ShayariDocumentModel> shayari = shayariRepository.findById(id);
        if(!shayari.isPresent()) throw new NoSuchElementException();
        shayariRepository.deleteById(id);
    }

    @Override
    public ShayariDto updateShyari(ShayariDto shyariData) {
        Optional<ShayariDocumentModel> shayari = shayariRepository.findById(shyariData.getShayariId());
        if(!shayari.isPresent()) throw new NoSuchElementException();
        ShayariDocumentModel shayariRepoData = shayari.get();
        shayariRepoData.setTitle(shyariData.getTitle());
        shayariRepoData.setMessage(shyariData.getMessage());
        shayariRepoData.setImageUrl(shyariData.getImageUrl());
        shayariRepoData.setMediaType(shayariRepoData.getMediaType());
        shayariRepoData.setMediaUrl(shayariRepoData.getMediaUrl());
        shayariRepoData.setCategoryTags(shyariData.getCategoryTags());
        shayariRepoData.setUpdatedAt(new Date());
        ShayariDto returnValue = new ShayariDto();
        ShayariDocumentModel updatedShayari = shayariRepository.save(shayariRepoData);
        BeanUtils.copyProperties(updatedShayari,returnValue);
        return returnValue;
    }

    @Override
    public List<ShayariDto> getShayaris(int page, int limit) {
        Pageable paging = PageRequest.of(page, limit);
        Page<ShayariDocumentModel> shayariPages = shayariRepository.findAll(paging);
        List<ShayariDocumentModel> shayaris = shayariPages.getContent();
        List<ShayariDto> returnValue = new ArrayList<>();
        for(ShayariDocumentModel shayari:shayaris){
            ShayariDto shayariDto = new ShayariDto();
            BeanUtils.copyProperties(shayari,shayariDto);
            returnValue.add(shayariDto);
        }
        return returnValue;
    }

}
