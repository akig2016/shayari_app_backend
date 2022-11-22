package com.shayariwayari.app.ws.Shayari.service;

import com.shayariwayari.app.ws.Shayari.dto.ShayariDto;

import java.util.List;

public interface ShayariService {
    ShayariDto addShyari(ShayariDto shyari);
    void deleteShyari(String id);
    ShayariDto updateShyari(ShayariDto shyari);
    List<ShayariDto> getShayaris(int page, int limit);
}
