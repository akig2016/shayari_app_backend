package com.shayariwayari.app.ws.Shayari.io.repositories;
import com.shayariwayari.app.ws.Shayari.io.document.ShayariDocumentModel;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface ShayariRepository extends MongoRepository<ShayariDocumentModel,String>{

}
