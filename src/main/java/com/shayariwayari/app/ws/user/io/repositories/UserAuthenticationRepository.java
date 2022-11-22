package com.shayariwayari.app.ws.user.io.repositories;

import com.shayariwayari.app.ws.user.io.document.UserDocumentModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserAuthenticationRepository extends MongoRepository<UserDocumentModel,String> {
    UserDocumentModel findByEmail(String email);
}
