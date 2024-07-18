package ge.bog.nnagliashvilifinalproject.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import ge.bog.nnagliashvilifinalproject.dto.bookRefreshInfo;

import java.security.KeyManagementException;
import java.security.KeyStoreException;

public interface ApiServiceInt {
    static bookRefreshInfo callExternalApi(String name) throws KeyStoreException, KeyManagementException, JsonProcessingException {
        return null;

    }
//    void refreshAllBooks();


}
